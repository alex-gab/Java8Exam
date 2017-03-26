package com.alex.ch1;

public final class Local {
    private int length = 5;

    public void calculate() {
        int width = 20;
        class LocalInner {
            private void multiply() {
                System.out.println(length * width);
            }
        }
        final LocalInner localInner = new LocalInner();
        localInner.multiply();
    }

    public static void main(String[] args) {
        final Local local = new Local();
        local.calculate();
    }
}
