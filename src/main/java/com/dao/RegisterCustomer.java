package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.bean.Customer;
import com.connection.DBconnection;

public class RegisterCustomer {
        public boolean registerCustomer(Customer customer) {
                Scanner sc = new Scanner(System.in);
                DBconnection dbcon = new DBconnection();
                
                Connection con = null;
                PreparedStatement pstat = null;

                String query = "INSERT INTO Customer VALUES(DEFAULT,?,?,?,?)";

                try {
                		con = dbcon.dbConnect();

                        if (con == null) {
                            throw new SQLException("Database connection is not available.");
                        }

                        pstat = con.prepareStatement(query);

                        pstat.setString(1, customer.getCustomerName());
                        pstat.setString(2, customer.getCustomerEmail());
                        pstat.setString(3, customer.getCustomerPhoneNo());
                        pstat.setString(4, customer.getCustomerPassword());

                        int status = pstat.executeUpdate();

                        if(status > 0) {
                                System.out.println("Customer Registration!!!");
                                con.close();
                                return true;
                        }
                        else {
                                System.out.println("Error in Customer Registration!!!");
                                con.close();
                                return false;
                        }
                } catch (SQLException e) {
                        e.printStackTrace();
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
                return false;
        }
}