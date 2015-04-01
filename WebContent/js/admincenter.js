/**
 * 管理员的js文件
 */
$(document).ready(function(){
	/**
	 * 修改基本信息
	 */
	$("#adminbaseInfo").validate({
		rules:{
			adminname:{
				required:true,
				minlength: 5,
			},
			adminsex:{
				required:true,
			},
			adminphone:{
				required:true,
				isTel:true,
			},
		},
		messages:{
			adminname:{
				required:"请输入用户名",
				minlength:jQuery.validator.format("输入不小于5位数的字符"),
			},
			adminsex:{
				required:"请选择性别",
			},
			adminphone:{
				required:"请输入手机号",
				isTel:"手机号码格式不正确",
			},
		},
		submitHandler:function(form){
			$(form).ajaxSubmit({
				type:'POST',
				  url:'adminJsonModifySer',
				  data:{
				  			adminid: $("#adminid").val(),
				  			adminemail:  $("#adminemail").val(),
			  			},
			  	contentType: "application/x-www-form-urlencoded; charset=utf-8", 
	  			success: function(data){
			  				if(data=='true'){
			  					alert("修改成功");
			  				}else{
			  					alert("修改失败");
			  				}
	  			   }
			});
		},
	});
	 
	 /**
	  * 修改密码
	  */
	 $("#adminChange").validate({
			rules:{
				adminpass: {
					required: true,
					minlength:6,
					equalTo: "#hiddenpass"
				},
				newadminpass:{
					required:true,
					minlength:6
				},
				newreadminpass:{
					required:true,
					equalTo: "#newadminpass",
					minlength:6
				}
			},
			messages:{
				adminpass: {
					required: "原密码不能为空",
					minlength:jQuery.validator.format("输入不小于6位数的字符"),
					equalTo:"密码输入错误",
				},
				newadminpass: {
					required: '密码不能为空',
					minlength:jQuery.validator.format("输入不小于6位数的字符"),
				},
				newreadminpass:{
					required: '密码不能为空',
					minlength:jQuery.validator.format("输入不小于6位数的字符"),
					equalTo:"请输入正确的确定密码",
				}
			},
			submitHandler:function(form){
				$(form).ajaxSubmit({
					type:'POST',
					  url:'adminModifyPassword',
					 /* data:{
					  			email:  $("#email").val(),
				  			},*/
				  	contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		  			success: function(data){
				  				if(data=="true"){
				  					alert("修改成功");
				  				}else{
				  					alert("修改失败");
				  				}
		  			   }
				});
			},
		});
	 /**
	  * 添加管理员信息
	  */
	 $("#adminAddForm").validate({
			rules:{
				adminname:{
					required:true,
					minlength: 5,
				},
				adminemail:{
					required:true,
					email: true,
				},
				adminsex:{
					required:true,
				},
				adminphone:{
					required:true,
					isTel:true,
				},
			},
			messages:{
				adminname:{
					required:"请输入用户名",
					minlength:jQuery.validator.format("输入不小于5位数的字符"),
				},
				adminemail:{
					required:"请输入邮箱号",
					email: "邮箱号格式不正确",
				},
				adminsex:{
					required:"请选择性别",
				},
				adminphone:{
					required:"请输入手机号",
					isTel:"手机号码格式不正确",
				},
			},
			submitHandler:function(form){
				$(form).ajaxSubmit({
					type:'POST',
					  url:'AdminRegister',
				  	contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		  			success: function(data){
				  				if(data=="n"){
				  					$("#add").append("该邮箱已被注册<br/>");
				  				}else if(data=="true"){
				  					alert("添加成功");
				  				}else{
				  					alert("添加失败");
				  				}
		  			   }
				});
			},
		});
	 /**
	  * 管理员登录界面验证
	  */
	 $("#adminLogin").validate({
			rules:{
				adminemail:{
					required:true,
					email: true,
				},
				adminpassword:{
					required:true,
					minlength:6,
				},
			},
			messages:{
				adminemail:{
					required:"请输入邮箱号",
					email: "邮箱号格式不正确",
				},
				adminpassword:{
					required:"请输入密码",
					minlength:jQuery.validator.format("输入不小于6位数的字符"),
				},
				
			},
			submitHandler:function(form){
				$(form).ajaxSubmit({
					type:'POST',
					  url:'AdminLoginSer',
				  	contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		  			success: function(data){
				  			if(data=="true"){
				  				location.href="admin/adminFrame.jsp";
				  			}else{
				  				$("#login").append("用户名或密码错误<br/>");
				  				 window.setTimeout("GetRTime()",2000);
				  			}	
		  			   }
				});
			},
		});
	 /**
	  * 调用百度地图获取经纬度坐标
	  */
	 $("#depot_coord").mouseout(function(){
		 var address = $("#depot_province").val()+ $("#depot_city").val()+ $("#depot_region").val();
		 /*alert("address="+address);*/
		 if(address.length!=0){
			// 百度地图API功能
				var map = new BMap.Map("iyoutingche-center-rright");
				var point = new BMap.Point(116.331398,39.897445);
				map.centerAndZoom(point,12);
				// 创建地址解析器实例
				var myGeo = new BMap.Geocoder();
				window.map = map;
				// 将地址解析结果显示在地图上,并调整地图视野
				myGeo.getPoint(address, function(point){
					if (point) {
						map.centerAndZoom(point, 16);
						map.addOverlay(new BMap.Marker(point));
					}else{
						alert("您选择地址没有解析到结果!");
					}
				}, $("#depot_city").val());
				 addMapControl();
				 setMapEvent();
				 map.addEventListener("click",function(e){
					 var coord = e.point.lng + "," + e.point.lat;
					 $("#depot_coord").val(coord);
						//alert(e.point.lng + "," + e.point.lat);
					});
		 }
	 });
	//地图控件添加函数：
	    function addMapControl(){
	        //向地图中添加缩放控件
		var ctrl_nav = new BMap.NavigationControl({anchor:BMAP_ANCHOR_TOP_LEFT,type:BMAP_NAVIGATION_CONTROL_LARGE});
		map.addControl(ctrl_nav);
	        //向地图中添加缩略图控件
		var ctrl_ove = new BMap.OverviewMapControl({anchor:BMAP_ANCHOR_BOTTOM_RIGHT,isOpen:1});
		map.addControl(ctrl_ove);
	        //向地图中添加比例尺控件
		var ctrl_sca = new BMap.ScaleControl({anchor:BMAP_ANCHOR_BOTTOM_LEFT});
		map.addControl(ctrl_sca);
	    }
	    //地图事件设置函数：
	    function setMapEvent(){
	        map.enableDragging();//启用地图拖拽事件，默认启用(可不写)
	        map.enableScrollWheelZoom();//启用地图滚轮放大缩小
	        map.enableDoubleClickZoom();//启用鼠标双击放大，默认启用(可不写)
	        map.enableKeyboard();//启用键盘上下左右键移动地图
	    }
	    /**
	     * 表单提交后使地图消失
	     */
	    $("#SecondStep").click(function(){
	    	$("#iyoutingche-center-rright").hide();
	    });
	 /**
	  * 停车场描述内容`	`
	  */
	 $("#text").mouseout(function(){
		 $("#dis").hide();
		 var depot_recommend = $("#text").text();
		 if(depot_recommend.length <= 15){
			 if($("#said").text().length==0){
				 $("#said").append("不能少于15个字符");
			 }else{
				 $("#said").hide();
			 }
			 return;
		 }else{
			 $("#depot_recommend").val(depot_recommend);
		//	 alert("name");
		 }
	 });
	 $("#adminAddDepot").validate({
			rules:{
				depot_name:{
					required:true,
					minlength:5,
				},
				depot_province:{
					required:true,
				},
				depot_city:{
					required:true,
				},
				depot_region:{
					required:true,
				},
				depot_place:{
					required:true,
				},
				depot_coord:{
					required:true,
				},
				depot_recommend:{
					required:true,
					minlength:20,
				},
				depot_space:{
					required:true,
					number:true,
				},
				admin_p_name:{
					required:true,
				},
				admin_p_email:{
					required:true,
					email: true,
				},
				admin_p_sex:{
					required:true,
				},
				admin_p_phone:{
					required:true,
					isTel:true,
				},
				admin_p_bank:{
					required:true,
					isBankNumber:true,
				},
			},
			messages:{
				depot_name:{
					required:"请输入停车场名字",
					minlength:jQuery.validator.format("输入不小于6位数的字符"),
				},
				depot_province:{
					required:"请输入选择省",
				},
				depot_city:{
					required:"请输入选择市",
				},
				depot_region:{
					required:"请输入选择区",
				},
				depot_place:{
					required:"请输入内容",
				},
				depot_space:{
					required:"请输入内容",
					number:"必须是数字",
				},
				depot_coord:{
					required:"请输入坐标",
				},
				depot_recommend:{
					required:"请输入具体描述",
					minlength:jQuery.validator.format("输入不小于20位数的字符"),
				},
				
				admin_p_name:{
					required:"请输入管理员姓名",
				},
				admin_p_email:{
					required:"请输入管理员邮箱",
					email: "邮箱格式不正确",
				},
				admin_p_sex:{
					required:"请选择性别",
				},
				admin_p_phone:{
					required:"请输入电话",
					isTel:"联系方式格式不正确",
				},
				admin_p_bank:{
					required:"请输入银行卡号",
					isBankNumber:"银行卡号格式不正确",
				},
			},
			submitHandler:function(form){
				$(form).ajaxSubmit({
					type:'POST',
					  url:'AdminAddDepot',
					  data:{
						  depot_recommend: $("#depot_recommend").val(),
					  },
				  	contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		  			success: function(data){
				  			if(data=="true"){
				  			alert("添加成功");
				  			}else{
				  				alert("添加失败");
				  			}	
		  			   }
				});
			},
		});
	 /*
		 * jquery.validate自定义方法
		 */
		 jQuery.validator.addMethod("isTel", function(value,element) {   
		        var length = value.length;   
		        var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;   
		        return this.optional(element) || (length==11 && mobile.test(value));   
		    }, "请正确填写您的联系方式"); 
		 jQuery.validator.addMethod("isBankNumber", function(value,element) {   
		        var length = value.length;   
		    //    var bank = /^d{19}$/g;   
		        return this.optional(element) || (length==19);   
		    }, "请输入正确的银行卡号"); 
		 /**
		  * 停车场上传图片表单验证
		  */
		 $("#uploadImg").click(function(){
				var depotImg=$("#depotImg").val();
				if(depotImg==""){
					alert("请选择图片上传");
					return;
				}else if(!(/(?:jpg|gif|png|jpeg)$/i.test(depotImg))) {
					alert("只允许上传jpg|gif|png|jpeg格式的图片");
					return;
				}
				$("#imgup").ajaxSubmit({
					type:"POST",
					url:"AdminAddDepotImg",
					success: function(data){
						if(data=="false"){
							alert("上传失败");
						}else{
							alert("上传成功");
						}
				   }
				});
			});
});
function GetRTime(){
	 $("#login").hide();
}