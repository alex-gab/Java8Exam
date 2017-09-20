package com.alex.ch3;

import java.util.ArrayDeque;

public final class QueueAndStackTest {
    public static void main(String[] args) {
        final ArrayDeque<String> greetings = new ArrayDeque<>();
        greetings.offer("hello");
        greetings.offer("hi");
        greetings.offer("ola");
        greetings.pop();
        greetings.peek();

        while (greetings.peek() != null) {
            System.out.print(greetings.pop());
        }
    }
}
