package com.iyoutingche.web.orderservice;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.iyoutingche.web.depotmodel.Pcar_Depot;
import com.iyoutingche.web.ordermodel.Pcar_Order;
import com.iyoutingche.web.util.DBC;
import com.mysql.fabric.xmlrpc.base.Array;

public class Pcar_OrderImpl implements InPcar_Order {

	public List<Pcar_Order> FindByDepotCode(String depotCode) {
		List<Pcar_Order> list = new ArrayList<Pcar_Order>();
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		conn = DBC.getConnection();
		try {
			st = conn.createStatement();
			String sql = "select * from pcar_order where depot_code='"+depotCode+"'";
			rs = st.executeQuery(sql);
			while(rs.next()){
			Pcar_Order order = new Pcar_Order(rs.getString("user_id"),depotCode,rs.getString("space_code"),rs.getDate("record_date"),rs.getDate("record_again"),rs.getDate("record_end"));
			list.add(order);
			}
			DBC.close(rs, st, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean addOrder(Pcar_Order order) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBC.getConnection();
		String sql = "insert into pcar_order (user_id,depot_code,space_code,record_date," +
				"record_again,record_end"+
				")values(?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, order.getUser_id());
			pst.setString(2, order.getDepot_code());
			pst.setString(3, order.getSpace_code());
			pst.setDate(4, (Date) order.getRecord_date());
			pst.setDate(5, (Date) order.getRecord_again());
			pst.setDate(6, (Date) order.getRecord_end());
			if(pst.executeUpdate()>0){
				flag = true;
			}
			DBC.close(pst, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean delOrder(String spaceCode) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBC.getConnection();
		String sql = "delete from pcar_order where space_code = '"+spaceCode+"'";
		try {
			pst = conn.prepareStatement(sql);
			if(pst.executeUpdate()>0){
				flag = true;
			}
			DBC.close(pst, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
}