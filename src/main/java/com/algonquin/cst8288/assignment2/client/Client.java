package com.algonquin.cst8288.assignment2.client;

import com.algonquin.cst8288.assignment2.database.*;
import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.factory.*;
import com.algonquin.cst8288.assignment2.logger.*;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Scanner;

public class Client {
	
    public static void main(String[] args) {
        
        // Create two factories
        EventCreator academicEventCreator = new AcademicEventCreator();
        EventCreator publicEventCreator = new PublicEventCreator();
        
        // This one will hold events created by factories above
        HashMap<String, Event> events = new HashMap<>();
        
        // Each factory can build two different types of Events, upon request
        events.put("workshop", academicEventCreator.createEvent("workshop"));
        events.put("book",     academicEventCreator.createEvent("booklaunch"));
        events.put("story",      publicEventCreator.createEvent("story"));
        events.put("movie",      publicEventCreator.createEvent("movie"));
        
        begin();
        
        for (String i : events.keySet()){
            System.out.println(
                    "\n~~ " + i + " ~~\n"
                    + events.get(i)
            );
        }
        
        // step 5
        connectToDatabase();
        
        // step 6
        operateDatabase();
        
        // step 7
        LMSLogger();

        // Database operations
        DBConnection dbConnection = DBConnection.getInstance();
        DBOperations.createEvent(events.get("workshop"));
        DBOperations.createEvent(events.get("book"));
        DBOperations.createEvent(events.get("story"));
        DBOperations.createEvent(events.get("movie"));

        // Logging
        LMSLogger logger = LMSLogger.getInstance();
        try {
            // Simulating an exception
            throw new NullPointerException("Simulated NullPointerException");
        } catch (NullPointerException e) {
            logger.log(LogLevel.ERROR, "Exception caught: " + e.getMessage());
        }
        
        end();
    }
    
        /**
     * Prints a message indicating the beginning of the program.
     */
    static void begin(){
        System.out.println("""
                           
                           
                           
                           BEGIN *******************************
                           """);
    }
    
    /**
     * Prints a message indicating the end of the program.
     */
    static void end(){
        System.out.println("""
                           
                           OVER ******************************************
                           
                           
                           
                           
                           """);
    }
    
    /**
     * Pauses the program until the user presses Enter.
     */
    private static void pause(){
        System.out.print("\n...");
        (new Scanner(System.in)).nextLine();
    }

    private static void connectToDatabase() {
        // fetch connection info
        var prop = new HashMap<String,String>();
        DBConnection dbc = DBConnection.getInstance();
        Connection c = dbc.getConnection();
    }

    private static void operateDatabase() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void LMSLogger() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
