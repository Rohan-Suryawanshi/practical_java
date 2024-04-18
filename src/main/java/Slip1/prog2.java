/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Slip1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class prog2 extends JFrame {
    private JTextField enoField;
    private JTextField enameField;
    private JTextField designationField;
    private JTextField salaryField;
    private JButton submitButton;

    public prog2() {
        setTitle("Employee Details Form");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create text fields
        enoField = new JTextField(10);
        enameField = new JTextField(20);
        designationField = new JTextField(20);
        salaryField = new JTextField(10);

        // Create submit button
        submitButton = new JButton("Submit");

        // Add action listener to submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitEmployeeDetails();
            }
        });

        // Create labels
        JLabel enoLabel = new JLabel("Employee No:");
        JLabel enameLabel = new JLabel("Employee Name:");
        JLabel designationLabel = new JLabel("Designation:");
        JLabel salaryLabel = new JLabel("Salary:");

        // Create panel
        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(enoLabel);
        panel.add(enoField);
        panel.add(enameLabel);
        panel.add(enameField);
        panel.add(designationLabel);
        panel.add(designationField);
        panel.add(salaryLabel);
        panel.add(salaryField);
        panel.add(submitButton);

        // Add panel to content pane
        Container contentPane = getContentPane();
        contentPane.add(panel);
    }

    // Method to submit employee details to database
    private void submitEmployeeDetails() {
        String url = "jdbc:postgresql://localhost:5432/your_database"; // Replace 'your_database' with your actual database name
        String username = "username"; // Replace 'username' with your actual username
        String password = "password"; // Replace 'password' with your actual password

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Create SQL query to insert employee details
            String sql = "INSERT INTO Employee (Eno, EName, Designation, Salary) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(enoField.getText()));
            statement.setString(2, enameField.getText());
            statement.setString(3, designationField.getText());
            statement.setDouble(4, Double.parseDouble(salaryField.getText()));

            // Execute the query
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Employee details inserted successfully!");
                // Clear fields after successful insertion
                clearFields();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error inserting employee details: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to clear input fields
    private void clearFields() {
        enoField.setText("");
        enameField.setText("");
        designationField.setText("");
        salaryField.setText("");
    }

    public static void main(String[] args) {
            prog2 form = new prog2();
            form.setVisible(true);
    }
}
