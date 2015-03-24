<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/iyoutingche.css">
	<link rel="stylesheet" type="text/css" href="css/iyoutingche-ajax.css">
	<script type="text/javascript" src="js/jquery-1.11.2.js"></script>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=2zsUYzzWb7r8pUeHUCMmhLvD"></script>
	<script type="text/javascript" src="js/myMap.js"></script>
	<title>百度地图自定义搜索</title>
  </head>
  <body>
  <div class="container">
			<div id="iyoutingche-middle">
				<img alt="logo" class="img-rounded"
					src="images/iyoutingche-logo.png">
				<div class="l"></div>
				<div id="iyoutingche-city">
					<h2>
						<strong>焦作</strong>
					</h2>
					<a href="#">[切换城市]</a>
				</div>
				<form class="form-inline" id="form2">
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
		<script src="bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
  </body>
</html>
