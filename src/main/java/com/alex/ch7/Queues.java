package com.alex.ch7;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * A {@link Deque} has a head and a tail (a front and a back).
 * For a stack the head is named top and the tail is named bottom.
 */
public final class Queues {
    public static void main(String[] args) {
        final Deque<Integer> queue = new ArrayDeque<>();
        System.out.println(queue.offer(1));
        System.out.println(queue.offer(2));
        System.out.println(queue.offer(3));
        System.out.println(queue);

        System.out.println(queue.peek());
        System.out.println(queue);

        System.out.println(queue.poll());
        System.out.println(queue);

        System.out.println("--------------------------");

        final Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);

        System.out.println(stack.peek());
        System.out.println(stack);

        System.out.println(stack.poll());
        System.out.println(stack);
    }
}
