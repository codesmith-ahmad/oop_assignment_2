/**
 * Represents a book launch event with specific properties and behavior.
 */
package com.algonquin.cst8288.assignment2.event;

import com.algonquin.cst8288.assignment2.constants.Constants;

public class BookLaunchEvent implements Event {
    
    protected String eventName = "book launch";
    protected String eventDescription = "";
    protected String eventActivities = "";
    protected double admissionFees;
    
    /**
     * Constructs a BookLaunchEvent object with calculated admission fees.
     */
    public BookLaunchEvent() {
        this.admissionFees = calculateAdmissionFees();
    }
 
    /**
     * Gets the event name.
     *
     * @return The event name.
     */
    @Override
    public String getEventName() {
        return eventName;
    }

    /**
     * Sets the event name.
     *
     * @param eventName The event name to set.
     */
    @Override
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * Gets the event description.
     *
     * @return The event description.
     */
    @Override
    public String getEventDescription() {
        return eventDescription;
    }

    /**
     * Sets the event description.
     *
     * @param eventDescription The event description to set.
     */
    @Override
    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    /**
     * Gets the event activities.
     *
     * @return The event activities.
     */
    @Override
    public String getEventActivities() {
        return eventActivities;
    }

    /**
     * Sets the event activities.
     *
     * @param eventActivities The event activities to set.
     */
    @Override
    public void setEventActivities(String eventActivities) {
        this.eventActivities = eventActivities;
    }

    /**
     * Gets the admission fees.
     *
     * @return The admission fees.
     */
    @Override
    public double getAdmissionFees() {
        return admissionFees;
    }

    /**
     * Sets the admission fees.
     *
     * @param admissionFees The admission fees to set.
     */
    @Override
    public void setAdmissionFees(double admissionFees) {
        this.admissionFees = admissionFees;
    }

    /**
     * Calculates the admission fees based on predefined constants.
     *
     * @return The calculated admission fees.
     */
    @Override
    public double calculateAdmissionFees() {
        return Constants.BOOK_LAUCH_DURATION * Constants.BOOK_LAUCH_RATE;
    }

    /**
     * Returns a string representation of the BookLaunchEvent.
     *
     * @return String representation of the BookLaunchEvent.
     */
    @Override
    public String toString() {
        return "BookLaunchEvent{" +
            "eventName='" + eventName + '\'' +
            ", eventDescription='" + eventDescription + '\'' +
            ", eventActivities='" + eventActivities + '\'' +
            ", admissionFees=" + admissionFees +
            '}';
    }
}
