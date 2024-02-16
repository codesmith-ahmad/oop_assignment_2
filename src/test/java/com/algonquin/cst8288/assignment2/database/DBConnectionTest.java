
package com.algonquin.cst8288.assignment2.database;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ahmad
 */
public class DBConnectionTest {

    /**
     * Test of getInstance method, of class DBConnection.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");

        // Retrieve two instances
        DBConnection instance1 = DBConnection.getInstance();
        DBConnection instance2 = DBConnection.getInstance();

        // Check that they are not null
        assertSame("Instances are the same", instance1, instance2);
    }
}
