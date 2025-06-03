package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.bean.Menu;
import com.connection.DBconnection;

public class GetMenuItems {
	public ArrayList<Menu> getMenuItems(String type) {
		String query = "";
		
		DBconnection dbcon = new DBconnection();
		
		Connection con = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		if (type == null || type.equals("all")) {
			query = "SELECT menuId,dishName,dishDescription,veg,imgUrl,price,quantity,status FROM Menu";
		}
		else if(type.equals("veg")) {
			query = "SELECT menuId,dishName,dishDescription,veg,imgUrl,price,quantity,status FROM Menu WHERE veg = TRUE";
		}
		else if(type.equals("nonveg")) {
			query = "SELECT menuId,dishName,dishDescription,veg,imgUrl,price,quantity,status FROM Menu WHERE veg = FALSE";
		}
		else {
			query = "SELECT menuId,dishName,dishDescription,veg,imgUrl,price,quantity,status FROM Menu";//handle this
		}
		try {
			con = dbcon.dbConnect();
			if (con == null) {
				throw new SQLException("Database connection is not available.");
			}

			pstat = con.prepareStatement(query);

			rs = pstat.executeQuery();

			if (rs.next()) {

				ArrayList<Menu> menu = new ArrayList<>();

				while (rs.next()) {
					menu.add(new Menu(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getString(5),
							rs.getInt(6), rs.getInt(7), rs.getBoolean(8)));
				}
				
				con.close();
				return menu;
			} else {
				System.out.println("No Data Found!!!!");
				con.close();
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		finally {
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