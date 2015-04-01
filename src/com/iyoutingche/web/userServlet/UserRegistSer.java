package com.iyoutingche.web.userServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iyoutingche.web.usermodel.PcarUser;
import com.iyoutingche.web.usermodel.Verify;
import com.iyoutingche.web.userservice.InPcarUser;
import com.iyoutingche.web.userservice.PcarUserImpl;
import com.iyoutingche.web.util.Mailer;
import com.iyoutingche.web.util.TimeStamp;


public class UserRegistSer extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("utf-8");
		 
		 String user_name = request.getParameter("user_name");
		 String user_password = request.getParameter("user_password");
		 String user_email = request.getParameter("user_email");
		 
		 PrintWriter out = response.getWriter();
		 InPcarUser ipu = new PcarUserImpl();
	 System.out.println("邮箱地址"+user_email);
		 boolean result = ipu.FindUserByEmail(user_email);  // 判断邮箱是否被注册过。true表明已经注册过。
		 if(!result){ 
		 request.getSession().setAttribute("user_name", user_name);
		 request.getSession().setAttribute("user_password", user_password);
		 request.getSession().setAttribute("user_email", user_email);
		 
		 Mailer sendemail = new Mailer();
		 
		//生成验证码。
		 String uuid = TimeStamp.UUID();
		 String md5 = TimeStamp.MD5(user_email);    
		 sendemail.sendMail(uuid,md5,user_email);   //调用发送email方法
		 //添加邮箱信息到临时数据中
		  Verify verify = new Verify();
		  verify.setRandMd5(md5);
		  verify.setStu_nameMd5(uuid);
		  verify.setStu_name(user_email);
		  boolean flag = ipu.addVerify(verify);
		  
		  if(flag){
		//	  System.out.println("添加到了临时表中");
			  response.sendRedirect("index.jsp");
		  }
		 }else{
		//	 System.out.println("已经注册过了");
			 out.print("true");
		 }
	}
}
