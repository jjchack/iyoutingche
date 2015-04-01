<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.iyoutingche.web.usermodel.PcarUser"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>i优停车网</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/iyoutingche-personalcenter.css">
	<script type="text/javascript" src="js/jquery-1.11.2.js"></script>
	<script type="text/javascript" src="js/jquery.cookie.js"></script>
	<script type="text/javascript">
	/**
	 * 个人中心 退出按钮
	 */
		function exit() {
			if(window.confirm('你确定要退出该系统吗？')){
                return true;
             }else{
                return false;
            }
	}
	</script>
  </head>
  <body>
	<div id="iyoutingche-personalcenter-topa">
		<div class="container">
			<a href="#" target="_blank"><img alt="logo" class="img-rounded"
					src="images/iyoutingche-logo.png" width="100px" height="70px"></a>
			<div id="iyoutingche-personalcenter-left">
			<span class="nav-text text-overflow-hidden">当前用户:${adminemail }</span>
			</div>
			<div id="iyoutingche-personalcenter-right">
				 <a onclick="if(exit()){href='admin/adminLogin.jsp'}" class="pull-right btn btn-primary nav-btn" target="_parent">退出</a>
			</div>
		</div>
	</div>	
     <script src="bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
  </body>
</html>
