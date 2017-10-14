package com.alex.ch7;

import java.util.concurrent.*;

public final class CheckResults {
    private static int counter = 0;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = null;
        Future<?> result = null;
        try {
            service = Executors.newSingleThreadExecutor();
            result = service.submit(() -> {
                for (int i = 0; i < 500; i++) {
                    CheckResults.counter++;
//                    throw new RuntimeException("wrong!!!");
                }
            });

            System.out.println("before get: " + result.isDone());
            final Object o = result.get(10, TimeUnit.SECONDS);
            if (o == null) {
                System.out.println("return object is null");
            } else {
                System.out.println("return object is NOT null");
            }
            System.out.println("after get: " + result.isDone());
        } catch (ExecutionException e) {
            System.out.println("in exception catch: " + result.isDone());
        } catch (TimeoutException e) {
            System.out.println("Not reached in time");
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }
}
