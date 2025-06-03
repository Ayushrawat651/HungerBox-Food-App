package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Orders;
import com.connection.DBconnection;

public class GetHistory {
	public ArrayList<Orders> getHistory(int id) {

		DBconnection dbcon = new DBconnection();

		Connection con = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;

		String query = "SELECT customerId,dishes,status FROM ORDERS WHERE customerId = ?";

		try {
			con = dbcon.dbConnect();
			if (con == null) {
				throw new SQLException("Database connection is not available.");
			}

			pstat = con.prepareStatement(query);
			pstat.setInt(1, id);
			rs = pstat.executeQuery();

			if (rs.next()) {

//				HashMap<String,Integer> dishes = new HashMap<>();
				ArrayList<Orders> orders = new ArrayList<>();

				do {
					orders.add(new Orders(0, rs.getInt(1), rs.getString(2), rs.getInt(3)));
				}while (rs.next());

				con.close();
				return orders;
			} else {
				System.out.println("No Data Found!!!!");
				con.close();
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
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

	public ArrayList<Orders> getHistory() {

		DBconnection dbcon = new DBconnection();

		Connection con = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;

		String query = "SELECT orderId,customerId,dishes,status FROM ORDERS";

		try {
			con = dbcon.dbConnect();
			if (con == null) {
				throw new SQLException("Database connection is not available.");
			}

			pstat = con.prepareStatement(query);
			rs = pstat.executeQuery();

			if (rs.next()) {

//				HashMap<String,Integer> dishes = new HashMap<>();
				ArrayList<Orders> orders = new ArrayList<>();

				while (rs.next()) {
					orders.add(new Orders(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4)));
				}

				con.close();
				return orders;
			} else {
				System.out.println("No Data Found!!!!");
				con.close();
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
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
