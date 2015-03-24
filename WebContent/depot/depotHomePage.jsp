<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.iyoutingche.web.depotmodel.Pcar_Depot"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'depotHomePage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%
    	List<Pcar_Depot> list =(List<Pcar_Depot>)request.getAttribute("list"); 
    	if(list != null){
    	Iterator<Pcar_Depot> it =list.iterator();
    	if(it.hasNext()){
    		Pcar_Depot depot = it.next();
    		
    %>
    <h1><a href="FindSpaceSer?depotcode=<%=depot.getDepot_code() %>"><%=depot.getDepot_name() %></a></h1>
    <%
    		}
    	}
    %>
  </body>
</html>
