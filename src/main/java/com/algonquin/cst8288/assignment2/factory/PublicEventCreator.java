
package com.algonquin.cst8288.assignment2.factory;

import com.algonquin.cst8288.assignment2.event.*;

/**
 *
 * @author ahmad
 */
public class PublicEventCreator extends EventCreator{

    @Override
    public Event createEvent(String eventType) {
        switch (eventType) {
            case "story" -> {return new KidsStoryEvent();}
            case "movie" -> {return new MovieNightEvent();}
            default -> throw new IllegalArgumentException("Invalid event type: " + eventType);
        }
    }
}
