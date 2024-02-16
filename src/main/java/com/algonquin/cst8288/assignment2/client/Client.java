package com.algonquin.cst8288.assignment2.client;

import com.algonquin.cst8288.assignment2.database.*;
import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.factory.*;
import com.algonquin.cst8288.assignment2.logger.*;
import java.util.HashMap;
import java.util.Map;

public class Client {
    
    public static LMSLogger l = LMSLogger.getInstance();
	
    public static void main(String[] args) {
        
        l.log("Application starting...");
        
        // step 1 - 3 in lab instructions
        var events = createEvents();
        
        // step 5 in lab instructions: connect to database
        DBConnection.getInstance().getConnection();
        
        initializeDatabase("bookvault");
        
        // Create table 'events'
        String sql = """
                     CREATE TABLE IF NOT EXISTS events (
                        event_id INT PRIMARY KEY AUTO_INCREMENT,
                        event_name VARCHAR(255) NOT NULL,
                        event_description TEXT NOT NULL,
                        event_activities TEXT NOT NULL,
                        admission_fees DECIMAL(4, 2) NOT NULL
                     );
                     """;
        DBOperations.executeUpdate(sql);
        l.log("Table 'events' created");
        
        populateTable("events",events);
        
        // step 5 and 6 in lab instruction
//        operateDatabase(); // loop; all ressources closed within
        
        l.log("END OF PROGRAM");
    }
    
    private static HashMap<String,Event> createEvents(){
        // Create two factories
        EventCreator academicEventCreator = new AcademicEventCreator();
        EventCreator publicEventCreator = new PublicEventCreator();
        l.log("Created two factories");
        
        // This one will hold events created by factories above
        HashMap<String, Event> events = new HashMap<>();
        
        // Each factory can build two different types of Events, upon request
        events.put("workshop", academicEventCreator.createEvent("workshop"));
        events.put("book",     academicEventCreator.createEvent("booklaunch"));
        events.put("story",      publicEventCreator.createEvent("story"));
        events.put("movie",      publicEventCreator.createEvent("movie"));
        l.log("Events created");
        
        for (String i : events.keySet()){
            System.out.println(
                    "\n~~ " + i + " ~~\n"
                    + events.get(i)
            );
        }
        
        return events;
    }
    
    private static void initializeDatabase(String schema) {
        DBOperations.executeUpdate("DROP DATABASE IF EXISTS " + schema);
        DBOperations.executeUpdate("CREATE DATABASE " + schema);
        DBOperations.executeUpdate("USE " + schema);
        l.log("Schema " + schema + " initialized");
    }
    
    private static void populateTable(String table, Map m){
        switch (table){
            case "events" -> {populateEvents(m);}
            default -> {l.log(LogLevel.ERROR, "No such table");}
        }
    }
    
    private static void populateEvents(Map<String,Event> m) {
        String sql = "";
        for (Event e : m.values()){
            sql = String.format("""
                                 INSERT INTO events
                                 (event_name, event_description, event_activities, admission_fees) 
                                 VALUES ('%s','%s','%s',%f);
                                 """,
                    e.getEventName(),
                    e.getEventDescription(),
                    e.getEventActivities(),
                    e.getAdmissionFees()
                    );
            DBOperations.executeUpdate(sql); // CANNOT EXECUTE ALL AT ONCE!
        }
    }

    private static void operateDatabase() {
        
        l.log("Entered database operations loop");
        
        String query;
        int isSELECT;
        
        while(true) {
            query = DBOperations.takeQuery();
            if (query.equals("exit")){
                l.log("User input: " + query);
                break;
            }
                
            isSELECT = DBOperations.parse(query);
            
            switch (isSELECT) {
                case 0 -> {
                    DBOperations.executeUpdate(query);
                    l.log("Executed update query: " + query);
                }
                case 1 -> {
                    DBOperations.executeQuery(query);
                    l.log("Executed select query: " + query);
                }
                default -> throw new AssertionError();
            }
        }
    }
}
