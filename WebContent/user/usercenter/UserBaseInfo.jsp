<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.iyoutingche.web.usermodel.PcarUser"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>i优停车</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="bootstrap-3.3.2-dist/css/bootstrap.min.css"
			rel="stylesheet">
		<link rel="stylesheet" type="text/css"
			href="css/iyoutingche-personalcenter.css">
		<script type="text/javascript" src="js/jquery-1.11.2.js"></script>
		<script type="text/javascript" src="js/jquery.validate.js"></script>
		<script type="text/javascript" src="js/jquery.form.js"></script>
		<script type="text/javascript" src="js/usercenter.js"></script>
	</head>

	<body>
		<% 
			request.setCharacterEncoding("utf-8"); 
			response.setCharacterEncoding("utf-8"); 
			PcarUser user = (PcarUser) request.getAttribute("user"); 
			if (user != null) { 
				System.out.println(user.getUser_name()); 
		%>
		<div id="iyoutingche-center-frameright">
			<div role="tabpanel">
				<!-- Nav tabs -->
				<ul class="nav nav-tabs" role="tablist" id="base">
					<li role="presentation" class="active">
						<a href="#home" aria-controls="home" role="tab" data-toggle="tab">基本信息</a>
					</li>
					<li role="presentation" class="disabled">
						<a href="#profile" aria-controls="profile" role="tab"
							data-toggle="tab">详细信息</a>
					</li>
					<li role="presentation">
						<a href="#change" aria-controls="change" role="tab"
							data-toggle="tab">更换头像</a>
					</li>
					<li role="presentation">
						<a href="#messages" aria-controls="messages" role="tab"
							data-toggle="tab">修改密码</a>
					</li>
					<li role="presentation" class="disabled">
						<a href="#settings" aria-controls="settings" role="tab"
							data-toggle="tab">密码安全</a>
					</li>
				</ul>

				<!-- Tab panes -->
				<div class="tab-content">
					<div role="tabpanel" class="tab-pane active" id="home">
						<form class="form-horizontal" method="post" id="baseInfoform">
							<div id="iyoutingche-center-formgroup">
								<span for="inputEmail3" id="iyoutingche-center-lable">用户号</span>
								<input type="text" class="form-control" name="userid"
									id="userid" value="<%=user.getUser_id()%>" placeholder="name"
									disabled="disabled">
							</div>
							<div id="iyoutingche-center-formgroup">
								<span for="inputEmail3" id="iyoutingche-center-lable">用户名</span>
								<input type="text" class="form-control" name="username"
									id="username" value="<%=user.getUser_name()%>"
									placeholder="name">
							</div>
							<div id="iyoutingche-center-formgroup">
								<span for="inputEmail3" id="iyoutingche-center-lable">邮箱</span>
								<input type="text" class="form-control" name="email" id="email"
									value="<%=user.getUser_email()%>" disabled="disabled"
									placeholder="email">
							</div>
							<div class="iyoutingche-center-radio">
								<span for="inputPassword3" id="iyoutingche-center-lable">性别</span>
								<%
									if (user.getUser_sex() == null) {
								%>
								<input type="radio" name="usersex" id="usersex" value="男"
									checked="checked" />
								男
								<input type="radio" name="usersex" id="usersex" value="女" />
								女
								<%
									} else if (user.getUser_sex().equals("男")) {
								%>
								<input type="radio" name="usersex" id="usersex" value="男"
									checked="checked" />
								男
								<input type="radio" name="usersex" id="usersex" value="女" />
								女
								<%
									} else {
								%>
								<input type="radio" name="usersex" id="usersex" value="男" />
								男
								<input type="radio" name="usersex" id="usersex" value="女"
									checked="checked" />
								女
								<%
									}
								%>
							</div>
							<div id="iyoutingche-center-formgroup">
								<span for="inputPassword3" id="iyoutingche-center-lable">联系方式</span>
								<input type="text" class="form-control" name="userphone"
									id="userphone" value="<%=user.getUser_phone()%>"
									placeholder="confirm password">
							</div>
							<div id="iyoutingche-center-formgroup">
								<span for="inputPassword3" id="iyoutingche-center-lable">车牌号</span>
								<input type="text" class="form-control" name="usernumber"
									id="usernumber" value="<%=user.getUser_number()%>"
									placeholder="verification code">
							</div>
							<div id="iyoutingche-center-formgroup">
								<div class="col-sm-offset-2 col-sm-10">
									<input class="btn btn-primary" type="submit"
										value="完善信息">
								</div>
							</div>
						</form>
					</div>
					<!-- 待开发 -->
					<div role="tabpanel" class="tab-pane" id="profile">
						<form class="form-horizontal" action="userModifySer" method="post"
							id="form">
							<div id="iyoutingche-center-formgroup">
								<span for="inputEmail3" id="iyoutingche-center-lable">用户名</span>
								<input type="text" class="form-control" name="username"
									value="<%=user.getUser_name()%>" placeholder="name">
							</div>
							<div id="iyoutingche-center-formgroup">
								<span for="inputEmail3" id="iyoutingche-center-lable">邮箱</span>
								<input type="text" class="form-control" name="email" id="email"
									placeholder="email">
							</div>
							<div id="iyoutingche-center-formgroup">
								<span for="inputPassword3" id="iyoutingche-center-lable">性别</span>
								<input type="text" class="form-control" name="usersex"
									value="<%=user.getUser_sex()%>" placeholder="password">
							</div>
							<div id="iyoutingche-center-formgroup">
								<span for="inputPassword3" id="iyoutingche-center-lable">联系方式</span>
								<input type="text" class="form-control" name="userphone"
									value="<%=user.getUser_phone()%>"
									placeholder="confirm password">
							</div>
							<div id="iyoutingche-center-formgroup">
								<span for="inputPassword3" id="iyoutingche-center-lable">车牌号</span>
								<input type="text" class="form-control" name="usernumber"
									value="<%=user.getUser_number()%>"
									placeholder="verification code">
							</div>
							<div id="iyoutingche-center-formgroup">
								<div class="col-sm-offset-2 col-sm-10">
									<input class="btn btn-primary" type="submit" value="完善信息">
								</div>
							</div>
							<hr />
						</form>
					</div>
					<div role="tabpanel" class="tab-pane" id="change">
					<div id="iyoutingche-center-left">
							<span>当前头像</span>
							<img alt="我的头像" src="img/<%=user.getUser_img() %>" class="thumbnail" width="80px" height="80px" id="img">
			     	</div>
					<div id="iyoutingche-border"></div>
							<div id="iyoutingche-center-right">
								<form  id="UpLoadForm" method="post" enctype="multipart/form-data">
									<span>更换头像</span><p></p>
									<input type="file" name="userImg" id="userImg">
									<input class="btn btn-primary" type="button" value="上传" id="uploadImg">
								</form>
							</div>
						</div>
						<div role="tabpanel" class="tab-pane" id="messages">
							<form class="form-horizontal" method="post" id="ChangeForm">
								<div id="iyoutingche-center-formgroup">
									<span for="inputEmail3" id="iyoutingche-center-lable">原密码</span>
									<input type="hidden" class="form-control"
										value="<%=user.getUser_password()%>" name="hiddenpass" id="hiddenpass"
										placeholder="name">
									<input type="password" class="form-control" name="userpass"
										id="userpass" placeholder="name">
								</div>
								<div id="iyoutingche-center-formgroup">
									<span for="inputEmail3" id="iyoutingche-center-lable">新密码</span>
									<input type="password" class="form-control" id="newuserpass"
										name="newuserpass" id="email" placeholder="email">
								</div>
								<div id="iyoutingche-center-formgroup">
									<span for="inputPassword3" id="iyoutingche-center-lable">确认新密码</span>
									<input type="password" class="form-control" id="newreuserpass" name="newreuserpass"
										value="" placeholder="password">
								</div>
								<div id="iyoutingche-center-formgroup">
									<div class="col-sm-offset-2 col-sm-10">
										<input class="btn btn-primary" type="submit" id="changepass"
											value="确认修改">
									</div>
								</div>
							</form>
						</div>
						<!-- 待开发 -->
						<div role="tabpanel" class="tab-pane" id="settings">
							...
						</div>
					</div>
				</div>
			</div>
			<%
				}
			%>
			<div id="iyoutingche-center-frameright-r">
				<ul class="nav nav-pills nav-stacked">
					<li class="active">
						<a href=""> <i class="glyphicon glyphicon-user"></i> 用户信息 </a>
					</li>
				</ul>
				<div id="iyoutingche-center-user">
					<a href="#change" id="changeImg" aria-controls="change" role="tab"
						data-toggle="tab" class="avatar-btn" title="更换头像"> <img id="userimages"
							src="img/<%=user.getUser_img() %>" width="80px" /> </a>
					<div class="pull-left mt5">
						<a id="changebase" title="点击查看个人主页" href="#home"
							aria-controls="home" role="tab" data-toggle="tab">JAY李阿卧</a>
						<br>
						<span class="user-sn">用户号：108377</span>
					</div>
					<div id="iyoutingche-center-progress">
						<div class="progress">
							<div class="progress-bar" role="progressbar" aria-valuenow="60"
								aria-valuemin="0" aria-valuemax="100" style="width: 90%;">
								<span class="sr-only">60%</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<script src="bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
	</body>
</html>
