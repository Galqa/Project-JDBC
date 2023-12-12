package jdbc1;

import java.sql.*;

public class DBZaput4 {
    public static void main(String[] args) throws SQLException {
        final String URL = "jdbc:mysql://localhost:3306/carsdb?serverTimeZone = Europe/Kiev ";
        final String USER_NAME = "root";
        final String PASSWORD = "3214";

        try {
            Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM cars ORDER BY brand";
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println("\n--" + "виводимо з «brand» всі записи із сортуванням в алфавітному порядку за першою літерою назви авто: ");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                String engine_volume = resultSet.getString("engine_volume");
                String price = resultSet.getString("price");
                int max_speed = resultSet.getInt("max_speed");
                System.out.println("ID: " + id + ", Brand: " + brand + ", Model: " + model +
                        ", Engine_volume: " + engine_volume + ", Price: " + price + ", Max_speed: " + max_speed);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}






