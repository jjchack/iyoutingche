package com.iyoutingche.web.adminservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.iyoutingche.web.adminmodel.Pcar_Admin_P;
import com.iyoutingche.web.util.DBC;

public class Pcar_P_AdminImpl implements InPcar_P_Admin {

	@Override
	public boolean AddPcar_pAdmin(Pcar_Admin_P padmin) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBC.getConnection();
		String sql = "insert into pcar_admin_p (admin_p_id,admin_p_name,admin_p_sex,"
				+ "admin_p_password,admin_p_email,admin_p_phone,admin_p_bank)values(?,?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, padmin.getAdmin_id());
			pst.setString(2, padmin.getAdmin_name());
			pst.setString(3, padmin.getAdmin_sex());
			pst.setString(4, padmin.getAdmin_password());
			pst.setString(5, padmin.getAdmin_email());
			pst.setString(6, padmin.getAdmin_phone());
			pst.setString(7, padmin.getPcar_p_bank());
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
	public boolean DelPcar_pAdmin(String admin_p_id) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBC.getConnection();
		String sql = "delete from pcar_admin_p where admin_p_id = '"+admin_p_id+"'";
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

	@Override
	public Pcar_Admin_P FindById(String admin_p_id) {
		Pcar_Admin_P padmin=null;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		conn = DBC.getConnection();
		try {
			st = conn.createStatement();
			String sql = "select * from pcar_admin_p where admin_p_id = '"+admin_p_id+"'";
			rs = st.executeQuery(sql);
			if(rs.next()){
				//admin_id,admin_name,admin_sex,admin_password,admin_email,admin_phone
				padmin = new Pcar_Admin_P(admin_p_id, rs.getString("admin_p_name"),
						rs.getString("admin_p_sex"),rs.getString("admin_p_email"), rs.getString("admin_p_phone"),
						rs.getString("admin_p_password"),rs.getString("admin_p_bank"));
			}
			DBC.close(rs, st, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return padmin;
	}

	@Override
	public boolean ModifyById(String adminid, String admin_name,
			String admin_sex, String admin_email, String admin_phone,
			String admin_p_bank) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBC.getConnection();
		String sql = "update pcar_admin_p set admin_p_name='"+admin_name+"',"
				+ "admin_p_sex='"+admin_sex+"',admin_p_email='"+admin_email+"',admin_p_phone='"+admin_phone+"',"
						+ "admin_p_bank='"+admin_p_bank+"' where admin_p_id='"+adminid+"'";
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
