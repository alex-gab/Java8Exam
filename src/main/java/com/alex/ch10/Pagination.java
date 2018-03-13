package com.alex.ch10;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public final class Pagination {
    private static int pageSize = 2;

    public static void main(String[] args) throws SQLException {
        System.out.printf("First page is: %s%n", fetchAnimals(1));
        System.out.printf("Second page is: %s%n", fetchAnimals(2));
        System.out.printf("Third page is: %s%n", fetchAnimals(3));
    }

    private static List<Animal> fetchAnimals(int pageNum) throws SQLException {
        final List<Animal> animals = new ArrayList<>();
        final String sql = "select name, date_born from animal offset ? rows fetch first ? rows only";
        try (final Connection connection = DriverManager.getConnection("jdbc:derby:zoo");
             final PreparedStatement statement = connection.prepareStatement(
                     sql,
                     ResultSet.TYPE_SCROLL_SENSITIVE,
                     ResultSet.CONCUR_READ_ONLY)) {
            statement.setFetchSize(pageSize);
            statement.setMaxRows(pageSize);
            statement.setInt(1, (pageNum - 1) * pageSize);
            statement.setInt(2, pageSize);
            final ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                final Animal animal = new Animal(
                        resultSet.getString("name"),
                        resultSet.getTimestamp("date_born").toLocalDateTime());
                animals.add(animal);

            }
        }
        return animals;
    }

}

class Animal {
    private final String name;
    private final LocalDateTime dateBorn;

    Animal(String name, LocalDateTime dateBorn) {
        this.name = name;
        this.dateBorn = dateBorn;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", dateBorn=" + dateBorn +
                '}';
    }
}
