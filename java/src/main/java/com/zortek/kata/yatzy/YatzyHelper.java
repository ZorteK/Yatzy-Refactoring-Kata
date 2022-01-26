package com.zortek.kata.yatzy;

import java.util.stream.Collector;

import static java.util.stream.Collectors.reducing;

public class YatzyHelper {
    public static final Collector<Integer, ?, Integer> countingInt = reducing(0, e -> 1, Integer::sum);

    private YatzyHelper() {
        throw new IllegalStateException("Utility class");
    }
}
