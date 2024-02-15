package com.algonquin.cst8288.assignment2.client;

import com.algonquin.cst8288.assignment2.database.*;
import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.factory.*;
import com.algonquin.cst8288.assignment2.logger.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Scanner;

public class Client {
    
    static LMSLogger logger = LMSLogger.getInstance();
    static Connection connection;
	
    public static void main(String[] args) {
        
        log("Application starting...");
        
        // step 1 - 3 in lab instructions
        var events = createEvents();
        
        populateDatabase(events);
        
        // step 5 and 6 in lab instruction
        operateDatabase(); // loop; all ressources closed within
        
        log("END OF PROGRAM");
    }
    
    private static HashMap<String,Event> createEvents(){
        // Create two factories
        EventCreator academicEventCreator = new AcademicEventCreator();
        EventCreator publicEventCreator = new PublicEventCreator();
        log("Created two factories");
        
        // This one will hold events created by factories above
        HashMap<String, Event> events = new HashMap<>();
        
        // Each factory can build two different types of Events, upon request
        events.put("workshop", academicEventCreator.createEvent("workshop"));
        events.put("book",     academicEventCreator.createEvent("booklaunch"));
        events.put("story",      publicEventCreator.createEvent("story"));
        events.put("movie",      publicEventCreator.createEvent("movie"));
        log("Events created");
        
        for (String i : events.keySet()){
            System.out.println(
                    "\n~~ " + i + " ~~\n"
                    + events.get(i)
            );
        }
        
        return events;
    }

    private static Connection connectToDatabase() {
        return DBConnection.getInstance().getConnection();       
    }
    
    private static void populateDatabase(HashMap<String,Event> map) {
        String initialQuery = """
                              DROP DATABASE IF EXISTS bookvault;
                              
                              CREATE DATABASE bookvault;
                              
                              USE bookvault;
                              
                              CREATE TABLE IF NOT EXISTS events (
                                  event_id INT PRIMARY KEY AUTO_INCREMENT,
                                  event_name VARCHAR(255) NOT NULL,
                                  event_description TEXT,
                                  event_activities TEXT,
                                  admission_fees DECIMAL(4, 2) NOT NULL
                                  
                              );""";
        
    }

    private static void operateDatabase() {
        
        log("Entered database operations loop");
        
        String query;
        int isSELECT;
        
        while(true) {
            Connection c = connectToDatabase(); // Step 5 in lab instuctions
            DBOperations.setConnection(c);
            query = DBOperations.takeQuery();
                if (query.equals("exit")){break;}
            isSELECT = DBOperations.parse(query);
            
            switch (isSELECT) {
                case 0 -> {
                    DBOperations.executeUpdate(query);
                    log("Executed update query: " + query);
                }
                case 1 -> {
                    DBOperations.executeQuery(query);
                    log("Executed select query: " + query);
                }
                default -> throw new AssertionError();
            }
        }
        
    }
    
    // helper method
    /**
     * Shorthand for 
     * @param message logger.log(LogLevel.INFO, message);
     */
    private static void log(String message){
        logger.log(LogLevel.INFO, "\n" + message);
    }
}
