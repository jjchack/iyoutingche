package com.iyoutingche.web.spaceservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iyoutingche.web.depotmodel.Pcar_Space;
import com.iyoutingche.web.ordermodel.Pcar_Order;
import com.iyoutingche.web.orderservice.InPcar_Order;
import com.iyoutingche.web.orderservice.Pcar_OrderImpl;
import com.iyoutingche.web.spaceservice.InPcarSpace;
import com.iyoutingche.web.spaceservice.pcarSpaceImpl;

public class FindSpaceSer extends HttpServlet {

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
		String depotcode = request.getParameter("depotcode");
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		/*InPcarSpace ips = new pcarSpaceImpl();
		InPcar_Order ipo = new Pcar_OrderImpl();
		List<Pcar_Space> Space_list = ips.FindByDepot(depotcode);
		List<Pcar_Order> Order_list = ipo.FindByDepotCode(depotcode);
		request.setAttribute("Space_list", Space_list);
		request.setAttribute("Order_list", Order_list);*/
		request.setAttribute("depotcode", depotcode);
		request.setAttribute("x", x);
		request.setAttribute("y", y);
		request.getRequestDispatcher("depot/FindSpaces.jsp").forward(request, response);
	}
}
