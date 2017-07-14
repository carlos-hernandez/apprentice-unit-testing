package com.nearsoft.apprentice.testing.asserts;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class JUnitAssertTests {

    @Test
    public void arrayIsEquals() {
        byte[] expected = "trial".getBytes();
        byte[] actual = "trial".getBytes();
        assertArrayEquals("Failure - Byte arrays not same", expected, actual);
    }

    @Test
    public void stringIsEquals() {
        assertEquals("Failure - Strings are not equal", "text", "text");
    }

    @Test
    public void valueIsTrue() {
        assertTrue("failure - should be true", true);
    }

    @Test
    public void valueIsFalse() {
        assertFalse("Failure - Should be false", false);
    }

    @Test
    public void objectIsNotNull() {
        assertNotNull("Failure - Should not be null", new Object());
    }

    @Test
    public void objectsAreNotSame() {
        assertNotSame("Failure - Should not be same Object", new Object(), new Object());
    }

    @Test
    public void objectIsNull() {
        assertNull("Failure - Should be null", null);
    }

    @Test
    public void numbersAreSame() {
        Integer number = 768;
        assertSame("Failure - Should be same", number, number);
    }
}
