package com.alex.unrelated;

import java.util.function.IntFunction;

public final class Pair<R> {
    private final IntFunction<R> applier;

    Pair(R first, R second) {
        applier = m -> {
            if (m == 0) {
                return first;
            } else if (m == 1) {
                return second;
            } else {
                throw new IllegalArgumentException("argument not 0 or 1");
            }
        };
    }

    public final R car() {
        return applier.apply(0);
    }

    public final R cdr() {
        return applier.apply(1);
    }
}
