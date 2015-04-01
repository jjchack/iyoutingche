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

	<div id="iyoutingche-center-frameright">
		<!-- Tab panes -->
		<div class="tab-content">
			<form class="form-horizontal" method="post" id="adminAddForm">
				<div id="iyoutingche-center-formgroup">
					<span for="inputEmail3" id="iyoutingche-center-lable">用户名</span> <input
						type="text" class="form-control" name="adminname" id="adminname"
						placeholder="name">
				</div>
				<div id="iyoutingche-center-formgroup">
					<span for="inputEmail3" id="iyoutingche-center-lable">邮箱</span> <input
						type="text" class="form-control" name="adminemail" id="adminemail">
				</div>
				<div class="iyoutingche-center-radio">
					<span for="inputPassword3" id="iyoutingche-center-lable">性别</span>

					<input type="radio" name="adminsex" id="adminsex" value="男"
						checked="checked" /> 男 <input type="radio" name="adminsex"
						id="adminsex" value="女" /> 女
				</div>
				<div id="iyoutingche-center-formgroup">
					<span for="inputPassword3" id="iyoutingche-center-lable">联系方式</span>
					<input type="text" class="form-control" name="adminphone"
						id="adminphone" placeholder="tel number">
				</div>
				<div id="iyoutingche-center-formgroup">
					<div class="col-sm-offset-2 col-sm-10">
					<span id="add"></span>
						<input class="btn btn-primary" type="submit" value="确认添加">
					</div>
				</div>
			</form>
		</div>
	</div>
	<script src="bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
	</body>
</html>
