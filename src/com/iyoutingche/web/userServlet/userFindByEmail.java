package com.iyoutingche.web.userServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iyoutingche.web.usermodel.PcarUser;
import com.iyoutingche.web.userservice.InPcarUser;
import com.iyoutingche.web.userservice.PcarUserImpl;

public class userFindByEmail extends HttpServlet {
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
		request.setCharacterEncoding("utf-8");
	  	response.setCharacterEncoding("utf-8");
	  	String email = request.getParameter("email");
	  	String info = request.getParameter("info");
	  	if(email != null){
	  		InPcarUser ipu = new PcarUserImpl();
	  		PcarUser user = ipu.FindUsersByEmail(email);
	  		if(user !=null){
	  			request.getSession().setAttribute("email", email);
	  			request.setAttribute("user", user);
	  			if(info!=null && info.equals("a")){
		  			request.getRequestDispatcher("user/usercenter/UserBaseInfo.jsp").forward(request, response);
		  		}else if(info == null){
		  			request.getRequestDispatcher("user/UserCenterFrame.jsp").forward(request, response);
	  			}
		  	}
	  	}
	}
}
