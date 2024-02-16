
package com.algonquin.cst8288.assignment2.event;

import com.algonquin.cst8288.assignment2.constants.Constants;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ahmad
 */
public class MovieNightEventTest {

    /**
     * Test of calculateAdmissionFees method, of class MovieNightEvent.
     */
    @Test
    public void testCalculateAdmissionFees() {
        Event movieNightEvent = new MovieNightEvent();
        double expectedFee = Constants.MOVIE_NIGHT_DURATION * Constants.MOVIE_NIGHT_RATE;
        assertEquals(expectedFee, movieNightEvent.calculateAdmissionFees(), 0.001);
    }
}
