
package slip22;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class prog1 {

    // Database connection parameters
    static final String DB_URL = "jdbc:postgresql://localhost:5432/Employee";
    static final String USER = "postgres";
    static final String PASS = "root";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Insert");
            System.out.println("2. Update");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    insertEmployee();
                    break;
                case 2:
                    updateEmployee();
                    break;
                case 3:
                    displayEmployees();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } while (choice != 4);

        scanner.close();
    }

    static void insertEmployee() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO Employee(ENo, EName, Salary) VALUES (?, ?, ?)")) {

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Employee Number: ");
            int eno = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter Employee Name: ");
            String ename = scanner.nextLine();
            System.out.print("Enter Salary: ");
            double salary = scanner.nextDouble();

            stmt.setInt(1, eno);
            stmt.setString(2, ename);
            stmt.setDouble(3, salary);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Employee inserted successfully.");
            } else {
                System.out.println("Failed to insert employee.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void updateEmployee() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement("UPDATE Employee SET EName = ?, Salary = ? WHERE ENo = ?")) {

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Employee Number to update: ");
            int eno = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter new Employee Name: ");
            String ename = scanner.nextLine();
            System.out.print("Enter new Salary: ");
            double salary = scanner.nextDouble();

            stmt.setString(1, ename);
            stmt.setDouble(2, salary);
            stmt.setInt(3, eno);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Employee updated successfully.");
            } else {
                System.out.println("Failed to update employee. Employee not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void displayEmployees() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Employee");
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("\nEmployee Table");
            System.out.println("ENo\tEName\tSalary");
            while (rs.next()) {
                int eno = rs.getInt("ENo");
                String ename = rs.getString("EName");
                double salary = rs.getDouble("Salary");
                System.out.println(eno + "\t" + ename + "\t" + salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

