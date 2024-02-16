
package com.algonquin.cst8288.assignment2.logger;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ahmad
 */
public class LMSLoggerTest {
    
    /**
     * Test of getInstance method, of class LMSLogger.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");

        // Retrieve two instances
        LMSLogger instance1 = LMSLogger.getInstance();
        LMSLogger instance2 = LMSLogger.getInstance();

        // Check that they are not null
        assertSame("Instances are the same", instance1, instance2);
    }
}
