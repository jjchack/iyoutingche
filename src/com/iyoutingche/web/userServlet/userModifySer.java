package com.iyoutingche.web.userServlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iyoutingche.web.depotservice.Pcar_DepotImpl;
import com.iyoutingche.web.usermodel.PcarUser;
import com.iyoutingche.web.userservice.InPcarUser;
import com.iyoutingche.web.userservice.PcarUserImpl;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;


public class userModifySer extends HttpServlet {

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
		request.setCharacterEncoding("utf-8"); 
	  	response.setCharacterEncoding("utf-8"); 
	  	
	  	String userid = (String)request.getParameter("userid");
	  	String email = (String)request.getParameter("email");
	  	String userimg = (String)request.getParameter("userimg");
	  	String username = (String)request.getParameter("username");
	  	String usersex = (String)request.getParameter("usersex");
	  	String userphone = (String)request.getParameter("userphone");
	  	String usernumber = (String)request.getParameter("usernumber");
	  	
	  	InPcarUser ipu = new PcarUserImpl();
	  	boolean flag;
		try {
			flag = ipu.modifyUser(username,usersex,email, userphone, usernumber);
			if(flag){
		  		request.getRequestDispatcher("userFindByEmail?email="+email+"").forward(request, response);
		  	}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  	
	}

}
