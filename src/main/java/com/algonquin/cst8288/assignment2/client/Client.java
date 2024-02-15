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
        
        // step 1 - 3
        createEvents();
        
        // step 5
        connectToDatabase();
        
        // step 6
        operateDatabase(connection); // loop; all ressources closed within
        
        log("END OF PROGRAM");
    }
    
    private static void createEvents(){
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
    }

    private static Connection connectToDatabase() {
        DBConnection dbc = DBConnection.getInstance();
        Client.connection = dbc.getConnection();
        log("Database connected");
        return dbc.getConnection();
    }

    private static void operateDatabase(Connection c) {
        
        log("Entered database operations loop");
        
        String query;
        int isSELECT;
        
        while(true) {
            query = DBOperations.takeQuery();   if (query.equals("exit")){break;}
            isSELECT = DBOperations.parse(query);
            
            switch (isSELECT) {
                case 0 -> {
                    DBOperations.executeUpdate(query, c);
                    log("Executed update query: " + query);
                }
                case 1 -> {
                    DBOperations.executeQuery(query, c);
                    log("Executed select query: " + query);
                }
                default -> throw new AssertionError();
            }
        }
        
    }
    
    /**
     * Pauses the program until the user presses Enter.
     */
    private static void pause(){
        System.out.print("\n...");
        (new Scanner(System.in)).nextLine();
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
