package com.iyoutingche.web.depotservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.iyoutingche.web.adminmodel.Pcar_Admin_P;
import com.iyoutingche.web.adminservice.InPcar_P_Admin;
import com.iyoutingche.web.adminservice.Pcar_P_AdminImpl;
import com.iyoutingche.web.depotmodel.Pcar_Depot;
import com.iyoutingche.web.depotservice.InPcar_Depot;
import com.iyoutingche.web.depotservice.Pcar_DepotImpl;

public class AdminFindDepotSer extends HttpServlet {

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
		
		PrintWriter out = response.getWriter();
		String address_depot = request.getParameter("address_depot");
		InPcar_Depot ipd = new Pcar_DepotImpl();
		//System.out.println("----keys="+address_depot);
		List<Pcar_Depot> list =ipd.FindByKeywords(address_depot);
		InPcar_P_Admin ippa = new Pcar_P_AdminImpl(); 
		if(list != null){
			JSONArray json = new JSONArray();
			Iterator<Pcar_Depot> it = list.iterator();
			while(it.hasNext()){
				Pcar_Depot depot = it.next();
				Pcar_Admin_P padmin = ippa.FindById(depot.getAmin_p_id());
				JSONObject jo = new JSONObject();
				try {
					jo.put("depot_province", depot.getDepot_province());
					jo.put("depot_code", depot.getDepot_code());
					jo.put("depot_name", depot.getDepot_name());
					jo.put("depot_city", depot.getDepot_city());
					jo.put("depot_region", depot.getDepot_region());
					jo.put("depot_place", depot.getDepot_place());
					jo.put("depot_coord", depot.getDepot_coord());//坐标
					jo.put("depot_recommend", depot.getDepot_recommend());
					jo.put("depot_img", depot.getDepot_img());
					json.put(jo);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			out.print(json.toString());
		}
	}

}
