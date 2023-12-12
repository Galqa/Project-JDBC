/**
 * Створити базу даних у Workbench, під'єднати до IntelijIdea та створити тестову таблицю.
 * Заповнити її даними за допомогою запитів MySQL у Intelij Idea.
 * Використовуючи JDBC, написати приклад виконання всіх запитів.
 */

package jdbc1;
import java.sql.*;


public class DBZaput1 {
    public static void main(String[] args) throws SQLException {
        final String URL = "jdbc:mysql://localhost:3306/carsdb?serverTimeZone = Europe/Kiev ";
        final String USER_NAME = "root";
        final String PASSWORD = "3214";

        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            Statement statement = connection.createStatement()) {

            String sql1 = "SELECT * FROM carsdb.cars";
            ResultSet resultSet1 = statement.executeQuery(sql1);
            System.out.println("\n--" + "Вибрати всі рядки з таблиці Cars: ");
            while (resultSet1.next()) {
                int id = resultSet1.getInt("id");
                String brand = resultSet1.getString("brand");
                String model = resultSet1.getString("model");
                String engine_volume = resultSet1.getString("engine_volume");
                String price = resultSet1.getString("price");
                int max_speed = resultSet1.getInt("max_speed");
                System.out.println("ID: " + id + ", Brand: " + brand + ", Model: " + model +
                        ", Engine_volume: " + engine_volume + ", Price: " + price + ", Max_speed: " + max_speed);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

