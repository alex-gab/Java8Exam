package com.alex.ch5;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.function.Consumer;

public final class DatesAndTimes {
    public static void main(String[] args) {
        final LocalDate start = LocalDate.of(2015, Month.JANUARY, 1);
        final LocalDate end = LocalDate.of(2015, Month.MARCH, 30);
        final Period period = Period.ofMonths(1);
        performAnimalEnrichement(start, end, period);
    }

//    private static void performAnimalEnrichement(LocalDate start, LocalDate end, Period period) {
//        LocalDate acc = start;
//        while (acc.isBefore(end)) {
//            System.out.println("change the toy");
//            acc = acc.plus(period);
//        }
//    }

    private static void performAnimalEnrichement(LocalDate start, LocalDate end, Period period) {
        RConsumer<LocalDate> consumer = (f, acc) -> {
            if (acc.isBefore(end)) {
                System.out.println("change the toy");
                f.accept(acc.plus(period));
            }
        };

        consumer.accept(start);
    }
}

@FunctionalInterface
interface RConsumer<T> extends Consumer<T> {
    void recursiveCall(Consumer<? super T> func, T in);

    @Override
    default void accept(T in) {
        recursiveCall(this, in);
    }
}
