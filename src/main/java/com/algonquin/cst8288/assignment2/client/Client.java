package com.algonquin.cst8288.assignment2.client;

import com.algonquin.cst8288.assignment2.database.*;
import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.factory.*;
import com.algonquin.cst8288.assignment2.logger.*;
import java.util.HashMap;
import java.util.Scanner;

public class Client {
	
    public static void main(String[] args) {
        
        HashMap<String, Event> events = new HashMap<>();
        
        EventCreator academicEventCreator = new AcademicEventCreator();
        EventCreator publicEventCreator = new PublicEventCreator();
        
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
}
