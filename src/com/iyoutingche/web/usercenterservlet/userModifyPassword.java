package com.iyoutingche.web.usercenterservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iyoutingche.web.userservice.InPcarUser;
import com.iyoutingche.web.userservice.PcarUserImpl;

/**
 * Servlet implementation class userModifyPassword
 */
public class userModifyPassword extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String password = request.getParameter("newreuserpass");
		//System.out.println("password=="+password);
		String email = (String)request.getSession().getAttribute("email");
		//System.out.println("email=====userModify"+email);
		
		PrintWriter out = response.getWriter();
		InPcarUser ipu = new PcarUserImpl();
		boolean flag = ipu.ModifyPassword(email, password);
		//System.out.println("flag"+flag);
		out.print(flag);
	}

}
