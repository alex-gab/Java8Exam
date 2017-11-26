package com.alex.ch7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public final class PrintCounter {
    static int counter = 0;

    public static void main(String[] args) throws Exception {
        final ExecutorService service = Executors.newSingleThreadExecutor();
        List<Future<?>> results = new ArrayList<>();
        IntStream.iterate(0, i -> i + 1).limit(5).
                forEach(i -> results.add(service.submit(() -> counter++)));
        for (Future<?> result : results) {
            System.out.print(result.get() + " ");
        }
        service.shutdown();


//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = bufferedReader.readLine()) != null) {
//            String lineReference = line;
//            runLater(() -> System.out.println(lineReference));
//        }
    }
}
