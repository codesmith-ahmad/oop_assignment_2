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
        operateDatabase(c); // loop; all ressources closed within
        
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
        
        String query = "exit"; //remove
        int isSELECT;
        
        do {
            query = takeQuery();
            isSELECT = parse(query);
            
            switch (isSELECT) {
                case 0 -> {executeUpdate(query, c);}
                case 1 -> {executeQuery(query, c);}
                default -> throw new AssertionError();
            }
            
        } while (!query.equals("exit"));
        
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
    
    // Helper method
    
    private static String takeQuery() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nSQL> ");
        String input = scanner.nextLine();
        return input;
    }
    
    private static int parse(String query) {
        String[] words = query.trim().split("\\s+"); // Split the query into words

        // Check if the first word (if any) is "SELECT" (case-insensitive)
        if (words.length > 0 && "SELECT".equalsIgnoreCase(words[0])) {
            return 1; // Return 1 if the first word is "SELECT"
        } else {
            return 0; // Return 0 otherwise
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

    private static void executeUpdate(String query, Connection c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void executeQuery(String query, Connection c) {
        try ( // try-with-ressources for auto-closing
                Statement s = c.createStatement(); // NEXT TIME REPLACE WITH PREPAREDSTATEMENT
                ResultSet r = s.executeQuery(query);
                )
            {
                ResultSetMetaData m = r.getMetaData();
            
                while(r.next()){
                    for (int i = 1; i <= m.getColumnCount() ; i++) {
                        System.out.println(
                                m.getColumnName(i) + ": " +
                                r.getObject(i));
                    }
                }
            } catch (SQLException ex) {
//            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception e) {
                //Logger
            }
    }
}
