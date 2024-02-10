/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment2.factory;

import com.algonquin.cst8288.assignment2.event.*;

/**
 *
 * @author ahmad
 */
public class AcademicEventCreator extends EventCreator{

    @Override
    public Event createEvent(String eventType) {
        switch (eventType) {
            case "workshop":
                return new WorkshopEvent();
            case "booklaunch":
                return new BookLaunchEvent();
            default:
                throw new IllegalArgumentException("Invalid event type: " + eventType);
        }
    }
}
