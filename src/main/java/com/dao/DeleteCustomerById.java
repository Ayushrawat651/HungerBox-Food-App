package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Menu;
import com.connection.DBconnection;

public class DeleteCustomerById {
	public boolean deleteCustomer(int id) {
		DBconnection dbcon = new DBconnection();

		Connection con = null;
		PreparedStatement pstat = null;
		
		String query = "DELETE FROM CUSTOMER WHERE customerId = ?";

		try {
			con = dbcon.dbConnect();
			if (con == null) {
				throw new SQLException("Database connection is not available.");
			}

			pstat = con.prepareStatement(query);
			pstat.setInt(1, id);
			
			int status = pstat.executeUpdate();

			if (status > 0) {
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
