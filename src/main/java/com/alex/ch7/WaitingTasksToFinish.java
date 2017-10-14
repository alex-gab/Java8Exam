package com.alex.ch7;

import java.util.List;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.stream.IntStream;

import static java.util.concurrent.TimeUnit.MINUTES;
import static java.util.stream.Collectors.toList;

public final class WaitingTasksToFinish {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = null;
        List<Future<Integer>> results;
        try {
            service = Executors.newSingleThreadExecutor();
            results = service.invokeAll(
                    IntStream.range(0, 10).
                            mapToObj(i -> (Callable<Integer>) () -> i + 10).
                            collect(toList()));
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }

        service.awaitTermination(1, MINUTES);
        if (service.isTerminated()) {
            System.out.println("All tasks finished");
            results.stream().map(mapResult()).forEach(i -> System.out.println("result is: " + i));
        } else {
            System.out.println("At least one task is still running");
        }
    }

    private static Function<Future<Integer>, Integer> mapResult() {
        return f -> {
            try {
                return f.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
