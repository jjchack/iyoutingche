package com.iyoutingche.web.adminservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.iyoutingche.web.adminmodel.Pcar_Admin;
import com.iyoutingche.web.depotservice.Pcar_DepotImpl;
import com.iyoutingche.web.util.DBC;

public class PcarAdminImpl extends Pcar_DepotImpl  implements InPcarAdmin{
	//admin_id,admin_name,admin_sex,admin_password,admin_email,admin_phone
	@Override
	public boolean PcarAdminAdd(Pcar_Admin admin) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBC.getConnection();
		String sql = "insert into pcar_admin (admin_id,admin_name,admin_sex,"
				+ "admin_password,admin_email,admin_phone)values(?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, admin.getAdmin_id());
			pst.setString(2, admin.getAdmin_name());
			pst.setString(3, admin.getAdmin_sex());
			pst.setString(4, admin.getAdmin_password());
			pst.setString(5, admin.getAdmin_email());
			pst.setString(6, admin.getAdmin_phone());
			if(pst.executeUpdate()>0){
				flag = true;
			}
			DBC.close(pst, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	@Override
	public boolean adminCheckLogin(String email,String password) {
		boolean flag = false;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		conn = DBC.getConnection();
		try {
			st = conn.createStatement();
			String sql = "select admin_password from pcar_admin where admin_email = '"+email+"'";
			rs = st.executeQuery(sql);
			if(rs.next()){
				if(rs.getString("admin_password").equals(password)){
					flag = true;
				}
			}
			DBC.close(rs, st, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	@Override
	public boolean CheckRegister(String email) { //如果flag为真表示已经注册了。
		boolean flag = false;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		conn = DBC.getConnection();
		try {
			st = conn.createStatement();
			String sql = "select admin_id from pcar_admin where admin_email = '"+email+"'";
			rs = st.executeQuery(sql);
			if(rs.next()){
					flag = true;   
			}
			DBC.close(rs, st, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
}
