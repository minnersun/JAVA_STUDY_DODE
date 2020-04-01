package com.tedu.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	private JDBCUtils(){
		
	}
	// �������ӳض���
	public static ComboPooledDataSource pool = new ComboPooledDataSource();
	// �������ӳض���
	public static ComboPooledDataSource getPoor(){
		return pool;
	}
	
	public static void close(Connection conn,Statement stat,ResultSet rs){

		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				rs = null;
			}
		}
		if(stat!=null){
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				stat = null;
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				conn = null;
			}
		}
		
	}
	
}
