package com.algonquin.cst8288.assignment2.client;

public class Client {
	
    public static void main(String[] args) {
        // Creating Academic Event
        EventCreator academicEventCreator = new AcademicEventCreator();
        Event academicEvent = academicEventCreator.createEvent();
        academicEvent.displayInfo();
        System.out.println("Admission Fee: $" + academicEvent.calculateAdmissionFee());

        // Creating Public Event
        EventCreator publicEventCreator = new PublicEventCreator();
        Event publicEvent = publicEventCreator.createEvent();
        publicEvent.displayInfo();
        System.out.println("Admission Fee: $" + publicEvent.calculateAdmissionFee());

        // Database operations
        DBConnection dbConnection = DBConnection.getInstance();
        DBOperations dbOperations = new DBOperations();
        dbOperations.saveEvent(academicEvent);
        dbOperations.saveEvent(publicEvent);

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
