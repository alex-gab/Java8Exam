package com.alex.ch4;

import java.util.stream.Stream;

public final class Reduction {
    public static void main(String[] args) {
        final Stream<Integer> elements = Stream.empty();
        final Integer result = elements.reduce(2, (a, b) -> a * b);
        System.out.println(result);
    }
}
