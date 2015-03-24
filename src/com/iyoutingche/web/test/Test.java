package com.iyoutingche.web.test;

import com.iyoutingche.web.adminmodel.Pcar_Admin;
import com.iyoutingche.web.adminservice.InPcarAdmin;
import com.iyoutingche.web.adminservice.PcarAdminImpl;
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
		InPcarAdmin ipa = new PcarAdminImpl();
		try {
			Pcar_Admin admin = new Pcar_Admin(TimeStamp.UUID(),
					"JAY阿卧", "男", "824337531@qq.com", "18939171376", "123456");
			boolean flag = ipa.CheckRegister("824337531@qq.com");
			System.out.println("已经注册？"+flag);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
