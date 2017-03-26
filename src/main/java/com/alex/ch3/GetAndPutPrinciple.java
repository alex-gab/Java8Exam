package com.alex.ch3;

public final class GetAndPutPrinciple {
    public static void main(String[] args) {
        getPrinciple();
        putPrinciple();
    }

    private static void getPrinciple() {
        Container<Integer> intContainer = new Container<>();
        intContainer.load(1);
        intContainer.load(3);
        Container<? extends Number> numberContainer = intContainer;
//        numberContainer.load(Integer.valueOf(1));
        final Number unload = numberContainer.unload();
    }

    private static void putPrinciple() {
        Container<Object> container = new Container<>();
        container.load(1);
        container.load("two");
        Container<? super Integer> intContainer = container;
        intContainer.load(1);
//        final int a = intContainer.unload();

    }
}
