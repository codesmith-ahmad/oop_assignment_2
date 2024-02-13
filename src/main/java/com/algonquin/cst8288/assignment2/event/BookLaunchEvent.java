/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment2.event;

import com.algonquin.cst8288.assignment2.constants.Constants;

/**
 *
 * @author ahmad
 */
public class BookLaunchEvent implements Event{
    
    protected String eventName;
    protected String eventDescription;
    protected String eventActivities;
    protected double admissionFees;
    
    public BookLaunchEvent() {}
 
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

    // Every library as it own admission fee
    @Override
    public double calculateAdmissionFees(){
        return Constants.BOOK_LAUCH_DURATION * Constants.BOOK_LAUCH_RATE;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
