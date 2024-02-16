/**
 * Singleton class representing a database connection using JDBC.
 * Manages a single instance of the database connection.
 */
package com.algonquin.cst8288.assignment2.database;

import com.algonquin.cst8288.assignment2.logger.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

public class DBConnection {
	
	// Singleton instance
	private static DBConnection dbc = null;
	
	// Actual JDBC connection
    private static Connection connection = null;
    
    // Database connection properties
    private String serverUrl = "jdbc:mysql://localhost:3306/bookvault";
    private String userString = "CST8288";
    private String passwordString = "root";
    private String driverString = "com.mysql.cj.jdbc.Driver";
    
    // Logger instance for logging database connection information
    public static LMSLogger l = LMSLogger.getInstance();

    // Private constructor to prevent direct instantiation
    private DBConnection(){
        try {
            // Establishing the database connection
            DBConnection.connection = DriverManager.getConnection(serverUrl, userString, passwordString);
            l.log("Connected to database (" + connection + ")");
        }
        catch (SQLException e) {
            // Log an error message if connection fails
            l.log(LogLevel.ERROR, "CONNECTION FAILED: " + e.getMessage());
        }
    };
    
    /**
     * Static method that returns a reference to the single instance of the database connection.
     * Initializes the instance only once if not initialized before.
     *
     * @return The singleton instance of DBConnection.
     */
    public static DBConnection getInstance() {
        if (connection == null) {
            dbc = new DBConnection();
        }
        return dbc;
    }
    
    /**
     * Gets the current JDBC connection.
     *
     * @return The JDBC connection.
     */
    public Connection getConnection(){
        return connection;
    }
    
    /**
     * Retrieves the properties of the database connection.
     *
     * @return A HashMap containing database connection properties (url, user, pass, driver).
     */
    public HashMap<String, String> getProperties() {
        var hm = new HashMap<String, String>();
        hm.put("url", serverUrl);
        hm.put("user", userString);
        hm.put("pass", passwordString);
        hm.put("driver", driverString);
        return hm;
    }
}
