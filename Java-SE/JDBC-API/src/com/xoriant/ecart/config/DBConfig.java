package com.xoriant.ecart.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {

	private static Connection con = null;

	public static Connection getConnection() {

		if (con == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root1234");
				return con;
			} catch (Exception e) {
				System.out.println("Issue while connecting to DB: " + e);
				e.printStackTrace();
			}
		}
		return con;

	}

	// close connection
	public static void closeConnection() {

		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
