package com.alex.ch10;

import java.sql.*;

public final class MyFirstDatabaseConnection {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:derby:zoo")) {
            final Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery("select name from animal");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
        }
    }
}
