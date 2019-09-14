package com.wsonoma;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ZipIntervalTest {

    @Test
    void failCreation() {
        assertThrows(IllegalArgumentException.class, () ->  new ZipInterval(22222, 11111));
    }

    @Test
    void compareTo() {
        ZipInterval minor = new ZipInterval(11111, 22222);
        ZipInterval major = new ZipInterval(33333, 44444);

        assertTrue(minor.compareTo(major) < 0);
    }

    @Test
    void testToString() {
        ZipInterval any = new ZipInterval(22222, 33333);
        String expected = "(22222, 33333)";

        assertEquals(expected, any.toString());
    }
}