package com.alex.ch10;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Locale;

public final class DateRepository {
    public static void main(String[] args) throws SQLException {
        final String name = "Elsa";

        final LocalDateTime dateBorn = fetchAnimalDateBorn(name);
        System.out.printf(Locale.US, "%tA %<tB %<Td, %<tY, %<tl:%<tM %<tp", dateBorn);
    }

    private static LocalDateTime fetchAnimalDateBorn(String name) throws SQLException {
        final String sql = "select DATE_BORN from animal where name = ?";
        LocalDateTime dateBorn = null;
        try (final Connection connection = DriverManager.getConnection("jdbc:derby:zoo");
             final PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            final ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                dateBorn = resultSet.getTimestamp("DATE_BORN").toLocalDateTime();

            }
        }
        return dateBorn;
    }
}
