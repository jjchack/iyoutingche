<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>百度地图自定义搜索</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/iyoutingche.css">
	<script type="text/javascript" src="js/jquery-1.11.2.js"></script>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=2zsUYzzWb7r8pUeHUCMmhLvD"></script>
	<script type="text/javascript">
		function Check(form){
			var email=form.user_email.value;
			var password=form.user_password.value;
			for(var i=0;i<form.length-1;i++){
				if(form.elements[i].value.length==0){
					alert("内容不能为空");
					form.elements[i].focus();
					return false;
				}
			}
			if(!/^[\w_-]+@[\w_-]+[\.a-zA-Z]+[^\.]$/.test(email)){
				alert("邮箱格式不对");
				form.user_email.focus();
				return false;
			}
		}
	</script>
  </head>
  <body>
  	 <div id="iyoutingche-topa">
  	<ul class="nav nav-pills pull-right">  
		  <li  role="presentation" class="active"><button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg">登录</button></li>
		  <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-lg">
		    <div class="modal-content">
		      <div id="iyoutingche-login">
		        <div id="iyoutingche-login-top"></div>
		        <div id="iyoutingche-login-left">
		        	<img alt="wlecome" src="images/iyoutingche-welcome.jpg" width="400px">
		        </div>
		        <div id="iyoutingche-login-right">
					<div role="tabpanel">
					  <!-- Nav tabs -->
					  <ul class="nav nav-tabs" role="tablist">
					    <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-envelope"></span>邮箱登录 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
					    <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-phone"></span>手机登录&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
					  </ul>
					  <div class="tab-content">
					    <div role="tabpanel" class="tab-pane active" id="home">
				    	<form class="form-horizontal" action="UserCheckLoginSer" method="post" id="form" onsubmit="return Check(this)">
						  <div id="iyoutingche-formgroup">
						    <label for="inputEmail3" class="col-sm-2 control-label">邮箱</label>
						    <div class="col-sm-10">
						      <input type="text" class="form-control" name="user_email" id="email" placeholder="Email">
						    </div>
						  </div>
						  <div id="iyoutingche-formgroup">
						    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
						    <div class="col-sm-10">
						      <input type="password" class="form-control" name="user_password" id="password" placeholder="Password">
						    </div>
						  </div>
						  <div id="form-group">
						    <div class="col-sm-offset-2 col-sm-10">
						      <div class="checkbox">
						        <label>
						          <input type="checkbox"> 记住密码
						        </label>
						      </div>
						    </div>
						  </div>
						  <div class="form-group">
						    <div class="col-sm-offset-2 col-sm-10">
						      <button type="submit" class="btn btn-default btn-lg">登录</button>
						      <a href="">没有注册？</a>
						    </div>
						  </div>
					   </form>
					    </div>
					    <div role="tabpanel" class="tab-pane" id="profile">拜拜</div>
					  </div>
				</div>
		        </div>
		      </div>
		    </div>
		  </div>
		</div>
		  <li role="presentation"><a href="user/userRegister.jsp">注册</a></li>
		  <li role="presentation"><a href="">个人中心</a></li>
		  <li role="presentation"><a href="">联系我们</a></li>
	</ul>
  </div>
  <div class="topl"></div>
  <script src="bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
  </body>
</html>
