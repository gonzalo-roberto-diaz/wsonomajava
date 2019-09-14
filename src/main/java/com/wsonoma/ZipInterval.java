package com.wsonoma;

import com.google.common.base.Objects;


/**
 * A domain class representing an interval of US ZIP codes
 */
public class ZipInterval implements Comparable<ZipInterval> {
    int lower;
    int upper;

    @Override
    public int compareTo(ZipInterval other) {
        return Integer.compare(this.lower, other.lower);
    }

    ZipInterval(int lower, int upper){
        if (lower > upper){
            throw new IllegalArgumentException(String.format("the first element %d cannot be bigger than " +
                    "the second %d ", lower, upper));
        }
        this.lower = lower;
        this.upper = upper;
    }

    public String toString(){
        return "(" + this.lower + ", " + this.upper + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZipInterval that = (ZipInterval) o;
        return lower == that.lower &&
                upper == that.upper;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lower, upper);
    }



}
