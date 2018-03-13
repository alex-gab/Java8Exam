package com.alex.ch10;

import java.sql.*;

public final class Species {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:derby:zoo";
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {
            final ResultSet resultSet = statement.executeQuery("select id, name from species");
            final ResultSetMetaData metaData = resultSet.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                System.out.printf(
                        "column name is: %s, type is %d and name is %s, class name is %s%n",
                        metaData.getColumnName(i),
                        metaData.getColumnType(i),
                        metaData.getColumnTypeName(i),
                        metaData.getColumnClassName(i));
            }
            while (resultSet.next()) {
                final int id = resultSet.getInt("id");
                final String name = resultSet.getString("name");
                System.out.printf("id is %d, name is %s%n", id, name);
            }
        }
    }
}
