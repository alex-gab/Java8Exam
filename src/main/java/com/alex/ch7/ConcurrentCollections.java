package com.alex.ch7;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.SECONDS;

public final class ConcurrentCollections {
    public static void main(String[] args) throws InterruptedException {
        final Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put("zebra", 52);
        for (String key : map.keySet()) {
            System.out.println("key is: " + key);
            map.remove(key);
        }

        System.out.println();

        final ConcurrentLinkedDeque<Object> deque = new ConcurrentLinkedDeque<>();
        deque.offer(10);
        deque.push(4);
        System.out.println(deque.peek());
        System.out.println(deque.pop());

        final BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
        final Thread thread = new Thread(() -> {
            try {
                System.out.println(blockingQueue.poll(100, SECONDS));
            } catch (InterruptedException e) {
                System.out.println("I am interrupted!");
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(3);
        thread.interrupt();

        final List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(4, 3, 52));
        for (Integer item : list) {
            System.out.println(item + " ");
            list.add(9);
        }
        System.out.println();
        System.out.println("Size: " + list.size());
        System.out.println(list);
    }
}
