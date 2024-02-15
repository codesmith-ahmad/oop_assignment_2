package com.algonquin.cst8288.assignment2.client;

import com.algonquin.cst8288.assignment2.database.*;
import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.factory.*;
import com.algonquin.cst8288.assignment2.logger.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
	
    public static void main(String[] args) {
        
        begin();
        
        // step 1 - 3
        createEvents();
        
        // step 5
        Connection c = connectToDatabase();
        
        // step 6
        operateDatabase(c); // all ressources closed within
        
        // step 7
        LMSLogger(); //TODO
        
        end();
    }
    
    private static void createEvents(){
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
        
        for (String i : events.keySet()){
            System.out.println(
                    "\n~~ " + i + " ~~\n"
                    + events.get(i)
            );
        }
    }

    private static Connection connectToDatabase() {
        DBConnection dbc = DBConnection.getInstance();
        return dbc.getConnection();
    }

    private static void operateDatabase(Connection c) {
        try ( // try-with-ressources for auto-closing
            Statement s = c.createStatement(); // NEXT TIME REPLACE WITH PREPAREDSTATEMENT
            ResultSet r = s.executeQuery("SELECT * FROM events");
            )
        {
            ResultSetMetaData m = r.getMetaData();
            
            while(r.next()){
                for (int i = 1; i <= m.getColumnCount() ; i++) {
                    System.out.println("\n"+
                            m.getColumnName(i) + ": " +
                            r.getObject(i));
                }
            }
        } catch (SQLException ex) {
//            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void LMSLogger() {
        // Logging
        LMSLogger logger = LMSLogger.getInstance();
        try {
            // Simulating an exception
            throw new NullPointerException("Simulated NullPointerException");
        } catch (NullPointerException e) {
            logger.log(LogLevel.ERROR, "Exception caught: " + e.getMessage());
        }
    }
    
    // Formatting methods
    
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
