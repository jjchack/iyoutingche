<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.iyoutingche.web.depotmodel.Pcar_Space"%>
<%@page import="com.iyoutingche.web.depotservice.InPcar_Depot"%>
<%@page import="com.iyoutingche.web.depotservice.Pcar_DepotImpl"%>
<%@page import="com.iyoutingche.web.usermodel.PcarUser"%>
<%@page import="com.iyoutingche.web.depotmodel.Pcar_Depot"%>
<%@page import="com.iyoutingche.web.ordermodel.Pcar_Order"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'FindSpaces.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/iyoutingche.css">
	<script type="text/javascript" src="js/jquery-1.11.2.js"></script>
	<script type="text/javascript" src="js/show_info.js"></script>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=2zsUYzzWb7r8pUeHUCMmhLvD"></script>
  </head>
  
  <body>
    <div id="iyoutingche-topa">
  	<ul class="nav nav-pills pull-right">  
		  <li  role="presentation" class="active"><a href="user/userLogin.jsp">登录</a></li>
		  <li role="presentation"><a href="user/userRegister.jsp">注册</a></li>
		  <li role="presentation"><a href="">个人中心</a></li>
		  <li role="presentation"><a href="">联系我们</a></li>
	</ul>
  </div>
  <div class="topl"></div>
    <div id="show_mapinfo"></div>
    <form Method="post">
    <!-- 现在先生成预约键和已停车键。重复的部分暂且先不管。先把这个解决之后再解决那个问题 -->
    <%
    	request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String depot_code = null;
    	List<Pcar_Space> Space_list = (List<Pcar_Space>)request.getAttribute("Space_list");
    //	List<Pcar_Order> Order_list = (List<Pcar_Order>)request.getAttribute("Order_list");
    	if(Space_list !=null){
    		Iterator<Pcar_Space> it = Space_list.iterator();
    		while(it.hasNext()){
    		Pcar_Space space = it.next();
    		int guard = Integer.parseInt(space.getSpace_guard());
    		depot_code = space.getDepot_code();
    %>
    	<h3>
    		<%=space.getSpace_coord() %>
    		<%if(guard==0){ %>
			 <input type="hidden" name="depot_code" value="<%=space.getSpace_coord()%>"/>
			 <input type="button" value="请预约" id="sajax"/>
    		<%}else{%>
    		<button disabled="disabled">已停车</button>
    		<%} %>
    	</h3>
    <%		
    		}
    	} 
    %>
    </form>
    <%
    	InPcar_Depot ipd = new Pcar_DepotImpl();
    	 Pcar_Depot depot  = ipd.FindByCode(depot_code);
    %>
    <input type="hidden" id="coordinate" value="<%=depot.getDepot_coord() %>"/>
    <script src="bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
  </body>
</html>