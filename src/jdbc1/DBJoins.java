/**
 * Використовуючи IntelijIdea та JDBC, зробіть вибірку за допомогою JOIN's для таких завдань:
 * 1.Отримайте контактні дані співробітників (номери телефонів, місце проживання).
 * 2.Отримайте інформацію про дату народження всіх неодружених співробітників та їхні номери.
 * 3.Отримайте інформацію про всіх менеджерів компанії: дати народження та номери телефонів.
 */

package jdbc1;

import java.sql.*;


public class DBJoins {
    public static void main(String[] args) throws SQLException {
        final String URL = "jdbc:mysql://localhost:3306/MyJoinsDB?serverTimeZone = Europe/Kiev ";
        final String USER_NAME = "root";
        final String PASSWORD = "3214";


        try {
            Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            Statement statement = connection.createStatement();

            // 1.Отримайте контактні дані співробітників (номери телефонів, місце проживання).

            String sql1 = "SELECT employees.name, employees.phone, personal_info.address " +
                    "FROM employees " +
                    "JOIN personal_info ON employees.id = personal_info.employee_id;";

            ResultSet resultSet1 = statement.executeQuery(sql1);

            System.out.println("\n---------------" + "Контактні дані співробітників: ");
            while (resultSet1.next()) {
                System.out.println("Name: " + resultSet1.getString("name") +
                        ", Phone: " + resultSet1.getString("phone") +
                        ", Address: " + resultSet1.getString("address"));
            }

            // 2.Отримайте інформацію про дату народження всіх неодружених співробітників та їхні номери.

            String sql2 = "  SELECT \n" +
                    "    employees.name, employees.phone, personal_info.birth_date\n" +
                    "FROM\n" +
                    "    employees\n" +
                    "        JOIN\n" +
                    "    personal_info ON employees.id = personal_info.employee_id\n" +
                    "WHERE\n" +
                    "    personal_info.marital_status = 'Неодружений';";

            ResultSet resultSet2 = statement.executeQuery(sql2);

            System.out.println("\n---------------" + "Неодружені співробітники: ");
            while (resultSet2.next()) {
                System.out.println("Name: " + resultSet2.getString("name") +
                        ", Phone: " + resultSet2.getString("phone") +
                        ", Birth Date: " + resultSet2.getDate("birth_date"));
            }

            // 3.Отримайте інформацію про всіх менеджерів компанії: дати народження та номери телефонів.

            String sql3 = "SELECT \n" +
                    "    employees.name,\n" +
                    "    employees.phone,\n" +
                    "    personal_info.birth_date,\n" +
                    "    salaries.position\n" +
                    "FROM\n" +
                    "    employees\n" +
                    "        JOIN\n" +
                    "    salaries ON employees.id = salaries.employee_id\n" +
                    "        JOIN\n" +
                    "    personal_info ON employees.id = personal_info.employee_id\n" +
                    "WHERE\n" +
                    "    salaries.position = 'Менеджер';";
            ResultSet resultSet3 = statement.executeQuery(sql3);

            System.out.println("\n---------------" + "Менеджери компанії:");
            while (resultSet3.next()) {
                System.out.println("Name: " + resultSet3.getString("name") +
                        ", Phone: " + resultSet3.getString("phone") +
                        ", Birth Date: " + resultSet3.getDate("birth_date"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



