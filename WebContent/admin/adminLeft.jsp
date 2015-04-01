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

<title>i优停车网站</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/iyoutingche-admin.css">
<script type="text/javascript" src="js/jquery-1.11.2.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2">
				<ul id="main-nav" class="main-nav nav nav-tabs nav-stacked" style="">
					<li><a href="#systemSetting" class="nav-header collapsed"
						data-toggle="collapse"> <i class="glyphicon glyphicon-cog"></i>
							信息管理 <span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
					</a>
						<ul id="systemSetting" class="nav nav-list secondmenu collapse"
							style="height: 0px;">
							<li><a href="AdminSystemSer?req=myinfo" target="right"><i class="glyphicon glyphicon-user"></i>&nbsp;个人信息</a></li>
							<li><a href="admin/adminregister.jsp" target="right"><i class="glyphicon glyphicon-th-list"></i>&nbsp;添加管理员</a></li>
						</ul></li>
					<li><a href="#configSetting" class="nav-header collapsed"
						data-toggle="collapse"> <i
							class="glyphicon glyphicon-credit-card"></i>停车场管理<span
							class="pull-right glyphicon  glyphicon-chevron-toggle"></span>
					</a>
						<ul id="configSetting" class="nav nav-list secondmenu collapse in">
							<li class="active"><a href="admin/finddepots.jsp" target="right"><i
									class="glyphicon glyphicon-globe"></i>&nbsp;快速搜索</a></li>
							<li><a href="admin/AddDepot.jsp" target="right"><i
									class="glyphicon glyphicon-star-empty"></i>&nbsp;添加停车场</a></li>
						</ul></li>

					<li><a href="#disSetting" class="nav-header collapsed"
						data-toggle="collapse"> <i class="glyphicon glyphicon-globe"></i>
							公告管理<span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
					</a>
						<ul id="disSetting" class="nav nav-list secondmenu collapse">
							<li><a href="#" target="right"><i class="glyphicon glyphicon-th-list"></i>&nbsp;发布消息</a></li>
						</ul></li>
					<li><a href="#" target="right"> <i class="glyphicon glyphicon-fire"></i>
							关于管理员 <span class="badge pull-right">1</span>
					</a></li>

				</ul>
			</div>
		</div>
	</div>
	<script src="bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
</body>
</html>
