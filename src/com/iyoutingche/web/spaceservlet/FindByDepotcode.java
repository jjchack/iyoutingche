package com.iyoutingche.web.spaceservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.iyoutingche.web.depotmodel.Pcar_Space;
import com.iyoutingche.web.spaceservice.InPcarSpace;
import com.iyoutingche.web.spaceservice.pcarSpaceImpl;

/**
 * Servlet implementation class FindByDecoptCode
 */
@WebServlet("/FindByDecoptCode")
public class FindByDepotcode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindByDepotcode() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");	
		PrintWriter out=response.getWriter();
		
		String depotcode = request.getParameter("depotcode");
		//System.out.println("depotcode:"+depotcode);
		
		InPcarSpace ips = new pcarSpaceImpl();
		int count=ips.GetAllCount(depotcode);
		int Pcar_count=ips.GetPark(depotcode);
		int Order_count=ips.GetALLOrder(depotcode);
		int avialable=count-Pcar_count-Order_count;
		//System.out.println(Order_count);
		JSONObject json=new JSONObject();
		try {
			json.put("count", count);
			json.put("order", avialable);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(json.toString());
		out.print(json.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
