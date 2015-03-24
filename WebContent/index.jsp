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
	<link rel="stylesheet" type="text/css" href="css/iyoutingche.css">
	<script type="text/javascript" src="js/jquery-1.11.2.js"></script>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=2zsUYzzWb7r8pUeHUCMmhLvD"></script>
	<script type="text/javascript" src="js/jquery.form.js"></script>
	<script type="text/javascript" src="js/jquery.validate.js"></script>
	<script type="text/javascript" src="js/jquery.cookie.js"></script>
	<script type="text/javascript" src="js/savecookie.js"></script>
	<script type="text/javascript" src="js/myMap.js"></script>
	<script src="bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
  </head>
  <%
  	request.setCharacterEncoding("utf-8");
  	response.setCharacterEncoding("utf-8");
  	String email = (String)session.getAttribute("email");
  	String password =(String)session.getAttribute("password");
  %>
  <body>
  	 <div id="iyoutingche-topa">
  	 <div id="iyoutingche-topleft">
  	 	
  	 </div>
  	 <div id="iyoutingche-topright">
  	<ul class="nav nav-pills pull-right">  
		  <li  role="presentation" class="active"><button type="button" id="Loginbtn" class="btn btn-primary nav-btn" data-toggle="modal" data-target=".bs-example-modal-lg">登录</button></li>
		  <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-lg">
		    <div class="modal-content">
		      <div id="iyoutingche-login">
		        <div id="iyoutingche-login-top"></div>
		        <div id="iyoutingche-login-left">
       	         <div id="myCarousel" class="carousel slide">
				    <ol class="carousel-indicators">
				    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				    <li data-target="#myCarousel" data-slide-to="1"></li>
				    <li data-target="#myCarousel" data-slide-to="2"></li>
				    </ol>
				    <!-- Carousel items -->
				    <div class="carousel-inner">
				    <div class="active item"><img src="images/iyoutingche-welcome.jpg"/></div>
					    <div class="item"><img src="images/iyoutingche-welcome.jpg"/></div>
					    <div class="item"><img src="images/iyoutingche-welcome.jpg"/></div>
				    </div>
				    <!-- Carousel nav -->
				    <a class="carousel-control left" href="#myCarousel" data-slide="prev"></a>
				    <a class="carousel-control right" href="#myCarousel" data-slide="next"></a>
  				 </div>
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
				    	<form class="form-horizontal" method="post" id="LoginForm">
						  <div id="iyoutingche-formgroup">
						    <label for="inputEmail3" class="col-sm-2 control-label">邮箱</label>
						    <div class="col-sm-10">
						      <input type="text" class="form-control" name="user_email" value="${cookie.email.value }" id="email" placeholder="Email">
						    </div>
						  </div>
						  <div id="iyoutingche-formgroup">
						    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
						    <div class="col-sm-10">
						      <input type="password" class="form-control" value="${cookie.password.value }" name="user_password" id="password" placeholder="Password">
						    </div>
						  </div>
						  <div id="form-group">
						    <div class="col-sm-offset-2 col-sm-10">
						      <div class="checkbox">
						        <label>
						          <input type="checkbox" name="isAuto" value="1" checked="checked"> 记住密码
						        </label>
						      </div>
						    </div>
						  </div>
						  <div class="form-group">
						    <div class="col-sm-offset-2 col-sm-10">
						    <span id="info"></span>
						      <button type="submit" class="btn btn-default btn-lg" id="Loginbtn">登录</button>
						      <a href="">没有注册？</a>
						    </div>
						  </div>
					   </form>
					    </div>
					    <div role="tabpanel" class="tab-pane" id="profile">
					    	<form class="form-horizontal" action="UserCheckLoginSer" method="post" id="form" onsubmit="return Check(this)">
						  <div id="iyoutingche-formgroup">
						    <label for="inputEmail3" class="col-sm-2 control-label">手机</label>
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
						    <button type="submit" class="btn btn-default btn-lg">登录</button></a>
						      <a href="">没有注册？</a>
						    </div>
						  </div>
					   </form>
					    </div>
					  </div>
				</div>
		        </div>
		      </div>
		    </div>
		  </div>
		</div>
		  <li role="presentation"><a href="user/userRegister.jsp" id="Registerbtn">注册</a></li>
		  <li role="presentation"><a href="">联系我们</a></li>
	</ul>
  </div>
  </div>
  <div class="topl"></div>
  <div class="container">
			<div id="iyoutingche-middle">
				<a href="#"><img alt="logo" class="img-rounded"
					src="images/iyoutingche-logo.png"></a>
				<div class="l"></div>
				<div id="iyoutingche-city">
					<h2>
						<strong>焦作</strong>
					</h2>
					<a href="#">[切换城市]</a>
				</div>
				<form class="form-inline">
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon">
								城市
							</div>
							<input type="text" id="address_1" class="form-control"
								name="keys" placeholder="城市、停车场、区域">
						</div>
					</div>
					<button type="button" class="btn btn-primary btn-lg" id="btn">
						搜索
					</button>
				</form>
			</div>
			</div>
			<div class="container">
			<div id="iyoutingche-b">
			<div class="iyoutingche-button">
			 <h4><span class="glyphicon glyphicon-search">搜索列表</span></h4>
			</div>
			<div class="iyoutingche-shezhi"><span class="glyphicon glyphicon-triangle-left"></span>百度地图</div>
				<div class="row-fluid">
					<div id="Pcar_left">
					</div>
					<div id="Map_Content"></div>
				</div>
			</div>
		</div>
</html>
