
package com.algonquin.cst8288.assignment2.event;

import com.algonquin.cst8288.assignment2.constants.Constants;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ahmad
 */
public class BookLaunchEventTest {
       
    /**
     * Test of calculateAdmissionFees method, of class BookLaunchEvent.
     */
    @Test
    public void testCalculateAdmissionFees() {
        Event bookLaunchEvent = new BookLaunchEvent();
        double expectedFee = Constants.BOOK_LAUCH_DURATION * Constants.BOOK_LAUCH_RATE;
        assertEquals(expectedFee, bookLaunchEvent.calculateAdmissionFees(), 0.001);
    }
}
