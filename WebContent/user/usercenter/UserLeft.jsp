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
    
    <title>My JSP 'userModify.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/iyoutingche-personalcenter.css">
	<script type="text/javascript" src="js/jquery-1.11.2.js"></script>
  </head>
  <body>
	<div id="iyoutingche-center-frameleft">
	<div class="container">
    	<div class="row">
    	<div class="span2">
	      <ul class="nav nav-pills nav-stacked">
          <li class="active"><a href="#" target="right"><span class="glyphicon glyphicon-user">&nbsp;</span>我的首页<i class="glyphicon glyphicon-chevron-right"></i></a></li>
           <li><a href="UserCenterSer?req=baseInfo" target="right"><span class="glyphicon glyphicon-user">&nbsp;</span>我的账号<i class="glyphicon glyphicon-chevron-right"></i></a></li>
          <li><a href="#" target="right"><span class="glyphicon glyphicon-user">&nbsp;</span>我的预约<i class="glyphicon glyphicon-chevron-right"></i></a></li>
          <li><a href="#" target="right"><span class="glyphicon glyphicon-user">&nbsp;</span>我的消息<i class="glyphicon glyphicon-chevron-right"></i></a></li>
          <li><a href="#" target="right"><span class="glyphicon glyphicon-user">&nbsp;</span>停车记录<i class="glyphicon glyphicon-chevron-right"></i></a></li>
          <li><a href="#" target="right"><span class="glyphicon glyphicon-user">&nbsp;</span>我的积分<i class="glyphicon glyphicon-chevron-right"></i></a></li>
          </ul>
        </div>
        </div>
      </div>
    </div>
     <script src="bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
  </body>
</html>
