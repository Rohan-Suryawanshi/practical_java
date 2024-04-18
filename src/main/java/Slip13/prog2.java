/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Slip13;

import java.sql.*;

public class prog2 {
    private static final String url = "jdbc:postgresql://localhost:5432/your_database"; // Replace 'your_database' with your actual database name
    private static final String username = "username"; // Replace 'username' with your actual username
    private static final String password = "password"; // Replace 'password' with your actual password

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            DatabaseMetaData metaData = connection.getMetaData();

            // Display database information
            System.out.println("Database Product Name: " + metaData.getDatabaseProductName());
            System.out.println("Database Product Version: " + metaData.getDatabaseProductVersion());
            System.out.println("Driver Name: " + metaData.getDriverName());
            System.out.println("Driver Version: " + metaData.getDriverVersion());

            // List all tables in the database
            System.out.println("\nTables in the Database:");
            ResultSet tablesResultSet = metaData.getTables(null, null, "%", new String[]{"TABLE"});
            while (tablesResultSet.next()) {
                String tableName = tablesResultSet.getString("TABLE_NAME");
                System.out.println(tableName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
