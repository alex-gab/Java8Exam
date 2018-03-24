package com.alex.appendixc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class BeachManager {
    private static void goSwimming(Lock lock) {
        lock.lock();
        try {
            if (lock.tryLock()) {
                try {
                    System.out.println("Swim!");
                } finally {
                    lock.unlock();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(2);
            for (int i = 0; i < 2; i++) {
                service.submit(() -> goSwimming(lock));
            }
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }

        System.out.println("Tasks complete!");
    }
}
