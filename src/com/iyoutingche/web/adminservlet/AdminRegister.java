package com.iyoutingche.web.adminservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iyoutingche.web.adminmodel.Pcar_Admin;
import com.iyoutingche.web.adminservice.InPcarAdmin;
import com.iyoutingche.web.adminservice.PcarAdminImpl;
import com.iyoutingche.web.util.TimeStamp;
public class AdminRegister extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		String adminname = request.getParameter("adminname");
		String adminemail = request.getParameter("adminemail");
		String adminpassword = request.getParameter("adminpassword");
		String adminsex = request.getParameter("adminsex");
		String adminphone = request.getParameter("adminphone");
		
		InPcarAdmin ipa = (InPcarAdmin) new PcarAdminImpl();
		boolean flag = ipa.CheckRegister(adminemail);
		if(flag){
			out.print("已经注册过");
		}else{
			String adminid = TimeStamp.UUID();
			Pcar_Admin admin = new Pcar_Admin(adminid, adminname, adminsex,
					adminemail, adminphone, adminpassword);
			boolean result = ipa.PcarAdminAdd(admin);
			if(result){
				response.sendRedirect("admin/adminLogin.jsp");
			}else{
				System.out.println("注册失败");
			}
		}
	}

}
