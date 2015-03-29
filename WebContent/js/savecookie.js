/**
 * 为用户保存cookie
 */
$(document).ready(function(){
/*登录界面表单验证
	 * */
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
					//	$.cookie('cookieName',email,{expires: 7,path:'/',secure: false,raw:false});  
						$.cookie('cookieName',email,{
							expires: 7,
							});
					//	cookieSave = $.cookie('cookieName',email);
						location.reload();
					}else{
						$("#info").append("<b>错误的用户名或密码</b><br/>");
					}
				}
			});
		}
	});
	/**
	 * cookie保存账号
	 */
	//alert("cookie值"+$.cookie('cookieName'))$.cookie('cookieName')!="null" && $.cookie('cookieName')!=null;
		if($.cookie('cookieName')){
			$("#iyoutingche-topright").empty();
			$("#iyoutingche-topleft").append("<a href='/iyoutingche'><button class='btn btn-primary nav-btn' id='quit'>退出</button></a>"+"<a href='userFindByEmail?email="+$.cookie('cookieName')+"'> " +
				"欢迎您,"+$.cookie('cookieName')+" </a>");
		}else{
			$("#iyoutingche-topleft").empty();
		}
	/**
	 * 退出
	 */
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
});