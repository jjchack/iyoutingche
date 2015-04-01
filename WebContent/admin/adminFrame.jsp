<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理员主界面</title>
</head>
	<%
	 	String adminemail = (String)session.getAttribute("adminemail");
		if(adminemail==null){
			 response.sendRedirect("adminLogin.jsp");
		}
	%>
 <frameset rows="70,*" frameborder="no" border="0" framespacing="0" style="overflow:visible">
	<frame name="index" src="adminTop.jsp" />
	<frameset cols="273px,*">
	<frame name="left" src="adminLeft.jsp" />
	<frame name="right" src="adminRight.jsp" />
	</frameset>
</frameset>
</html>