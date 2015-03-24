package com.iyoutingche.web.util;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBC {
	private static String driver="com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/pcar?user=root&password=mysqladmin"+
								"&useUnicode=true&characterEncoding=UTF-8";
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(ResultSet rs, Statement st, Connection conn)
	{
		try
		{
			if(rs != null)
			{
				rs.close();
			}
			if(st != null)
			{
				st.close();
			}
			if(conn != null)
			{
				conn.close();
			}
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	public static void close(Statement st, Connection conn)
	{
		close(null,st,conn);
	}
}
