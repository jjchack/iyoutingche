<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'FindSpaces.jsp' starting page</title>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/iyoutingche.css">
<script type="text/javascript" src="js/jquery-1.11.2.js"></script>
<script src="bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script type="text/javascript" src="js/show_info.js"></script>
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=2zsUYzzWb7r8pUeHUCMmhLvD"></script>
</head>

<body>
<div id="iyoutingche-topa">
	<div id="iyoutingche-topleft">
	</div>
	<div id="iyoutingche-topright">
	
		<ul class="nav nav-pills pull-right">
			<li role="presentation" class="active"><button type="button"
					id="Loginbtn" class="btn btn-primary nav-btn" data-toggle="modal"
					data-target=".bs-example-modal-lg">登录</button></li>
			<li role="presentation"><a href="user/userRegister.jsp">注册</a></li>
			<li role="presentation"><a href="">个人中心</a></li>
			<li role="presentation"><a href="">联系我们</a></li>
		</ul>
	</div>
	</div>
	<div class="topl">
		<span class="sr-only" id="depotcode"><%=request.getAttribute("depotcode")%></span>
		<span class="sr-only" id="depot_x"><%=request.getAttribute("x")%></span>
		<span class="sr-only" id="depot_y"><%=request.getAttribute("y")%></span>
	</div>
	<div class="container " style="margin-top: 30px;">
		<div class="row">
			<div class="col-md-8" id="show_mapinfo"></div>
			<div class="col-md-4 img-thumbnail Pcar_info">
				<p class="text-center lead">
					总共有<strong class="text-success" style="font-size: 40px;"
						id="Pcar_count"></strong>位
				</p>
				<p class="text-center">
					<button type="button" id="btn_order" data-loading-text="预约中..."
						class="btn btn-primary btn-lg">没有停车位可以预约</button>
				</p>
			</div>
		</div>
	</div>

	<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog"
		id='modal_login' aria-labelledby="myLargeModalLabel"
		aria-hidden="true">
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
								<div class="active item">
									<img src="images/iyoutingche-welcome.jpg" />
								</div>
								<div class="item">
									<img src="images/iyoutingche-welcome.jpg" />
								</div>
								<div class="item">
									<img src="images/iyoutingche-welcome.jpg" />
								</div>
							</div>
							<!-- Carousel nav -->
							<a class="carousel-control left" href="#myCarousel"
								data-slide="prev"></a> <a class="carousel-control right"
								href="#myCarousel" data-slide="next"></a>
						</div>
					</div>
					<div id="iyoutingche-login-right">
						<div role="tabpanel">
							<!-- Nav tabs -->
							<ul class="nav nav-tabs" role="tablist">
								<li role="presentation" class="active"><a href="#home"
									aria-controls="home" role="tab" data-toggle="tab">&nbsp;&nbsp;&nbsp;&nbsp;<span
										class="glyphicon glyphicon-envelope"></span>邮箱登录
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</a></li>
								<li role="presentation"><a href="#profile"
									aria-controls="profile" role="tab" data-toggle="tab">&nbsp;&nbsp;&nbsp;&nbsp;<span
										class="glyphicon glyphicon-phone"></span>手机登录&nbsp;&nbsp;&nbsp;&nbsp;
								</a></li>
							</ul>
							<div class="tab-content">
								<div role="tabpanel" class="tab-pane active" id="home">
									<form class="form-horizontal" method="post" id="LoginForm">
										<div id="iyoutingche-formgroup">
											<label for="inputEmail3" class="col-sm-2 control-label">邮箱</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" name="user_email"
													value="${cookie.email.value }" id="email"
													placeholder="Email">
											</div>
										</div>
										<div id="iyoutingche-formgroup">
											<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
											<div class="col-sm-10">
												<input type="password" class="form-control"
													value="${cookie.password.value }" name="user_password"
													id="password" placeholder="Password">
											</div>
										</div>
										<div id="form-group">
											<div class="col-sm-offset-2 col-sm-10">
												<div class="checkbox">
													<label> <input type="checkbox" name="isAuto"
														value="1" checked="checked"> 记住密码
													</label>
												</div>
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-offset-2 col-sm-10">
												<span id="info"></span>
												<button type="submit" class="btn btn-default btn-lg"
													id="Loginbtn">登录</button>
												<a href="">没有注册？</a>
											</div>
										</div>
									</form>
								</div>
								<div role="tabpanel" class="tab-pane" id="profile">
									<form class="form-horizontal" action="UserCheckLoginSer"
										method="post" id="form" onsubmit="return Check(this)">
										<div id="iyoutingche-formgroup">
											<label for="inputEmail3" class="col-sm-2 control-label">手机</label>
											<div class="col-sm-10">
												<input type="text" class="form-control" name="user_email"
													id="email" placeholder="Email">
											</div>
										</div>
										<div id="iyoutingche-formgroup">
											<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
											<div class="col-sm-10">
												<input type="password" class="form-control"
													name="user_password" id="password" placeholder="Password">
											</div>
										</div>
										<div id="form-group">
											<div class="col-sm-offset-2 col-sm-10">
												<div class="checkbox">
													<label> <input type="checkbox"> 记住密码
													</label>
												</div>
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-offset-2 col-sm-10">
												<button type="submit" class="btn btn-default btn-lg">登录</button>
												</a> <a href="">没有注册？</a>
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

</body>
</html>