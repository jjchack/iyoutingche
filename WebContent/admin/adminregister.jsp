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
<title>管理员注册界面</title>
</head>
<body>
	<form action="<%=basePath %>AdminRegister" method="post">
	用户名：<input type="text" name="adminname"><br/>
	邮箱号：<input type="text" name="adminemail"><br/>
	密码：<input type="password" name="adminpassword"><br/>
	确认密码：<input type="password" name="admin_repassword"><br/>
	性别：<input type="text" name="adminsex"><br/>
	联系方式：<input type="text" name="adminphone"><br/>
		<input type="submit" value="注册">
	</form>
</body>
</html>