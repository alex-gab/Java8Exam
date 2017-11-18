package com.alex.ch7;

import java.util.Arrays;
import java.util.stream.IntStream;

public final class Order {
    public static void main(String[] args) {
        final int i1 = IntStream.of(1, 2, 3, 4, 5).findAny().getAsInt();
        final int i2 = Arrays.asList(1, 2, 3, 4, 5).stream().findAny().get();
        final int i3 = Arrays.asList(6, 7, 8, 9, 10).parallelStream().sorted().findAny().get();
        System.out.println(i1 + " " + i2+ " " + i3);

    }
}
