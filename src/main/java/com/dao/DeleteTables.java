package com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.connection.DBconnection;

public class DeleteTables {
        public void deleteTables() {
                DBconnection dbcon = null;
                Connection con = null;
                Statement stat = null;

                String query4 = "DROP TABLE Customer";
                String query3 = "DROP TABLE Admin";
                String query2 = "DROP TABLE Menu";
                String query1 = "DROP TABLE Orders";

                try {
                	dbcon = new DBconnection();
                    con = dbcon.dbConnect();
                        stat = con.createStatement();

                        stat.execute(query1);
                        stat.execute(query2);
                        stat.execute(query3);
                        stat.execute(query4);
                        
                        System.out.println("Tables Deleted!!!");

                        stat.close();
                        con.close();
                } catch (SQLException e) {
                        e.printStackTrace();
                } 
                finally {
                	try {
                		if(stat != null) stat.close();
                        if(con != null) con.close();
                	}
                	catch(SQLException e) {
                		e.printStackTrace();
                	}
                }

               
        }
}
