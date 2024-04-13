package com.alibou.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


public class RandomLongInRange {

    public static long getRandomLongInRange(long min, long max) {
        // Ensure max is greater than min
        if (min > max) {
            throw new IllegalArgumentException("min must be less than or equal to max");
        }

        // Calculate the range
        long range = (max - min) + 1L;

        // Generate a random double within the range
        double randomDouble = Math.random() * range;

        // Cast to long and adjust for potential rounding errors
        return Math.round(randomDouble) + min;
    }



}
