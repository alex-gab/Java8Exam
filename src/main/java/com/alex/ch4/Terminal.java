package com.alex.ch4;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public final class Terminal {
    public static void main(String[] args) {
        final Stream<String> strings = Stream.of("mama", "tata", "baba");
        final Optional<String> min = strings.min(Comparator.comparingInt(String::length));
        System.out.println(min.isPresent());
        min.ifPresent(System.out::println);
    }
}
