package Slip30;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class prog2 {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/msg"; // Replace 'your_database' with your actual database name
        String username = "postgres"; // Replace 'username' with your actual username
        String password = "root"; // Replace 'password' with your actual password

        try {
            // Establish connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Create a statement with scrollable ResultSet
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           
            // Execute query to select all rows from the Teacher table
            ResultSet resultSet = statement.executeQuery("SELECT * FROM college");

            // Move the cursor to the first row
            resultSet.first();
        

            // Print column headers
            System.out.println("Teacher ID | Teacher Name | Salary");

            // Iterate through the result set and print each row
            while (resultSet.next()) {
                int tid = resultSet.getInt("cid");
                String tname = resultSet.getString("cname");
                double salary = resultSet.getDouble("year");
                System.out.println(tid + " | " + tname + " | " + salary);
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

