package com.wsonoma;
import org.junit.jupiter.api.Test;

import static  org.junit.jupiter.api.Assertions.*;


class UtilsTest {

    @Test
    void overlaps() {
        ZipInterval first = new ZipInterval(11000, 11010);
        ZipInterval second = new ZipInterval(11010, 11020);

        assertTrue(Utils.overlaps(first, second));

        first = new ZipInterval(11000, 11010);
        second = new ZipInterval(11015, 11020);

        assertFalse(Utils.overlaps(first, second));
    }

    /**
     * Tests "merge" where the second range is included in the first
     * (the opposite is not possible)
     */
    @Test
    void mergeSecondIncluded() {
        ZipInterval first = new ZipInterval(94200, 94299);
        ZipInterval second = new ZipInterval(94226, 94226);

        Utils.merge(first, second);

        ZipInterval expected = new ZipInterval(94200, 94299);

        assertEquals(expected, first);
    }

    /**
     * Tests "merge" where one of the ranges is actually included in the other
     */
    @Test
    void mergeOverlapping() {
        ZipInterval first = new ZipInterval(10000, 10200);
        ZipInterval second = new ZipInterval(10100, 10300);

        Utils.merge(first, second);

        ZipInterval expected = new ZipInterval(10000, 10300);

        assertEquals(expected, first);
    }
}