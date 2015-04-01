package com.iyoutingche.web.adminservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iyoutingche.web.adminmodel.Pcar_Admin;
import com.iyoutingche.web.adminservice.InPcarAdmin;
import com.iyoutingche.web.adminservice.PcarAdminImpl;

public class AdminSystemSer extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		String req = request.getParameter("req");
		System.out.println("req==="+req);
		String adminemail=(String)request.getSession().getAttribute("adminemail");
		if(req.equals("myinfo")){  //个人信息的操作
			InPcarAdmin ipa = new PcarAdminImpl();
			Pcar_Admin admin = ipa.FindByEmail(adminemail);
			request.setAttribute("admin", admin);
			request.getRequestDispatcher("/admin/adminRight.jsp").forward(request, response);
		}
	}

}
