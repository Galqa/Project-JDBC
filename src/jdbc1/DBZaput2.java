package jdbc1;

import java.sql.*;

public class DBZaput2 {
    public static void main(String[] args) throws SQLException {
        final String URL = "jdbc:mysql://localhost:3306/carsdb?serverTimeZone = Europe/Kiev ";
        final String USER_NAME = "root";
        final String PASSWORD = "3214";

        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
             Statement statement = connection.createStatement()) {

            String sql = "UPDATE Cars SET brand = 'Hyundai' WHERE id = 1";
            int rowsUpdated = statement.executeUpdate(sql);

            System.out.println("Оновити значення поля brand в таблиці Cars для рядка з id = 1: " + rowsUpdated);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}