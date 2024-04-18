
package Slip11;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class prog1 {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/msg"; // Replace 'your_database' with your actual database name
        String username = "postgres"; // Replace 'username' with your actual username
        String password = "root"; // Replace 'password' with your actual password

        try {
            // Establish connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute query to retrieve all columns from the DONAR table
            ResultSet resultSet = statement.executeQuery("SELECT * FROM college");

            // Get ResultSetMetaData
            ResultSetMetaData metaData = resultSet.getMetaData();

            // Get the number of columns in the ResultSet
            int columnCount = metaData.getColumnCount();

            // Display column information
            System.out.println("Column Information for DONAR table:");
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                String columnType = metaData.getColumnTypeName(i);
                int columnSize = metaData.getColumnDisplaySize(i);
                System.out.println("Column Name: " + columnName);
                System.out.println("Column Type: " + columnType);
                System.out.println("Column Size: " + columnSize);
                System.out.println("---------------------------");
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
