package com.algonquin.cst8288.assignment2.client;

import com.algonquin.cst8288.assignment2.database.*;
import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.factory.*;
import com.algonquin.cst8288.assignment2.logger.*;

public class Client {
	
    public static void main(String[] args) {
        
        Event[] events = {
            (new AcademicEventCreator()).createEvent("workshop"),
            (new AcademicEventCreator()).createEvent("booklaunch"),
            (new PublicEventCreator()).createEvent("story"),
            (new PublicEventCreator()).createEvent("movie")
        }
        
        // Creating Academic Event
        Event academicEvent = (new AcademicEventCreator()).createEvent();
        academicEvent.displayInfo();
        System.out.println("Admission Fee: $" + academicEvent.getAdmissionFees());

        // Creating Public Event
        Event publicEvent = (new PublicEventCreator()).createEvent();
        publicEvent.displayInfo();
        System.out.println("Admission Fee: $" + publicEvent.getAdmissionFees());

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
