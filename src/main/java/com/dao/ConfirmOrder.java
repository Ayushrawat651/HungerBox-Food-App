package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.bean.Orders;
import com.connection.DBconnection;

public class ConfirmOrder {
	public boolean confirmOrder(Orders order) {
		Scanner sc = new Scanner(System.in);
		DBconnection dbcon = new DBconnection();

		Connection con = null;
		PreparedStatement pstat = null;

//		String query = "INSERT INTO ORDERS(customerId,menuId,status) VALUES(?,?,?)";
		String query = "INSERT INTO ORDERS(customerId,dishes,status) VALUES(?,?,?)";

		try {

			con = dbcon.dbConnect();
			if (con == null) {
				throw new SQLException("Database connection is not available.");
			}
			

			 pstat = con.prepareStatement(query);

			 pstat.setInt(1, order.getCustomerId());
			 pstat.setString(2, order.getDishes());
			 pstat.setInt(3, order.getStatus());

			int status = pstat.executeUpdate();

			if (status == 1) {
				System.out.println("Order Confirm!!!");
				return true;
			} else {
				System.out.println("Error in Ordering!!!");
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
