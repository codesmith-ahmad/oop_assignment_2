package com.algonquin.cst8288.assignment2.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

/*
DBConnection is the DriverManager
Connection is the actual connection via which queries will be sent

ADD TO NOTES:
    Singleton class recipe:
        - $ instance = null
        -   properties
        -   Constructor
        + $ getInstance {return new instance if null, same if not}
        +   getProperties
*/
public class DBConnection {
	
	private static DBConnection dbc = null;
        private static Connection connection = null;
        private String serverUrl = "jdbc:mysql://localhost:3306/bookvault";
	private String userString = "CST8288";
	private String passwordString = "root";
	private String driverString = "com.mysql.cj.jdbc.Driver";

        private DBConnection(){
            try {this.connection = DriverManager.getConnection(serverUrl, userString, passwordString);}
            catch (SQLException e) {System.err.println("EXCEPTION AT database/DBCOnnection/DBConnection()");}
        };
        
        /* 
         * Static method that returns reference to single instance.
         * Initializes it only once, if not initialized before.
         */
        public static DBConnection getInstance() {
            if (connection == null) {
                dbc = new DBConnection();
            }
            return dbc;
        }
        
        public Connection getConnection(){
            return connection;
        }
        
        public HashMap<String,String> getProperties() {
            var hm = new HashMap<String,String>();
            hm.put("url", serverUrl);
            hm.put("user", userString);
            hm.put("pass", passwordString);
            hm.put("driver", driverString);
            return hm;
        }
}
