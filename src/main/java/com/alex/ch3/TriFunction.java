package com.alex.ch3;

@FunctionalInterface
public interface TriFunction<T, U, P, R> {
    R apply(T t, U u, P p);
}

interface TernaryOperator<T> extends TriFunction<T, T, T, T> {

    T apply(T t, T t2, T t3);
}