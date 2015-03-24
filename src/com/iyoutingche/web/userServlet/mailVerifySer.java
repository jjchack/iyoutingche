package com.iyoutingche.web.userServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iyoutingche.web.usermodel.PcarUser;
import com.iyoutingche.web.userservice.InPcarUser;
import com.iyoutingche.web.userservice.PcarUserImpl;

public class mailVerifySer extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 response.setCharacterEncoding("GBK");
		 
		 String uuid = request.getParameter("uuid");
		 String Md5 = request.getParameter("md5");
	//	 System.out.println(UUID+"   "+Md5);
		String username = (String)request.getSession().getAttribute("user_name");
		String userpassword = (String) request.getSession().getAttribute("user_password");
		String useremail = (String)request.getSession().getAttribute("user_email");
		System.out.println("useremail==="+useremail);
		PrintWriter out = response.getWriter();
		InPcarUser ipu = new PcarUserImpl();
		String email = ipu.getVerify(uuid,Md5);
		System.out.println("email----"+email);
		if(email.equals(useremail)){   //说明邮箱验证正确。
			PcarUser user = new PcarUser();
			String userid = UUID.randomUUID().toString(); //暂时先用uuid作为id
			System.out.println("userid==="+userid);
			user.setUser_id(userid);
			user.setUser_email(useremail);
			user.setUser_password(userpassword);
			user.setUser_name(username);
			boolean falgV = ipu.delVerify(email);
			 System.out.println("falgV"+falgV);
			 boolean flagS;
			try {
				flagS = ipu.addUser(user);
				System.out.println("===="+flagS);
				if(flagS){
					//out.print("账号已激活");
					out.print("<script>alert('账号已激活');window.location.href='index.jsp'</script>");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}  //向表中添加信息
		}
		
	}
}

