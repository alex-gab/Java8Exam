package com.alex.ch8;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public final class ObjectStreamSampleAlternate {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final List<AnimalAlt> animalAlts = Arrays.asList(
                new AnimalAlt("Tommy Tiger", 5, 'T'),
                new AnimalAlt("Peter Pinguin", 8, 'P'),
                AnimalAlt.POISON_ANIMAL_ALT);
        final File dataFile = new File("animalAlt.data");
        createAnimalsFile(animalAlts, dataFile);
        System.out.println(getAnimals(dataFile));
    }

    private static List<AnimalAlt> getAnimals(File dataFile) throws IOException, ClassNotFoundException {
        final ArrayList<AnimalAlt> animalAlts = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)))) {
            AnimalAlt animalAlt;
            while (!(animalAlt = (AnimalAlt) inputStream.readObject()).equals(AnimalAlt.POISON_ANIMAL_ALT)) {
                animalAlts.add(animalAlt);
            }
        }
        return animalAlts;
    }

    private static void createAnimalsFile(List<AnimalAlt> animalAlts, File dataFile) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)))) {
            for (AnimalAlt animalAlt : animalAlts) {
                outputStream.writeObject(animalAlt);
            }
        }
    }
}

class AnimalAlt implements Serializable {
    private static final long serialVersionUID = 1;

    public static final AnimalAlt POISON_ANIMAL_ALT = new AnimalAlt("N/A", 0, 'P');

    private transient String name;
    private transient int age = 10;
    private static char type = 'C';

    {
        this.age = 14;
    }

    public AnimalAlt() {
        this.name = "Unknown";
        this.age = 12;
        this.type = 'Q';
    }

    AnimalAlt(String name, int age, char type) {
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
        AnimalAlt animalAlt = (AnimalAlt) o;
        return age == animalAlt.age &&
                type == animalAlt.type &&
                Objects.equals(name, animalAlt.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, type);
    }

    @Override
    public String toString() {
        return "AnimalAlt{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", type=" + type +
                '}';
    }
}

