package com.iyoutingche.web.depotservice;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.iyoutingche.web.depotmodel.Pcar_Depot;
import com.iyoutingche.web.usermodel.PcarUser;
import com.iyoutingche.web.util.DBC;
import com.iyoutingche.web.util.KeysOptimize;

public class Pcar_DepotImpl implements InPcar_Depot{

	public boolean AddDepot(Pcar_Depot depot) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBC.getConnection();
		String sql = "insert into pcar_depot (admin_p_id,depot_code,depot_province,depot_city," +
				"depot_region,depot_name,depot_place,depot_coord,depot_recommend,depot_img" +
				")values(?,?,?,?,?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, depot.getAmin_p_id());
			pst.setString(2, depot.getDepot_code());
			pst.setString(3, depot.getDepot_province());
			pst.setString(4, depot.getDepot_city());
			pst.setString(5, depot.getDepot_region());
			pst.setString(6, depot.getDepot_name());
			pst.setString(7, depot.getDepot_place());
			pst.setString(8, depot.getDepot_coord());
			pst.setString(9, depot.getDepot_recommend());
			pst.setString(10, depot.getDepot_img()); 
			if(pst.executeUpdate()>0){
				flag = true;
			}
			DBC.close(pst, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean DelDepot(String depotCode) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBC.getConnection();
		String sql = "delete from pcar_depot where depot_code = '"+depotCode+"'";
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

	public List<Pcar_Depot> FindByCity(String city) {
		List<Pcar_Depot> list =new ArrayList<Pcar_Depot>();
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		conn = DBC.getConnection();
		try {
			st = conn.createStatement();
			String sql = "select * from pcar_depot where depot_city='"+city+"'";
			rs = st.executeQuery(sql);
			while(rs.next()){
			Pcar_Depot depot = new Pcar_Depot(rs.getString("admin_p_id"),rs.getString("depot_code"),rs.getString("depot_province"),city,
					rs.getString("depot_region"),rs.getString("depot_name"),rs.getString("depot_place"),rs.getString("depot_coord"),rs.getString("depot_recommend")
					,rs.getString("depot_img"));
			list.add(depot);
			}
			DBC.close(rs, st, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Pcar_Depot> FindByKeywords(String keys) {
		String key = KeysOptimize.KeyOptimize(keys);    //关键字的优化即省略空格、乱输入的内容等
		List<Pcar_Depot> list = new ArrayList<Pcar_Depot>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try{
			conn = DBC.getConnection();
			String sql = "SELECT * FROM pcar_depot WHERE " +
					"depot_province like ? or depot_city like ? or depot_region like ? "; 
			pst = conn.prepareStatement(sql);
			pst.setString(1, "%"+key+"%");  // 省关键字查询。
			pst.setString(2, "%"+key+"%"); //市名关键字查询
			pst.setString(3, "%"+key+"%"); //区别关键字查询
			rs = pst.executeQuery();
			while(rs.next()){
				Pcar_Depot depot = new Pcar_Depot(rs.getString("admin_p_id"),rs.getString("depot_code"),rs.getString("depot_province"),rs.getString("depot_city"),
						rs.getString("depot_region"),rs.getString("depot_name"),rs.getString("depot_place"),rs.getString("depot_coord"),rs.getString("depot_recommend")
						,rs.getString("depot_img"));
				list.add(depot);
				}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBC.close(rs, pst, conn);
		}
		return list;
	}

	public List<Pcar_Depot> FindByProvince(String province) {
		List<Pcar_Depot> list =new ArrayList<Pcar_Depot>();
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		conn = DBC.getConnection();
		try {
			st = conn.createStatement();
			String sql = "select * from pcar_depot where depot_province='"+province+"'";
			rs = st.executeQuery(sql);
			while(rs.next()){
			Pcar_Depot depot = new Pcar_Depot(rs.getString("admin_p_id"),rs.getString("depot_code"),province,rs.getString("depot_city"),
					rs.getString("depot_region"),rs.getString("depot_name"),rs.getString("depot_place"),rs.getString("depot_coord"),rs.getString("depot_recommend")
					,rs.getString("depot_img"));
			list.add(depot);
			}
			DBC.close(rs, st, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Pcar_Depot> FindByRegion(String region) {
		List<Pcar_Depot> list =new ArrayList<Pcar_Depot>();
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		conn = DBC.getConnection();
		try {
			st = conn.createStatement();
			String sql = "select * from pcar_depot where depot_region='"+region+"'";
			rs = st.executeQuery(sql);
			while(rs.next()){
			Pcar_Depot depot = new Pcar_Depot(rs.getString("admin_p_id"),rs.getString("depot_code"),rs.getString("depot_province"),rs.getString("depot_city"),
					region,rs.getString("depot_name"),rs.getString("depot_place"),rs.getString("depot_coord"),rs.getString("depot_recommend")
					,rs.getString("depot_img"));
			list.add(depot);
			}
			DBC.close(rs, st, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean ModifyDepot(Pcar_Depot depot) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBC.getConnection();
		String sql = "update pcar_depot set admin_p_id=?,depot_province=?,depot_city=?," +
				"depot_region=?,depot_name=?,depot_place=?,depot_coord=?,depot_recommend=?,depot_img=? where depot_code =?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(10, depot.getDepot_code());
			pst.setString(1, depot.getAmin_p_id());
			pst.setString(2, depot.getDepot_province());
			pst.setString(3, depot.getDepot_city());
			pst.setString(4, depot.getDepot_region());
			pst.setString(5, depot.getDepot_name());
			pst.setString(6, depot.getDepot_place());
			pst.setString(7, depot.getDepot_coord());
			pst.setString(8, depot.getDepot_recommend());
			pst.setString(9, depot.getDepot_img()); 
			if(pst.executeUpdate()>0){
				flag = true;
			}
			DBC.close(pst, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public Pcar_Depot FindByCode(String depotCode) {
		Pcar_Depot depot=null;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		conn = DBC.getConnection();
		try {
			st = conn.createStatement();
			String sql = "select * from pcar_depot where depot_code='"+depotCode+"'";
			rs = st.executeQuery(sql);
			if(rs.next()){
			  depot = new Pcar_Depot(rs.getString("admin_p_id"),depotCode,rs.getString("depot_province"),rs.getString("depot_city"),
					 rs.getString("depot_region"),rs.getString("depot_name"),rs.getString("depot_place"),rs.getString("depot_coord"),rs.getString("depot_recommend")
					,rs.getString("depot_img"));
			}
			DBC.close(rs, st, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return depot;
	}
	@Override
	public boolean ModifyDepotImg(String depot_code, String depot_img) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBC.getConnection();
		String sql = "update pcar_depot set depot_img='"+depot_img+"' where depot_code='"+depot_code+"'";
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
