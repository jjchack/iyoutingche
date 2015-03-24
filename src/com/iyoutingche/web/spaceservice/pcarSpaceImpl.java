package com.iyoutingche.web.spaceservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.iyoutingche.web.depotmodel.Pcar_Space;
import com.iyoutingche.web.usermodel.PcarUser;
import com.iyoutingche.web.util.DBC;

public class pcarSpaceImpl implements InPcarSpace {

	public boolean AddSpace(Pcar_Space space) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBC.getConnection();
		String sql = "insert into pcar_space (space_code,depot_code,space_place,space_coord,space_guard" +
				")values(?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, space.getSpace_code());
			pst.setString(2, space.getDepot_code());
			pst.setString(3, space.getSpace_place());
			pst.setString(4, space.getSpace_coord());
			pst.setString(5, space.getSpace_guard());
			if(pst.executeUpdate()>0){
				flag = true;
			}
			DBC.close(pst, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean DelSpace(String spaceCode) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBC.getConnection();
		String sql = "delete from pcar_space where space_code = '"+spaceCode+"'";
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

	public List<Pcar_Space> FindByDepot(String depotCode) {
		List<Pcar_Space> list =new ArrayList<Pcar_Space>();
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		conn = DBC.getConnection();
		try {
			st = conn.createStatement();
			String sql = "select * from pcar_space where depot_code ='"+depotCode+"'";   //查询该停车场中所有的停车位。
			rs = st.executeQuery(sql);
			while(rs.next()){
				Pcar_Space space = new Pcar_Space(rs.getString("space_code"),depotCode,rs.getString("space_place")
						,rs.getString("space_coord"),rs.getString("space_guard"));
			list.add(space);
			}
			DBC.close(rs, st, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int GetAllCount(String depotCode) {
		 int cnt=0;//返回值
	       Connection conn=DBC.getConnection();
	       if(conn!=null){
	        String sql="select count(*) from pcar_space where depot_code='"+depotCode+"' ";
	        try{
		         Statement st=conn.createStatement();
		         ResultSet rs=st.executeQuery(sql);
		         while(rs.next()){
		        	 cnt=rs.getInt(1);
		         }
	        }catch(SQLException e){
	        	e.printStackTrace();
	        }
	      }
	      return cnt;
	}

	public int GetPark(String depotCode) {   //得到停车场中被占停车位的数量
		 int cnt=0;//返回值
	       Connection conn=DBC.getConnection();
	       if(conn!=null){
	        String sql="select count(*) from pcar_space where depot_code='"+depotCode+"' and space_guard=1"; //space_guard为1表示车位被占
	        try{
		         Statement st=conn.createStatement();
		         ResultSet rs=st.executeQuery(sql);
		         while(rs.next()){
		        	 cnt=rs.getInt(1);
		         }
	        }catch(SQLException e){
	        	e.printStackTrace();
	        }
	      }
	      return cnt;
	}

	public boolean ModifySpace(Pcar_Space space) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBC.getConnection();
		String sql = "update pcar_space set depot_code=?,space_place=?,space_coord=?,space_guard=? where space_code='"+space.getSpace_code()+"'"
			;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, space.getDepot_code());
			pst.setString(2, space.getSpace_place());
			pst.setString(3, space.getSpace_coord());
			pst.setString(4, space.getSpace_guard());
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
