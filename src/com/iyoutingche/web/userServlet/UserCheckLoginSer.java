package com.iyoutingche.web.userServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iyoutingche.web.userservice.InPcarUser;
import com.iyoutingche.web.userservice.PcarUserImpl;

public class UserCheckLoginSer extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setCharacterEncoding("utf-8");
			request.setCharacterEncoding("utf-8");
			
		String email = request.getParameter("user_email");
		String password = request.getParameter("user_password");
		String isAuto = request.getParameter("isAuto");
		
		//System.out.println("useremail="+email);
		PrintWriter out= response.getWriter();
		InPcarUser ipu = new PcarUserImpl();
		boolean flag = ipu.CheckLogin(email, password);
		request.getSession().setAttribute("email", email);
		request.getSession().setAttribute("password", password);
		out.print(flag);
		/*if(flag){
			request.getSession().setAttribute("email", email);
			request.getSession().setAttribute("password", password);
			out.print(flag);
			if(isAuto==null){
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else if(isAuto.equals("1")){
				Cookie usercookie = new Cookie("email",email);
				usercookie.setMaxAge(60*60*24);
				response.addCookie(usercookie);
				
				Cookie passcookie = new Cookie("password",password);
				usercookie.setMaxAge(60*60*24);
				response.addCookie(passcookie);
				System.out.println("+++正");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}else{
			System.out.println("错误");
			out.print("failed");
		}*/
	}

}
