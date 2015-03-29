$(function() {
	
	if($.cookie('cookieName')){
		$('#iyoutingche-topright').hide();
	}
	if($.cookie('cookieName')!="null" && $.cookie('cookieName')!=null){
		$("#iyoutingche-topleft").show();
		$("#iyoutingche-topleft").append("<a href='/iyoutingche'><button class='btn btn-primary nav-btn' id='quit'>退出</button></a>"+"<a href='userFindByEmail?email="+$.cookie('cookieName')+"'> " +
			"欢迎您,"+$.cookie('cookieName')+" </a>");
	}else{
		$("#iyoutingche-topleft").hide();
	}
	
	$("#quit").click(function(){
		 if(window.confirm('你确定要退出？')){
			 //$.cookie('cookieName',null);
			$.removeCookie('cookieName');
			// $.cookie('cookieName', '', {expires: -1});
		//	 alert("==="+cookieSave);
		//	 location.reload();
            return true;
         }else{
            return false;
        }
	});
	
	$.ajax({
		type : "post",
		url : 'findByDecoptCode',
		data : {
			depotcode : $('#depotcode').html(),
		},
		success : function(data) {
			json = $.parseJSON(data);
			$('#Pcar_count').html(json.count);
			if (json.order == '0') {
				$('#btn_order').attr("disabled", 'true');
			} else {
				$('#btn_order').html('仅有' + json.order + '位可以预约');
			}
			$('#btn_order').on('click',function() {
				if(!$.cookie('cookieName')){
					/*alert($.cookie('cookieName'));*/
					$('#modal_login').modal('show');
					return false;
				}
				$(this).button('loading');
				$.ajax({
					type : 'post',
					url : 'OrderPcar',
					data : {
						depotcode : $('#depotcode').html(),
						userid : $.cookie('cookieName'),
					},
					success : function(data) {
						/*alert('da='+data);*/
						if(data=='true'){
							alert('预约成功！');
							$('#btn_order').attr("disabled", 'true');
							$('#btn_order').html('仅有' + (json.order - 1) + '位可以预约');
						}else{
							alert('预约失败！');
						}
						
					}

				});
				
				
			});
		}
	});

	var x = $("#depot_x").html();
	/* alert($("#depot_x").html()); */
	var y = $("#depot_y").html();

	var map = new BMap.Map("show_mapinfo");// 在百度地图容器中创建一个地图
	var point = new BMap.Point(x, y);// 定义一个中心点坐标
	map.centerAndZoom(point, 16);// 设定地图的中心点和坐标并将地图显示在地图容器中
	var marker = new BMap.Marker(point); // 创建标注
	map.addOverlay(marker); // 将标注添加到地图
	map.enableScrollWheelZoom(true);// 开启缩放
	map.enableDragging();// 开启拖拽

	map.addControl(new BMap.NavigationControl());
	map.addControl(new BMap.ScaleControl());
	map.addControl(new BMap.OverviewMapControl());
	map.addControl(new BMap.MapTypeControl());
	marker.setAnimation(BMAP_ANIMATION_BOUNCE); // 设置弹跳动画
	/*
	 * 登录表单验证
	 **/
	$("#LoginForm").validate({
		rules:{
			user_email: {
				required: true,
				email:true
			},
			user_password:{
				required:true,
				minlength: 5,
			},
		},
		messages:{
			user_email:{
				required:"请输入邮箱",
				 email: "请输入正确的email地址"
			},
			user_password:{
					required:"请输入密码",
					minlength: jQuery.validator.format("输入不小于5位数的字符"),
			},
		},
		submitHandler:function(form){
			$(form).ajaxSubmit({
				url:'UserCheckLoginSer',
				type:'POST',
				success:function(data){
					if(data=="true"){
						var email = $("#email").val();
						//设置cookie

						$.cookie('cookieName',email,{
							expires: 7,
						});

						location.reload();
					}else{
						$("#info").append("<b>错误的用户名或密码</b><br/>");
					}
				}
			});
		}
	});

});