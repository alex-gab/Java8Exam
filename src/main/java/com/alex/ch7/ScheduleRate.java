package com.alex.ch7;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public final class ScheduleRate {
    public static void main(String[] args) throws InterruptedException {
        final Runnable task = () -> {
            if (!Thread.currentThread().isInterrupted()) {
                System.out.println("Hello Zoo");
            }
        };
        ScheduledExecutorService service = null;
        ScheduledFuture<?> future = null;

        try {
            service = Executors.newSingleThreadScheduledExecutor();
            future = service.scheduleAtFixedRate(task, 5, 2, SECONDS);
        } finally {
            TimeUnit.SECONDS.sleep(10);
            final boolean isCancelled = future != null && future.cancel(true);
            System.out.println(isCancelled);
            shutdown(service);
        }
    }

    private static void shutdown(ScheduledExecutorService service) {
        if (service != null) {
            service.shutdown();
        }
    }
}
