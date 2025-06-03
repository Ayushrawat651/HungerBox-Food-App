package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.Menu;
import com.connection.DBconnection;

public class AddMenuItem {
	public boolean addMenuItem(Menu dish) {
		DBconnection dbcon = new DBconnection();

		Connection con = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;

		String query = "INSERT INTO MENU VALUES(DEFAULT,?,?,?,?,?,?,?)";
		
		try {
			con = dbcon.dbConnect();
			if (con == null) {
				throw new SQLException("Database connection is not available.");
			}

			pstat = con.prepareStatement(query);
			
			pstat.setString(1, dish.getDishName());
			pstat.setString(2, dish.getDishDescription());
			pstat.setBoolean(3, dish.getVeg());
			pstat.setString(4, dish.getImgUrl());
			pstat.setInt(5, dish.getPrice());
			pstat.setInt(6, dish.getQuantity());
			pstat.setBoolean(7, dish.getStatus());
			
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
