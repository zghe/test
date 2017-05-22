package com.guo.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static Connection conn = null;
	
	public ConnectionManager(){
		this("hzg","123");
	} 
	
	public ConnectionManager(String username, String password) {
		String driverName  = "driver.OracleDriver.SQLServerDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521/testdb";
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnctionManager(){
		 if(conn == null)
			  new ConnectionManager();
		   return conn;
	}
	
	public static void closeConnection(){
	}
}
