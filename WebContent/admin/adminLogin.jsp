<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=basePath %>AdminLoginSer" method="post">
	邮箱号：<input type="text" name="adminemail"><br/>
	密码：<input type="password" name="adminpassword"><br/>
		<input type="submit" value="登录">
		<a href="adminregister.jsp">注册</a>
	</form>
</body>
</html>