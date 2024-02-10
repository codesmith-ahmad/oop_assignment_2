package com.algonquin.cst8288.assignment2.database;

import java.sql.Connection;

public class DBConnection {
	
	private static Connection connection = null;
        private String serverUrl = "jdbc:mysql://localhost:3306/bookvault";
	private String userString = "ahmad";
	private String passwordString = "123";
	private String driverString = "com.mysql.cj.jdbc.Driver";

    public static DBConnection getInstance() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
	
}
