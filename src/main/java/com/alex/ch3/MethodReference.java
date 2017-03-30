package com.alex.ch3;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public final class MethodReference {
    public static void main(String[] args) {
        final Comparator<Duck> byWeight = DuckHelper::compareByWeight;
        BinaryOperator<Duck> op = Duck::copy;
        TernaryOperator<Duck> specialOp = Duck::specialCopy;
    }
}

class DuckHelper {
    static int compareByWeight(Duck d1, Duck d2) {
        return d1.getWeight() - d2.getWeight();
    }

    static int compareByName(Duck d1, Duck d2) {
        return d1.getName().compareTo(d2.getName());
    }
}

class Duck {
    private String name;
    private int weight;


    String getName() {
        return name;
    }

    int getWeight() {
        return weight;
    }

    Duck copy(Duck other) {
        this.name = other.name;
        this.weight = other.weight;
        return this;
    }

    Duck specialCopy(Duck first, Duck second) {
        this.name = first.name;
        this.weight = second.weight;
        return this;
    }
}