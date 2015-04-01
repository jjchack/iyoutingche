package com.iyoutingche.web.usercenterservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.iyoutingche.web.usermodel.PcarUser;
import com.iyoutingche.web.userservice.InPcarUser;
import com.iyoutingche.web.userservice.PcarUserImpl;

public class userJsonModifySer extends HttpServlet {

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
	  	String username = (String)request.getParameter("username");
	  	String usersex = (String)request.getParameter("usersex");
	  	String userphone = (String)request.getParameter("userphone");
	  	String usernumber = (String)request.getParameter("usernumber");
	  	
	  	PrintWriter out = response.getWriter();
	  	InPcarUser ipu = new PcarUserImpl();
	  	boolean flag;
		try {
			flag = ipu.modifyUser(username,usersex,email, userphone, usernumber);
			if(flag){
			//	System.out.println("userJsonModifySer.java!修改成功"+username);
				//说明修改成功了，那么就需要从后台再次获取这写数据。写成json语句返回给前台
				PcarUser user = ipu.FindUsersByEmail(email);
				System.out.println("++++++修改后获得的值"+user.getUser_email());
				JSONObject jo = new JSONObject();
				jo.put("email", user.getUser_email());
				jo.put("userid", user.getUser_id());
				jo.put("username", user.getUser_name());
				jo.put("usersex", user.getUser_sex());
				jo.put("userphone", user.getUser_phone());
				jo.put("usernumber", user.getUser_number());
				
			//	System.out.println("json"+jo.toString());
				out.print(jo.toString());
		  	}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
