/**
 * Represents a Kids Story Event.
 * Extends the Event interface and provides implementation for event-specific details.
 */
package com.algonquin.cst8288.assignment2.event;

import com.algonquin.cst8288.assignment2.constants.Constants;

public class KidsStoryEvent implements Event {

    protected String eventName = "kids story";
    protected String eventDescription = "";
    protected String eventActivities = "";
    protected double admissionFees;

    /**
     * Default constructor.
     * Initializes admission fees based on constants.
     */
    public KidsStoryEvent() {
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
     * Calculates admission fees based on the duration and rate constants for Kids Story Event.
     *
     * @return The calculated admission fees.
     */
    @Override
    public double calculateAdmissionFees() {
        return Constants.KIDS_STORYTIME_DURATION * Constants.KIDS_STORYTIME_RATE;
    }

    /**
     * Generates a string representation of the Kids Story Event.
     *
     * @return A string representation of the Kids Story Event.
     */
    @Override
    public String toString() {
        return "KidsStoryEvent{" +
                "eventName='" + eventName + '\'' +
                ", eventDescription='" + eventDescription + '\'' +
                ", eventActivities='" + eventActivities + '\'' +
                ", admissionFees=" + admissionFees +
                '}';
    }
}
