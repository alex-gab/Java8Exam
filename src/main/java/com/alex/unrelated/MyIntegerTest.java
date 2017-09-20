package com.alex.unrelated;

import java.lang.reflect.Method;
import java.util.Arrays;

public final class MyIntegerTest {
    public static void main(String[] args) {
        Arrays.stream(MyInteger.class.getMethods()).
                filter(m -> m.getName().equals("compareTo")).
                map(Method::toGenericString).
                forEach(System.out::println);
    }
}
