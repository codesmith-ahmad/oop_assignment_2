package com.algonquin.cst8288.assignment2.client;

import com.algonquin.cst8288.assignment2.database.*;
import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.factory.*;
import com.algonquin.cst8288.assignment2.logger.*;
import java.util.HashMap;

public class Client {
	
    public static void main(String[] args) {
        
        HashMap<String, Event> events = new HashMap<String, Event>();
        
        EventCreator academicEventCreator = new AcademicEventCreator();
        EventCreator publicEventCreator = new PublicEventCreator();
        
        events.put("workshop", academicEventCreator.createEvent("workshop"));
        events.put("book",     academicEventCreator.createEvent("booklaunch"));
        events.put("story",      publicEventCreator.createEvent("story"));
        events.put("movie",      publicEventCreator.createEvent("movie"));

        // Database operations
        DBConnection dbConnection = DBConnection.getInstance();
        DBOperations.createEvent(academicEvent);
        DBOperations.createEvent(publicEvent);

        // Logging
        LMSLogger logger = LMSLogger.getInstance();
        try {
            // Simulating an exception
            throw new NullPointerException("Simulated NullPointerException");
        } catch (NullPointerException e) {
            logger.log(LogLevel.ERROR, "Exception caught: " + e.getMessage());
        }
    }
}
