/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.algonquin.cst8288.assignment2.event;

import com.algonquin.cst8288.assignment2.constants.Constants;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ahmad
 */
public class WorkshopEventTest {

    /**
     * Test of calculateAdmissionFees method, of class WorkshopEvent.
     */
    @Test
    public void testCalculateAdmissionFees() {
        Event workshopEvent = new WorkshopEvent();
        double expectedFee = Constants.WORKSHOP_DURATION * Constants.WORKSHOP_RATE;
        assertEquals(expectedFee, workshopEvent.calculateAdmissionFees(), 0.001);
    }
}
