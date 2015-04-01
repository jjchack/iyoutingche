<%@page import="com.iyoutingche.web.adminmodel.Pcar_Admin"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
		<script type="text/javascript" src="js/admincenter.js"></script>
	</head>

	<body>
		<% 
			request.setCharacterEncoding("utf-8"); 
			response.setCharacterEncoding("utf-8"); 
			Pcar_Admin admin = (Pcar_Admin) request.getAttribute("admin"); 
			if (admin != null) { 
				System.out.println(admin.getAdmin_id()); 
		%>
		<div id="iyoutingche-center-frameright">
			<div role="tabpanel">
				<!-- Nav tabs -->
				<ul class="nav nav-tabs" role="tablist" id="base">
					<li role="presentation" class="active">
						<a href="#home" aria-controls="home" role="tab" data-toggle="tab">基本信息</a>
					</li>
					<li role="presentation">
						<a href="#messages" aria-controls="messages" role="tab"
							data-toggle="tab">修改密码</a>
					</li>
				</ul>

				<!-- Tab panes -->
				<div class="tab-content">
					<div role="tabpanel" class="tab-pane active" id="home">
						<form class="form-horizontal" method="post" id="adminbaseInfo">
							<div id="iyoutingche-center-formgroup">
								<span for="inputEmail3" id="iyoutingche-center-lable">用户号</span>
								<input type="text" class="form-control" name="adminid"
									id="adminid" value="<%=admin.getAdmin_id()%>" placeholder="name"
									disabled="disabled">
							</div>
							<div id="iyoutingche-center-formgroup">
								<span for="inputEmail3" id="iyoutingche-center-lable">用户名</span>
								<input type="text" class="form-control" name="adminname"
									id="adminname" value="<%=admin.getAdmin_name()%>"
									placeholder="name">
							</div>
							<div id="iyoutingche-center-formgroup">
								<span for="inputEmail3" id="iyoutingche-center-lable">邮箱</span>
								<input type="text" class="form-control" name="adminemail" id="adminemail"
									value="<%=admin.getAdmin_email()%>" disabled="disabled"
									>
							</div>
							<div class="iyoutingche-center-radio">
								<span for="inputPassword3" id="iyoutingche-center-lable">性别</span>
								<%
									if (admin.getAdmin_sex() == null) {
								%>
								<input type="radio" name="adminsex" id="adminsex" value="男"
									checked="checked" />
								男
								<input type="radio" name="adminsex" id="adminsex" value="女" />
								女
								<%
									} else if (admin.getAdmin_sex().equals("男")) {
								%>
								<input type="radio" name="adminsex" id="adminsex" value="男"
									checked="checked" />
								男
								<input type="radio" name="adminsex" id="adminsex" value="女" />
								女
								<%
									} else {
								%>
								<input type="radio" name="adminsex" id="adminsex" value="男" />
								男
								<input type="radio" name="adminsex" id="adminsex" value="女"
									checked="checked" />
								女
								<%
									}
								%>
							</div>
							<div id="iyoutingche-center-formgroup">
								<span for="inputPassword3" id="iyoutingche-center-lable">联系方式</span>
								<input type="text" class="form-control" name="adminphone"
									id="adminphone" value="<%=admin.getAdmin_phone()%>"
									placeholder="confirm password">
							</div>
							<div id="iyoutingche-center-formgroup">
								<div class="col-sm-offset-2 col-sm-10">
									<input class="btn btn-primary" type="submit"
										value="修改信息">
								</div>
							</div>
						</form>
					</div>
						<div role="tabpanel" class="tab-pane" id="messages">
							<form class="form-horizontal" method="post" id="adminChange">
								<div id="iyoutingche-center-formgroup">
									<span for="inputEmail3" id="iyoutingche-center-lable">原密码</span>
									<input type="hidden" class="form-control"
										value="<%=admin.getAdmin_password()%>" name="hiddenpass" id="hiddenpass"
										placeholder="name">
									<input type="password" class="form-control" name="adminpass"
										id="adminpass" placeholder="name">
								</div>
								<div id="iyoutingche-center-formgroup">
									<span for="inputEmail3" id="iyoutingche-center-lable">新密码</span>
									<input type="password" class="form-control" id="newadminpass"
										name="newadminpass">
								</div>
								<div id="iyoutingche-center-formgroup">
									<span for="inputPassword3" id="iyoutingche-center-lable">确认新密码</span>
									<input type="password" class="form-control" id="newreadminpass" name="newreadminpass"
										placeholder="password">
								</div>
								<div id="iyoutingche-center-formgroup">
									<div class="col-sm-offset-2 col-sm-10">
										<input class="btn btn-primary" type="submit" id="changepass"
											value="确认修改">
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<%
				}
			%>
			<script src="bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
	</body>
</html>
