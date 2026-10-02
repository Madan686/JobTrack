package com.demo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectivity {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jobTrack_db", "root", "newpassword");
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		return con;
	}

}
