package com.alex.ch8;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public final class ObjectStreamSample {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final List<Animal> animals = Arrays.asList(
                new Animal("Tommy Tiger", 5, 'T'),
                new Animal("Peter Pinguin", 8, 'P'),
                Animal.POISON_ANIMAL);
        final File dataFile = new File("animal.data");
        createAnimalsFile(animals, dataFile);
        System.out.println(getAnimals(dataFile));
    }

    private static List<Animal> getAnimals(File dataFile) throws IOException, ClassNotFoundException {
        final ArrayList<Animal> animals = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)))) {
            Animal animal;
            while (!(animal = (Animal) inputStream.readObject()).equals(Animal.POISON_ANIMAL)) {
                animals.add(animal);
            }
        }
        return animals;
    }

    private static void createAnimalsFile(List<Animal> animals, File dataFile) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)))) {
            for (Animal animal : animals) {
                outputStream.writeObject(animal);
            }
        }
    }
}

class Animal implements Serializable {
    private static final long serialVersionUID = 1;

    public static final Animal POISON_ANIMAL = new Animal("N/A", 0, 'P');

    private String name;
    private int age;
    private char type;

    Animal(String name, int age, char type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return age == animal.age &&
                type == animal.type &&
                Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, type);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", type=" + type +
                '}';
    }
}