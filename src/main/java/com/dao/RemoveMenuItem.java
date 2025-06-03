package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.connection.DBconnection;

public class RemoveMenuItem {
	public boolean removeMenuItem(String dishName) {
		DBconnection dbcon = new DBconnection();

		Connection con = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;

		String query = "DELETE FROM MENU WHERE dishName = ?";
		
		try {
			con = dbcon.dbConnect();
			if (con == null) {
				throw new SQLException("Database connection is not available.");
			}

			pstat = con.prepareStatement(query);
			
			pstat.setString(1, dishName);

			
			int status = pstat.executeUpdate();

			if (status > 0) {
				System.out.println("hereeeeeeeeeeeeeeeeeeeeeeeeee");
				con.close();
				return true;
			} else {
				System.out.println("No Data Found!!!!");
				con.close();
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
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
