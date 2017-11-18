package com.alex.ch7;

import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

public final class Atomic {
    private static final AtomicLong value1 = new AtomicLong(0);
    private static final long[] value2 = {0};

    public static void main(String[] args) {
        IntStream.iterate(1, i -> 1).limit(100).parallel().
                forEach(value -> value1.incrementAndGet());
        IntStream.iterate(1, i -> 1).limit(100).parallel().
                forEach(value -> ++value2[0]);
        System.out.println(value1 + " " + value2[0]);
    }
}
