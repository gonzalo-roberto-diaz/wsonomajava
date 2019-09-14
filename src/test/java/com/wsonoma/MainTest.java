package com.wsonoma;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Examples given by Williams Sonoma
 */
class MainTest {

    /**
     * The first example given
     */
    @Test
    void example1() {
        List<ZipInterval> actual = Lists.newArrayList(
                new ZipInterval(94133, 94133),
                new ZipInterval(94200, 94299),
                new ZipInterval(94600, 94699));

        List<ZipInterval> expected =  Lists.newArrayList(
                new ZipInterval(94133, 94133),
                new ZipInterval(94200, 94299),
                new ZipInterval(94600, 94699)
                );

        Utils.process(actual);

        assertEquals(expected, actual);
    }

    /**
     * The second example given
     */
    @Test
    void example2() {

        List<ZipInterval> actual = Lists.newArrayList(
                new ZipInterval(94133, 94133),
                new ZipInterval(94200, 94299),
                new ZipInterval(94226, 94399));

        List<ZipInterval> expected =  Lists.newArrayList(
                new ZipInterval(94133, 94133),
                new ZipInterval(94200, 94399)
        );

        Utils.process(actual);

        assertEquals(expected, actual);
    }

}