package com.alex.unrelated;

public final class MyInteger implements Comparable<MyInteger> {
    private final int value;

    public MyInteger(int value) {
        this.value = value;
    }

    public int compareTo(MyInteger i) {
        return (value < i.value) ? -1 : (value == i.value) ? 0 : 1;
    }
}
