<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/iyoutingche-register.css">
	<script type="text/javascript" src="js/jquery-1.11.2.js"></script>
	<script type="text/javascript" src="js/userregister.js"></script>
	<script type="text/javascript" src="js/jquery.validate.js"></script>
	<script type="text/javascript" src="js/jquery.form.js"></script>
  </head>
  <body>
  <div id="iyoutingche-register-topa">
   <a href="index.jsp"><img alt="logo" class="img-rounded"
					src="images/iyoutingche-logo.png">
	</a>
  <div id="iyoutingche-r"></div>
  <div id="iyoutingche-register-toph2">
  	注册i优停车账号
  </div>
  <div id="iyoutingche-register-topr">已有i优停车账号？
  	<a href="index.jsp">前去登录</a>
  </div>
  
  </div>
  <div class="topl"></div>
  <div id="iyoutingche-register-m">
  <div class="container">
	  

	<div role="tabpanel">
	
	  <!-- Nav tabs -->
	  <ul class="nav nav-tabs" role="tablist">
	    <li role="presentation" class="active"><a href="user/userRegister.jsp/#home" aria-controls="home" role="tab" data-toggle="tab">邮箱注册</a></li>
	    <li role="presentation"><a href="user/userRegister.jsp/#profile" aria-controls="profile" role="tab" data-toggle="tab">手机注册</a></li>
	  </ul>
	
	  <!-- Tab panes -->
	  <div class="tab-content">
	    <div role="tabpanel" class="tab-pane active" id="home">
	    	<form class="form-horizontal" method="post" id="Registerform">
	    	 <div id="iyoutingche-register-formgroup">
			    <span for="inputEmail3" id="iyoutingche-register-lable">用户名</span>
			      <input type="text" class="form-control" name="user_name" placeholder="name">
			  </div>
			  <div id="iyoutingche-register-formgroup">
			    <span for="inputEmail3" id="iyoutingche-register-lable">邮箱</span>
			      <input type="text" class="form-control" name="user_email" placeholder="email">
			      <span id="info"></span>
			  </div>
			  <div id="iyoutingche-register-formgroup">
			    <span for="inputPassword3" id="iyoutingche-register-lable">创建密码</span>
			      <input type="password" class="form-control" name="user_password" id="password" placeholder="password">
			  </div>
			  <div id="iyoutingche-register-formgroup">
			    <span for="inputPassword3" id="iyoutingche-register-lable">确认密码</span>
			      <input type="password" class="form-control" name="user_repassword"  placeholder="confirm password">
			  </div>
			  <!-- 验证码部分
			  <div id="iyoutingche-register-formgroupinput">
			    <span for="inputPassword3" id="iyoutingche-register-lable">验证码</span>
			    <input type="password" class="form-control" name="user_password" placeholder="verification code">
			  </div>
			   -->
			  <div id="iyoutingche-register-formgroupb">
			    <div class="col-sm-offset-2 col-sm-10">
			      <button type="submit" name="submit" class="btn btn-primary nav-btn">同意协议并注册</button>
			    </div>
	    	  </div>
	    	  </form>
	    </div>
	    <div role="tabpanel" class="tab-pane" id="profile">
	     <form class="form-horizontal" action="UserCheckLoginSer" method="post" id="form" onsubmit="return Check(this)">
	    	 <div id="iyoutingche-register-formgroup">
			    <span for="inputEmail3" id="iyoutingche-register-lable">手机号</span>
			      <input type="text" class="form-control" name="user_name" id="email" placeholder="name">
			  </div>
			  <div id="iyoutingche-register-formgroup">
			    <span for="inputEmail3" id="iyoutingche-register-lable">邮箱</span>
			      <input type="text" class="form-control" name="user_email" id="email" placeholder="email">
			  </div>
			  <div id="iyoutingche-register-formgroup">
			    <span for="inputPassword3" id="iyoutingche-register-lable">创建密码</span>
			      <input type="password" class="form-control" name="user_password" id="password" placeholder="password">
			  </div>
			  <div id="iyoutingche-register-formgroup">
			    <span for="inputPassword3" id="iyoutingche-register-lable">确认密码</span>
			      <input type="password" class="form-control" name="user_password" id="password" placeholder="confirm password">
			  </div>
			  <div id="iyoutingche-register-formgroupinput">
			    <span for="inputPassword3" id="iyoutingche-register-lable">验证码</span>
			    <input type="password" class="form-control" name="user_password" id="password" placeholder="verification code">
			  </div>
			  <div id="iyoutingche-register-formgroupb">
			    <div class="col-sm-offset-2 col-sm-10">
			      <button type="submit" name="submit" class="btn btn-default btn-lg">同意协议并注册</button>
			    </div>
	    	  </div>
	    	  </form>
	    </div>
	  </div>
	</div>
   </div>
   </div>
   <script src="bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
  </body>
</html>
