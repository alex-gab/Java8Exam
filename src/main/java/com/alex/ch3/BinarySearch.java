package com.alex.ch3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class BinarySearch {
    public static void main(String[] args) {
        final List<String> names = Arrays.asList("Fluffy", "Hoppy");
        final int i = Collections.binarySearch(names, "Hoppy", Comparator.naturalOrder());
        System.out.println(i);
    }
}
