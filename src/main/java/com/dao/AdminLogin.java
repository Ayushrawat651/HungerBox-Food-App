package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.connection.DBconnection;

public class AdminLogin {
	public String adminLogin(String email) {
		String password_db = "";
		Scanner sc = new Scanner(System.in);
		DBconnection dbcon = new DBconnection();

		Connection con = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;

		String query = "SELECT adminPassword FROM ADMIN WHERE adminEmail=?";

		try {

			con = dbcon.dbConnect();
			if (con == null) {
				throw new SQLException("Database connection is not available.");
			}

			pstat = con.prepareStatement(query);

			pstat.setString(1, email);

			rs = pstat.executeQuery();

			if (rs.next()) {
				password_db = rs.getString(1);
				System.out.println("Login Successful!!!");
				return password_db;
			} else {
				System.out.println("Error in Admin Login!!!");
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstat != null)
					pstat.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
