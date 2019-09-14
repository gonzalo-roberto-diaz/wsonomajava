package com.wsonoma;

import com.google.common.annotations.VisibleForTesting;
import java.util.*;

/**
 * Static utilities used to perform ZipInterval actions
 */
public class Utils {
    /**
     * Indicates whether or not a ZipInterval overlaps second
     * @param first         a first the interval or reference
     * @param second        second interval (assumed "bigger" start-wise)
     * @return              true if they overlap, false otherwise
     */
    @VisibleForTesting
    static boolean overlaps(ZipInterval first, ZipInterval second ){
        return second.lower <= first.upper;
    }

    /**
     * Merges 2 intervals. the first interval's boundaries are expanded boundaries
     *                     in order to encompass both intervals
     * @param first        the first interval. This element is modified by the method (non-functional)
     * @param second       the second interval (assumed "bigger" start-wise). Apt to be de-referenced after this
     */
    static void merge(ZipInterval first, ZipInterval second){
        if (first.upper < second.lower){
            throw new IllegalArgumentException(String.format("intervals %s and %s do not overlap", first, second));
        }
        if (second.upper > first.upper){
            first.upper = second.upper;
        }
    }

    /**
     * The entry point of this exercise.
     * Given a collection of Zip ranges, returns a sorted, minimal version
     * encompassing the same Zip values
     * @param intervals     a collection of ZipIntervals.
     *                      This list is modified by the method (non-functional)
     */
    public static void process(List<ZipInterval> intervals) {
        intervals.sort(new IntervalComparator());
        Iterator<ZipInterval> it = intervals.iterator();

        ZipInterval current = it.next();
        while(it.hasNext()){
            ZipInterval afterCurrent = it.next();
            if (overlaps(current, afterCurrent)){
                merge(current, afterCurrent);
                it.remove();
            }else {
                current = afterCurrent;
            }
        }
    }

    private static class IntervalComparator implements Comparator<ZipInterval> {
        @Override
        public int compare(ZipInterval interval1, ZipInterval interval2) {
            return Integer.compare(interval1.lower, interval2.lower);
        }
    }

}
