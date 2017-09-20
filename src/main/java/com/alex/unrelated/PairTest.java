package com.alex.unrelated;

public final class PairTest {
    public static void main(String[] args) {
        final Pair<String> pair = Pairs.of("Ion", "Maria");
        System.out.println(pair.car());
        System.out.println(pair.cdr());
    }
}
