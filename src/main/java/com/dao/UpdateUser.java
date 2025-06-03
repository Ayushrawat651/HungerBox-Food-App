package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.Customer;
import com.connection.DBconnection;
import com.utility.Encrypt;

public class UpdateUser {
	public boolean updateUser(Customer user, String pass) {
		String query = "";
		if (user.getCustomerPassword() != null) {
			query = "UPDATE Customer SET customerName = ?,customerEmail = ?,customerPhoneNo = ?,customerPassword = ? WHERE customerId = ? AND customerPassword = ?";
		} else {
			query = "UPDATE Customer SET customerName = ?,customerEmail = ?,customerPhoneNo = ? WHERE customerId = ? AND customerPassword = ?";
		}

		DBconnection dbcon = new DBconnection();

		Connection con = null;
		PreparedStatement pstat = null;

		try {
			con = dbcon.dbConnect();
			if (con == null) {
				throw new SQLException("Database connection is not available.");
			}

			pstat = con.prepareStatement(query);

			if (user.getCustomerPassword() != null) {
				pstat.setString(1, user.getCustomerName());
				pstat.setString(2, user.getCustomerEmail());
				pstat.setString(3, user.getCustomerPhoneNo());
				pstat.setString(4, new Encrypt().encryptPassword(user.getCustomerPassword()));
				pstat.setInt(5, user.getCustomerId());
				pstat.setString(6, new Encrypt().encryptPassword(pass));
			} else {
				pstat.setString(1, user.getCustomerName());
				pstat.setString(2, user.getCustomerEmail());
				pstat.setString(3, user.getCustomerPhoneNo());
				pstat.setInt(4, user.getCustomerId());
				pstat.setString(5, new Encrypt().encryptPassword(pass));
			}

			int status = pstat.executeUpdate();

			if (status > 0) {
				System.out.println("User Details Updated Succesfully.");
				pstat.close();
				con.close();
				return true;
			} else {
				System.out.println("User Details Update Unsuccesfully.");
				pstat.close();
				con.close();
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
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

		return false;
	}
}
