/**
 * Represents a Workshop Event.
 * Extends the Event interface and provides implementation for event-specific details.
 */
package com.algonquin.cst8288.assignment2.event;

import com.algonquin.cst8288.assignment2.constants.Constants;

public class WorkshopEvent implements Event {

    protected String eventName = "workshop";
    protected String eventDescription = ""; // Escape NULL
    protected String eventActivities = "";
    protected double admissionFees;

    /**
     * Default constructor.
     * Initializes admission fees based on constants.
     */
    public WorkshopEvent() {
        this.admissionFees = calculateAdmissionFees();
    }

    /**
     * @return the eventName
     */
    @Override
    public String getEventName() {
        return eventName;
    }

    /**
     * @param eventName the eventName to set
     */
    @Override
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * @return the eventDescription
     */
    @Override
    public String getEventDescription() {
        return eventDescription;
    }

    /**
     * @param eventDescription the eventDescription to set
     */
    @Override
    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    /**
     * @return the eventActivities
     */
    @Override
    public String getEventActivities() {
        return eventActivities;
    }

    /**
     * @param eventActivities the eventActivities to set
     */
    @Override
    public void setEventActivities(String eventActivities) {
        this.eventActivities = eventActivities;
    }

    /**
     * @return the admissionFees
     */
    @Override
    public double getAdmissionFees() {
        return admissionFees;
    }

    /**
     * @param admissionFees the admissionFees to set
     */
    @Override
    public void setAdmissionFees(double admissionFees) {
        this.admissionFees = admissionFees;
    }

    /**
     * Calculates admission fees based on the duration and rate constants for Workshop Event.
     *
     * @return The calculated admission fees.
     */
    @Override
    public double calculateAdmissionFees() {
        return Constants.WORKSHOP_DURATION * Constants.WORKSHOP_RATE;
    }

    /**
     * Generates a string representation of the Workshop Event.
     *
     * @return A string representation of the Workshop Event.
     */
    @Override
    public String toString() {
        return "WorkshopEvent{" +
                "eventName='" + eventName + '\'' +
                ", eventDescription='" + eventDescription + '\'' +
                ", eventActivities='" + eventActivities + '\'' +
                ", admissionFees=" + admissionFees +
                '}';
    }
}
