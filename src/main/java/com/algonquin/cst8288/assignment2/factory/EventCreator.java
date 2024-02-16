/*
 * Abstract class representing a generic Event Creator.
 * Subclasses of this class will implement the actual creation of specific events.
 */
package com.algonquin.cst8288.assignment2.factory;

import com.algonquin.cst8288.assignment2.event.Event;

public abstract class EventCreator {
    
    /**
     * Creates an event based on the given event type.
     * 
     * @param eventType The type of event to be created.
     * @return The created event.
     */
    public abstract Event createEvent(String eventType);
}
