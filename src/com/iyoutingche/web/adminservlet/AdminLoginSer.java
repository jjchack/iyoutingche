package com.iyoutingche.web.adminservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iyoutingche.web.adminservice.InPcarAdmin;
import com.iyoutingche.web.adminservice.PcarAdminImpl;

public class AdminLoginSer extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String adminemail = request.getParameter("adminemail");
		String adminpassword = request.getParameter("adminpassword");
		
		InPcarAdmin ipa = new PcarAdminImpl();
		boolean flag = ipa.adminCheckLogin(adminemail, adminpassword);
			request.getSession().setAttribute("adminemail", adminemail);
		//	System.out.println("admin=="+adminemail);
			out.print(flag);
			
	}

}
