package com.algonquin.cst8288.assignment2.database;

import java.sql.Connection;

/*
DBConnection is the DriverManager
Connection is the actual connection via which queries will be sent
*/
public class DBConnection {
	
	private static Connection connection = null;
        private String serverUrl = "jdbc:mysql://localhost:3306/bookvault";
	private String userString = "CST8288";
	private String passwordString = "root";
	private String driverString = "com.mysql.cj.jdbc.Driver";

        private DBConnection(){};
        
        /* 
         * Static method that returns reference to single instance.
         * Initializes it only once, if not initialized before.
         */
        public static DBConnection getInstance() {
        if (connection == null) {
            connection = new DBConnection();
        }
        return connection;
    }
	
}
