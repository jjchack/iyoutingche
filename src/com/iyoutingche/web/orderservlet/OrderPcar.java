package com.iyoutingche.web.orderservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iyoutingche.web.spaceservice.InPcarSpace;
import com.iyoutingche.web.spaceservice.pcarSpaceImpl;

/**
 * Servlet implementation class OrderPcar
 */
public class OrderPcar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");	
		PrintWriter out=response.getWriter();
		String depotcode=request.getParameter("depotcode");
		String userid=request.getParameter("userid");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date=new Date();
		String[] preams={userid,depotcode,sdf.format(date).toString()};
		InPcarSpace ips = new pcarSpaceImpl();
		boolean flag=ips.AddOrder(preams);
		//System.out.println("flag="+flag);
		out.print(flag);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
