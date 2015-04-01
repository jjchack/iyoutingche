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
	<script src="bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
	<script src="jPaginate/jquery.paginate.js"></script>
	<script type="text/javascript" src="js/finddepot.js"></script>
  </head>
<body>
	<div id="depotdiv">
		<form class="form-inline">
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-addon">城市</div>
					<input type="text" id="address_depot" class="form-control"
						name="depotkeys" placeholder="城市、停车场、区域">
				</div>
			</div>
			<button type="button" class="btn btn-primary btn-lg" id="btn">
				搜索</button>
		</form>
	</div>
				
</body>
</html>