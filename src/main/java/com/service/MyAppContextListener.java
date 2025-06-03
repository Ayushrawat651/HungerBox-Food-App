package com.service;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.DriverManager;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Timer;

public class MyAppContextListener implements ServletContextListener {

    // Assuming you have a Timer thread that needs to be stopped
    private Timer myTimer;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Code to run when the web application starts
        System.out.println("Application started");

        // Initialize your timer or any other resources here
        myTimer = new Timer();
        // Add any scheduled tasks to the timer, if necessary
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Application is stopping");

        // Step 1: Cancel and purge any Timer threads to prevent memory leaks
        if (myTimer != null) {
            myTimer.cancel();
            myTimer.purge();
        }

        // Step 2: Deregister all JDBC drivers to prevent memory leaks
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            try {
                DriverManager.deregisterDriver(driver);
                System.out.println("Deregistered JDBC driver: " + driver);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Step 3: Clear any custom ThreadLocal variables if applicable
        clearThreadLocalVariables();

        System.out.println("Application stopped");
    }

    // Helper method to clear ThreadLocal variables
    private void clearThreadLocalVariables() {
        // If you have any ThreadLocal variables, explicitly remove them here
        // Example:
        // myThreadLocal.remove();
        System.out.println("Cleared ThreadLocal variables");
    }
}