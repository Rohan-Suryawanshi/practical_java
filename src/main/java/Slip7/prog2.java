/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Slip7;
import java.sql.*;

public class prog2 {
    // Database connection details
    private static final String url = "jdbc:postgresql://localhost:5432/your_database"; // Replace 'your_database' with your actual database name
    private static final String username = "username"; // Replace 'username' with your actual username
    private static final String password = "password"; // Replace 'password' with your actual password

    public static void main(String[] args) {
        // Create the Product table
        createProductTable();

        // Insert records into the Product table
        insertRecords();

        // Display all records from the Product table
        displayRecords();
    }

    // Method to create the Product table
    private static void createProductTable() {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            String createTableQuery = "CREATE TABLE Product (Pid SERIAL PRIMARY KEY, Pname VARCHAR(100) NOT NULL, Price NUMERIC(10,2) NOT NULL)";
            statement.executeUpdate(createTableQuery);
            System.out.println("Product table created successfully.");
        } catch (SQLException e) {
            System.err.println("Error creating Product table: " + e.getMessage());
        }
    }

    // Method to insert records into the Product table
    private static void insertRecords() {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            String[] products = {"Mobile", "Laptop", "Headphones", "Tablet", "Smartwatch"};
            double[] prices = {500.00, 1000.00, 50.00, 300.00, 150.00};

            for (int i = 0; i < products.length; i++) {
                String insertQuery = "INSERT INTO Product (Pname, Price) VALUES ('" + products[i] + "', " + prices[i] + ")";
                statement.executeUpdate(insertQuery);
            }
            System.out.println("Records inserted into Product table successfully.");
        } catch (SQLException e) {
            System.err.println("Error inserting records into Product table: " + e.getMessage());
        }
    }

    // Method to display all records from the Product table
    private static void displayRecords() {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            String selectQuery = "SELECT * FROM Product";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            System.out.println("ProductID | ProductName | Price");
            while (resultSet.next()) {
                int pid = resultSet.getInt("Pid");
                String pname = resultSet.getString("Pname");
                double price = resultSet.getDouble("Price");
                System.out.println(pid + " | " + pname + " | " + price);
            }
        } catch (SQLException e) {
            System.err.println("Error displaying records from Product table: " + e.getMessage());
        }
    }
}
