package com.alex.ch1;

public final class Outer {
    private String greeting = "Hi";

    private class Inner {
        private int repeat = 3;

        private void go() {
            for (int i = 0; i < repeat; i++) {
                System.out.println(Outer.this.greeting);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Outer().new Inner().repeat);
        new Outer().new Inner().go();
    }
}
