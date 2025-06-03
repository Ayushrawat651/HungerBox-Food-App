package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
        public Connection dbConnect() {
                //System.setProperty("derby.system.home", "D:\\Users\\2730793\\MyDB;create=true");
                String dbUrl="jdbc:derby:C:\\Users\\Priya\\MyDB;create=true";
                Connection con = null;
                try {
                        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                        con=DriverManager.getConnection(dbUrl);
                } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                }
                return con;
        }
}