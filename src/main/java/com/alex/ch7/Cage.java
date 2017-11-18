package com.alex.ch7;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class Cage {
    private static void removeAnimals() {
        System.out.println("Removing animals");
    }

    private static void cleanCage() {
        System.out.println("Cleaning cage");
    }

    private static void addingAnimals() {
        System.out.println("Adding animals");
    }

    private static void cageCleanRoutine(CyclicBarrier b1, CyclicBarrier b2) {
        try {
            removeAnimals();
            b1.await();
            cleanCage();
            b2.await();
            addingAnimals();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CyclicBarrier b1 = new CyclicBarrier(4);
        CyclicBarrier b2 = new CyclicBarrier(4, () -> System.out.println("Cage cleaned!!!"));
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(4);
            for (int i = 0; i < 4; i++) {
                service.submit(() -> cageCleanRoutine(b1, b2));
            }
        } catch (Exception e) {
            if (service != null) {
                service.shutdown();
            }
        }
    }
}
