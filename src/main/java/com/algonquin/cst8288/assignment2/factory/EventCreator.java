/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.algonquin.cst8288.assignment2.factory;

import com.algonquin.cst8288.assignment2.event.Event;

/**
 *
 * @author ahmad
 */
public abstract class EventCreator {
    public abstract Event createEvent(String eventType);
}
