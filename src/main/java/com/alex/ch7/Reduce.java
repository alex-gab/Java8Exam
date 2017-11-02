package com.alex.ch7;

import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class Reduce {
    public static void main(String[] args) {
        System.out.println(IntStream.of(1, 2, 3, 4).
                reduce(0, (a, b) -> a + b));

        System.out.println(Stream.of(1, 2, 3, 4).
                reduce(0, (i, s) -> i + s, (s1, s2) -> s1 + s2));

        System.out.println(Stream.of(1, 2, 3, 4).
                reduce(new StringBuilder(), StringBuilder::append, StringBuilder::append).toString());

        System.out.println(Stream.of('w', 'o', 'l', 'f').
                reduce("", (s, c) -> s + c, (s1, s2) -> s1 + s2));

        System.out.println("***************");
        final Stream<String> ohMy = Stream.of("lions", "tigers", "bears").parallel();
        final ConcurrentMap<Integer, String> map = ohMy.collect(Collectors.toConcurrentMap(String::length, Function.identity(), (s1, s2) -> s1 + "," + s2));
        System.out.println(map);
        System.out.println(map.getClass());


        System.out.println("***************");
        final ConcurrentMap<Integer, List<String>> collect = Stream.of("lions", "tigers", "bears").parallel().
                collect(Collectors.groupingByConcurrent(String::length));
        System.out.println(collect);
        System.out.println(collect.getClass());

    }
}
