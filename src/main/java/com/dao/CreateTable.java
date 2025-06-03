package com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.connection.DBconnection;

public class CreateTable {
        public void createTable() {
                DBconnection dbcon = null;
                Connection con = null;

                String query1 = "CREATE TABLE Customer(customerId INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY(Start with 1001, Increment by 1),customerName VARCHAR(20) NOT NULL,customerEmail VARCHAR(50),customerPhoneNo VARCHAR(10),customerPassword VARCHAR(2000) NOT NULL)";
                String query2 = "create table Admin(adminId INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY(Start with 2001, Increment by 1),adminName VARCHAR(20) NOT NULL,adminEmail VARCHAR(50),adminPhoneNo VARCHAR(10),adminPassword VARCHAR(20) NOT NULL)";
                String query3 = "CREATE TABLE Menu (menuId INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY(Start with 3001, Increment by 1),dishName VARCHAR(20) NOT NULL,dishDescription VARCHAR(100),veg BOOLEAN,imgUrl VARCHAR(3000),price INTEGER ,quantity INTEGER DEFAULT 0,status BOOLEAN DEFAULT FALSE)";
                String query4 = "CREATE TABLE Orders (orderId INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY(Start with 4001, Increment by 1),customerId INTEGER NOT NULL,dishes VARCHAR(200) NOT NULL,status INTEGER)";

                Statement stat = null;
                try {
                	dbcon = new DBconnection();
                    con = dbcon.dbConnect();
                        stat = con.createStatement();

                        stat.execute(query1);
                        stat.execute(query2);
                        stat.execute(query3);
                        stat.execute(query4);

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

                System.out.println("Tables Created!!!");
        }
}