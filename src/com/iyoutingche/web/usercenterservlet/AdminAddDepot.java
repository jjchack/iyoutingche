package com.iyoutingche.web.usercenterservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iyoutingche.web.adminmodel.Pcar_Admin_P;
import com.iyoutingche.web.adminservice.InPcarAdmin;
import com.iyoutingche.web.adminservice.InPcar_P_Admin;
import com.iyoutingche.web.adminservice.PcarAdminImpl;
import com.iyoutingche.web.adminservice.Pcar_P_AdminImpl;
import com.iyoutingche.web.depotmodel.Pcar_Depot;
import com.iyoutingche.web.depotmodel.Pcar_Space;
import com.iyoutingche.web.depotservice.InPcar_Depot;
import com.iyoutingche.web.spaceservice.InPcarSpace;
import com.iyoutingche.web.spaceservice.pcarSpaceImpl;
import com.iyoutingche.web.util.TimeStamp;

public class AdminAddDepot extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String depot_name = request.getParameter("depot_name");
		String depot_province = request.getParameter("depot_province");
		String depot_coord = request.getParameter("depot_coord");
		int depot_space = Integer.parseInt(request.getParameter("depot_space"));
		String depot_city = request.getParameter("depot_city");
		String depot_region = request.getParameter("depot_region");
		String admin_p_bank = request.getParameter("admin_p_bank");
		String admin_p_phone = request.getParameter("admin_p_phone");
		String admin_p_sex = request.getParameter("admin_p_sex");
		String admin_p_email = request.getParameter("admin_p_email");
		String admin_p_name = request.getParameter("admin_p_name");
		String depot_recommend = request.getParameter("depot_recommend");
		String depot_place = request.getParameter("depot_place");
		
		/*System.out.println("depot_recommend"+depot_recommend);
		System.out.println("depot_coord="+depot_coord);
		System.out.println("depot_space="+depot_space);*/
		String admin_p_id = TimeStamp.UUID(); //管理员id 由uuid自动生成
		String depot_code = TimeStamp.UUID();  //停车场二维码暂时有uuid自动生成
		//将depot_code 的值发送到另一个servlet中。
		request.getSession().setAttribute("depot_code", depot_code);
		
		String admin_p_password = "123456";
		InPcarSpace ips = new pcarSpaceImpl();
		String f = "0";
		boolean spaceflag = false;
		for(int i=0;i<depot_space;i++){
			String md5 = TimeStamp.MD5(""+i);
			Pcar_Space space = new Pcar_Space(md5,depot_code,"一排"+i+"号",""+i,f);
			boolean flag = ips.AddSpace(space);
			if(flag){
				spaceflag = true;
			}
		}
		Pcar_Depot depot = new Pcar_Depot(admin_p_id, depot_code, depot_province, 
				depot_city, depot_region, depot_name, depot_place, depot_coord, 
				depot_recommend, "");
		Pcar_Admin_P padmin = new Pcar_Admin_P(admin_p_id, admin_p_name, admin_p_sex, admin_p_email, 
				admin_p_phone, admin_p_password, admin_p_bank);
		InPcar_P_Admin ippa = new Pcar_P_AdminImpl();
		PcarAdminImpl ipa = new PcarAdminImpl();
		boolean flag = ipa.AddDepot(depot);
		boolean result = ippa.AddPcar_pAdmin(padmin);
		if(flag&&result&&spaceflag){
			out.print("true");
		}
	}
}
