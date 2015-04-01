$(document).ready(function(){
	
	$("#baseInfoform").validate({
		rules:{
			userid: {
				required: true,
			},
			username:{
				required:true,
				minlength: 5,
			},
			email:{
				required:true,
				email:true
			},
			usersex:{
				required:true,
			},
			userphone:{
				required:true,
				isTel:true,
			},
			usernumber:{
				required:true,
				isNumber:true,
			}
		},
		messages:{
			userid: {
				required: "请输入id",
			},
			username:{
				required:"请输入用户名",
				minlength:jQuery.validator.format("输入不小于5位数的字符"),
			},
			email:{
				required:"请输入邮箱地址",
			},
			usersex:{
				required:"请选择性别",
			},
			userphone:{
				required:"请输入手机号",
				isTel:"手机号码格式不正确",
			},
			usernumber:{
				required:"请输入车牌号",
				isNumber:"车牌号格式不正确",
			}
		},
		submitHandler:function(form){
			$(form).ajaxSubmit({
				type:'POST',
				  url:'userJsonModifySer',
				  data:{
				  			userid: $("#userid").val(),
				  			email:  $("#email").val(),
			  			},
			  	contentType: "application/x-www-form-urlencoded; charset=utf-8", 
	  			success: function(data){
			  				/*
			  				 * 不知道怎么回事返回之后，不用修改input中的value值，也可以更改这些值。
			  				 * 那现在就先不管这些了。往下面进行吧。			  			
			  				 * */			  		
	  						/*json=$.parseJSON(data);
			  				 alert("username="+json.username);
			  				$("#username").val(json.username);*/
			  				alert("已完善");
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
	      //  var tel = /^(\d{3,4}-?)?\d{7,9}$/g;       
	        return this.optional(element) || (length==11 && mobile.test(value));   
	    }, "请正确填写您的联系方式"); 
	 jQuery.validator.addMethod("isNumber", function(value,element) {   
	        var length = value.length;   
	        var number =/^[\u4e00-\u9fa5]{1}[A-Z]{1}[A-Z_0-9]{5}$/;   
	        return this.optional(element) || number.test(value);   
	    }, "请正确填写您的联系方式"); 
	
	
	
	/*改变导航栏
	 * */
	$("#changeImg").click(function(){
		//alert("选择了");
		$("#base li").removeClass("active");
		$("#base li").eq(2).addClass("active");
	});
	$("#changebase").click(function(){
		//alert("选择了");
		$("#base li").removeClass("active");
		$("#base li").eq(0).addClass("active");
	});
	
	/*更换头像ajax
	 * */
	$("#uploadImg").click(function(){
		var userImg=$("#userImg").val();
		if(userImg==""){
			alert("请选择图片上传");
			return;
		}else if(!(/(?:jpg|gif|png|jpeg)$/i.test(userImg))) {
			alert("只允许上传jpg|gif|png|jpeg格式的图片");
			return;
		}
		$("#UpLoadForm").ajaxSubmit({
			type:"POST",
			url:"userJsonModifyImg",
			success: function(data){
				//alert(data);
				if(data=="false"){
					alert("更改头像失败");
				}else{
  				json = $.parseJSON(data);
  				$("#img").attr({ src: "img/"+json.userimg+"", alt: "我的头像" });
  				$("#userimages").attr({src: "img/"+json.userimg+"", alt: "更换头像" })
				}
		   }
		});
	});
	
	/*更改密码表单验证
	 * */
	$("#ChangeForm").validate({
		rules:{
			userpass: {
				required: true,
				minlength:6,
				equalTo: "#hiddenpass"
			},
			newuserpass:{
				required:true,
				minlength:6
			},
			newreuserpass:{
				required:true,
				equalTo: "#newuserpass",
				minlength:6
			}
		},
		messages:{
			userpass: {
				required: "原密码不能为空",
				minlength:jQuery.validator.format("输入不小于6位数的字符"),
				equalTo:"密码输入错误",
			},
			newuserpass: {
				required: '密码不能为空',
				minlength:jQuery.validator.format("输入不小于6位数的字符"),
			},
			newreuserpass:{
				required: '密码不能为空',
				minlength:jQuery.validator.format("输入不小于6位数的字符"),
				equalTo:"请输入正确的确定密码",
			}
		},
		submitHandler:function(form){
			$(form).ajaxSubmit({
				type:'POST',
				  url:'userModifyPassword',
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
});
