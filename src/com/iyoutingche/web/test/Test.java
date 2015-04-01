package com.iyoutingche.web.test;

import com.iyoutingche.web.adminmodel.Pcar_Admin;
import com.iyoutingche.web.adminmodel.Pcar_Admin_P;
import com.iyoutingche.web.adminservice.InPcarAdmin;
import com.iyoutingche.web.adminservice.InPcar_P_Admin;
import com.iyoutingche.web.adminservice.PcarAdminImpl;
import com.iyoutingche.web.adminservice.Pcar_P_AdminImpl;
import com.iyoutingche.web.depotmodel.Pcar_Depot;
import com.iyoutingche.web.depotmodel.Pcar_Space;
import com.iyoutingche.web.depotservice.InPcar_Depot;
import com.iyoutingche.web.depotservice.Pcar_DepotImpl;
import com.iyoutingche.web.ordermodel.Pcar_Order;
import com.iyoutingche.web.orderservice.InPcar_Order;
import com.iyoutingche.web.orderservice.Pcar_OrderImpl;
import com.iyoutingche.web.spaceservice.InPcarSpace;
import com.iyoutingche.web.spaceservice.pcarSpaceImpl;
import com.iyoutingche.web.usermodel.PcarUser;
import com.iyoutingche.web.userservice.InPcarUser;
import com.iyoutingche.web.userservice.PcarUserImpl;
import com.iyoutingche.web.util.DBC;
import com.iyoutingche.web.util.IPTimeStamp;
import com.iyoutingche.web.util.TimeStamp;

import java.sql.Connection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		InPcar_Depot ipd = new Pcar_DepotImpl();
		boolean flag = ipd.ModifyDepotImg("ad16bef8-9042-4e67-81b0-63e72448bc14", "nimi");
		System.out.println("flag="+flag);
	}
}
