package com.iyoutingche.web.usercenterservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iyoutingche.web.adminservice.InPcarAdmin;
import com.iyoutingche.web.adminservice.PcarAdminImpl;
import com.iyoutingche.web.userservice.InPcarUser;
import com.iyoutingche.web.userservice.PcarUserImpl;

public class adminModifyPassword extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String password = request.getParameter("newreadminpass");
		System.out.println("password=="+password);
		String adminemail = (String)request.getSession().getAttribute("adminemail");
		System.out.println("email=====userModify"+adminemail);
		
		PrintWriter out = response.getWriter();
		InPcarAdmin ipa = new PcarAdminImpl();
		boolean flag = ipa.PcarAdminModifyPass(password, adminemail);
		out.print(flag);
	}

}
