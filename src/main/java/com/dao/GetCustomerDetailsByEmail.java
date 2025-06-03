package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.bean.Customer;
import com.connection.DBconnection;

public class GetCustomerDetailsByEmail {
        public Customer getCustomerDetailsByEmail(String email) {
                Scanner sc = new Scanner(System.in);

                DBconnection dbcon = new DBconnection();
                Connection con = null;
                Customer customer = new Customer();
                PreparedStatement pstat = null;
                ResultSet rs = null;

                String query = "SELECT * FROM Customer WHERE customerEmail = ?";

                try {
                     	con = dbcon.dbConnect();
                        pstat = con.prepareStatement(query);

                        pstat.setString(1, email);

                        rs = pstat.executeQuery();

                        while(rs.next()) {
                        	customer.setCustomerId(rs.getInt(1));
                        	customer.setCustomerName(rs.getString(2));
                        	customer.setCustomerEmail(rs.getString(3));
                        	customer.setCustomerPhoneNo(rs.getString(4));
                        	customer.setCustomerPassword("");
                        }

                        pstat.close();
                        rs.close();
                        con.close();
                        return customer;
                } catch (SQLException e) {
                        e.printStackTrace();
                }
                finally {
                	try {
                		if(pstat != null) pstat.close();
                		if(rs != null) rs.close();
                        if(con != null) con.close();
                	}
                	catch(SQLException e) {
                		e.printStackTrace();
                	}
                }
                return null;
        }
}