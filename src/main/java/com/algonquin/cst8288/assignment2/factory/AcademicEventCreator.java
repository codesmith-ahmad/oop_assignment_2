/**
 * Concrete implementation of EventCreator for Academic Events.
 * Extends the abstract EventCreator class and provides the implementation for creating Academic Events.
 */
package com.algonquin.cst8288.assignment2.factory;

import com.algonquin.cst8288.assignment2.event.*;

public class AcademicEventCreator extends EventCreator {

    /**
     * Creates an Academic Event based on the given event type.
     * 
     * @param eventType The type of event to be created.
     * @return The created Academic Event.
     * @throws IllegalArgumentException if the event type is invalid.
     */
    @Override
    public Event createEvent(String eventType) {
        switch (eventType) {
            case "workshop" -> {
                return new WorkshopEvent();
            }
            case "booklaunch" -> {
                return new BookLaunchEvent();
            }
            default -> throw new IllegalArgumentException("Invalid event type: " + eventType);
        }
    }
}
