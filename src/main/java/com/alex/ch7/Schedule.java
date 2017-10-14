package com.alex.ch7;

import java.util.concurrent.*;

public final class Schedule {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final Runnable task1 = () -> System.out.println("Hello Zoo");
        final Callable<String> task2 = () -> "Monkey";

        ScheduledExecutorService service = null;
        ScheduledFuture<String> future2;
        try {
            service = Executors.newSingleThreadScheduledExecutor();
            final ScheduledFuture<?> future1 = service.schedule(task1, 20, TimeUnit.SECONDS);
//            future2 = service.schedule(task2, 10, TimeUnit.SECONDS);
        } finally {
            shutdown(service);
        }

//        final String s = future2.get();
//        System.out.println(s);
    }

    private static void shutdown(ExecutorService service) {
        if (service != null) {
            service.shutdown();
        }
    }
}
