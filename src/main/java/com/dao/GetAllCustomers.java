package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Customer;
import com.connection.DBconnection;

public class GetAllCustomers {
	public ArrayList<Customer> getAllCustomers() {

		DBconnection dbcon = new DBconnection();

		Connection con = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;

		String query = "SELECT customerId,customerName,customerEmail,customerPhoneNo FROM CUSTOMER";

		try {
			con = dbcon.dbConnect();
			if (con == null) {
				throw new SQLException("Database connection is not available.");
			}

			pstat = con.prepareStatement(query);
			rs = pstat.executeQuery();

			if (rs.next()) {
				
				ArrayList<Customer> customers = new ArrayList<>();

				do {
					//System.out.println("customer-added!!!!");
					customers.add(new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),"#"));
					
				}while (rs.next());

				con.close();
				return customers;
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
