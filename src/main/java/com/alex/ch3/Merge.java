package com.alex.ch3;

import java.util.HashMap;
import java.util.function.BiFunction;

public final class Merge {
    public static void main(String[] args) {
        final HashMap<String, String> favorites = new HashMap<>();
        favorites.put("Jenny", "Bus Tour");
        favorites.put("Tom", "Tram");
        favorites.put("Greg", null);
        favorites.put(null, "is really null?");

        final BiFunction<String, String, String> mapper = (v1, v2) -> v1.length() > v2.length() ? v1 : v2;
        String jenny = favorites.merge("Jenny", "Skyride", mapper);
        System.out.println(jenny);

        final String bob = favorites.merge("Bob", "Mio", mapper);
        System.out.println(bob);
        System.out.println(favorites);

        final String greg = favorites.merge("Greg", "something for Greg", mapper);
        System.out.println(greg);
        System.out.println(favorites);

        final String nullValue = favorites.merge(null, "yes it is really null", mapper);
        System.out.println(nullValue);
        System.out.println(favorites);

        jenny = favorites.merge("Jenny", "Skyride", (v1, v2) -> null);
        System.out.println(jenny);
        System.out.println(favorites);
    }
}
