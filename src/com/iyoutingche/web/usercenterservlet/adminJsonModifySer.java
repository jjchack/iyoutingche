package com.iyoutingche.web.usercenterservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iyoutingche.web.adminmodel.Pcar_Admin;
import com.iyoutingche.web.adminservice.InPcarAdmin;
import com.iyoutingche.web.adminservice.PcarAdminImpl;

public class adminJsonModifySer extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		String adminid = request.getParameter("adminid");
		String adminname = request.getParameter("adminname");
		String adminemail = request.getParameter("adminemail");
		String adminsex = request.getParameter("adminsex");
		String adminphone = request.getParameter("adminphone");
		
		System.out.println("adminid"+adminid);
		
		InPcarAdmin ipa = new PcarAdminImpl();
		boolean flag = ipa.PcarAdminModify(adminid, adminname, adminsex, adminemail, adminphone);
		out.print(flag);
	}
}
