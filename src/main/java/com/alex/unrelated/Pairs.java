package com.alex.unrelated;

public final class Pairs {
    public static <R> Pair<R> of(R first, R second) {
        return new Pair<>(first, second);
    }
}
