
package com.algonquin.cst8288.assignment2.event;

import com.algonquin.cst8288.assignment2.constants.Constants;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ahmad
 */
public class KidsStoryEventTest {
    
    /**
     * Test of calculateAdmissionFees method, of class KidsStoryEvent.
     */
    @Test
    public void testCalculateAdmissionFees() {
        Event kidsStoryEvent = new KidsStoryEvent();
        double expectedFee = Constants.KIDS_STORYTIME_DURATION * Constants.KIDS_STORYTIME_RATE;
        assertEquals(expectedFee, kidsStoryEvent.calculateAdmissionFees(), 0.001);
    }
}
