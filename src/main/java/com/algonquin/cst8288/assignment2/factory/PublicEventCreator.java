/*
 * Concrete subclass of EventCreator for creating public events.
 */
package com.algonquin.cst8288.assignment2.factory;

import com.algonquin.cst8288.assignment2.event.Event;
import com.algonquin.cst8288.assignment2.event.EventType;
import com.algonquin.cst8288.assignment2.event.KidsStoryEvent;
import com.algonquin.cst8288.assignment2.event.MovieNightEvent;

public class PublicEventCreator extends EventCreator {

    /**
     * Creates a public event based on the given event type.
     * 
     * @param eventType The type of event to be created.
     * @return The created public event.
     * @throws IllegalArgumentException if the event type is not recognized.
     */
    @Override
    public Event createEvent(String eventType) {
        switch (EventType.valueOf(eventType.toUpperCase())) {
            case KIDS_STORY -> { return new KidsStoryEvent(); }
            case MOVIE_NIGHT -> { return new MovieNightEvent(); }
            default -> throw new IllegalArgumentException("Invalid public event type: " + eventType);
        }
    }
}
