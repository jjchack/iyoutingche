package com.iyoutingche.web.userservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.iyoutingche.web.usermodel.PcarUser;
import com.iyoutingche.web.usermodel.Verify;
import com.iyoutingche.web.util.DBC;

public class PcarUserImpl implements InPcarUser {

	public boolean addUser(PcarUser user) throws Exception {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBC.getConnection();
		String sql = "insert into pcar_user (user_id,user_name,user_sex,user_password,user_email,user_phone,user_img,user_number" +
				")values(?,?,?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, user.getUser_id());
			pst.setString(2, user.getUser_name());
			pst.setString(3, user.getUser_sex());
			pst.setString(4, user.getUser_password());
			pst.setString(5, user.getUser_email());
			pst.setString(6, user.getUser_phone());
			pst.setString(7, user.getUser_img());
			pst.setString(8, user.getUser_number());
			if(pst.executeUpdate()>0){
				flag = true;
			}
			DBC.close(pst, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean FindUserByEmail(String email) {
		boolean flag = false;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		conn = DBC.getConnection();
		try {
			st = conn.createStatement();
			String sql = "select * from pcar_user where user_email = '"+email+"'";
			rs = st.executeQuery(sql);
			if(rs.next()){
				flag = true;   //为真 表明这个邮箱已经存在。
			}
			DBC.close(rs, st, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean delUser(String user_id) throws Exception {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBC.getConnection();
		String sql = "delete from pcar_user where user_id = '"+user_id+"'";
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

	public List<PcarUser> findUser() throws Exception {   //目前该方法没有找到用处呢。
		List<PcarUser> list =new ArrayList<PcarUser>();
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		conn = DBC.getConnection();
		try {
			st = conn.createStatement();
			String sql = "select * from pcar_user";
			rs = st.executeQuery(sql);
			while(rs.next()){
			PcarUser user = new PcarUser(rs.getString("user_id"), 
					rs.getString("user_name"), rs.getString("user_sex"), rs.getString("user_password"), rs.getString("user_email"),
					rs.getString("user_phone"), rs.getString("user_img"), rs.getString("user_number"));
			list.add(user);
			}
			DBC.close(rs, st, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean modifyUser(String userName, String userSex, String userEmail,
			String userPhone, String userNumber) throws Exception {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBC.getConnection();
		String sql = "update pcar_user set user_name='"+userName+"',user_sex='"+userSex+"',user_email='"+userEmail+"',user_phone='"+userPhone+"',user_number='"+userNumber+"' where user_email='"+userEmail+"'"
			;
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
	
	public boolean delVerify(String email) {
		boolean flag =false; 
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBC.getConnection();
		String sql = "delete from verify where stu_name = '"+email+"'";
		try {
			pst = conn.prepareStatement(sql);
			if(pst.executeUpdate()>0){
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	public String getVerify(String stuNameMd5, String randMd5) {
		String email = null;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		conn = DBC.getConnection();
		String sql = "select stu_name from verify where stu_nameMd5 = '"+stuNameMd5+"' and randMd5='"+randMd5+"'";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()){
				email = rs.getString("stu_name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return email;
	}

	
	public boolean addVerify(Verify verify) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBC.getConnection();
		String sql = "insert into verify (stu_name,stu_nameMd5,randMd5)values(?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(3, verify.getRandMd5());
			pst.setString(2, verify.getStu_nameMd5());
			pst.setString(1, verify.getStu_name());
			if(pst.executeUpdate()>0){
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean CheckLogin(String email, String password) {
		boolean flag = false;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		conn = DBC.getConnection();
		try {
			st = conn.createStatement();
			String sql = "select user_password from pcar_user where user_email = '"+email+"'";
			rs = st.executeQuery(sql);
			if(rs.next()){
				if(rs.getString("user_password").equals(password)){
					flag = true;
				}
			}
			DBC.close(rs, st, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public PcarUser FindUsersByEmail(String email) {
		PcarUser user=null;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		conn = DBC.getConnection();
		try {
			st = conn.createStatement();
			String sql = "select * from pcar_user where user_email ='"+email+"'";
			rs = st.executeQuery(sql);
			if(rs.next()){
			 user = new PcarUser(rs.getString("user_id"), 
					rs.getString("user_name"), rs.getString("user_sex"), rs.getString("user_password"), email,
					rs.getString("user_phone"), rs.getString("user_img"), rs.getString("user_number"));
			}
			DBC.close(rs, st, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean ModifyEmail(String email, String userimg) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBC.getConnection();
		String sql = "update pcar_user set user_img='"+userimg+"' where user_email='"+email+"'";
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
	public boolean ModifyPassword(String email, String password) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBC.getConnection();
		String sql = "update pcar_user set user_password='"+password+"' where user_email='"+email+"'";
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
