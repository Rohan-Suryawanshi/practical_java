
package Slip27;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class prog1 extends JFrame {
    private DefaultTableModel tableModel;

    public prog1() {
        setTitle("College Details");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Column names
        String[] columns = {"CID", "CName", "Address", "Year"};

        // Creating table model without data
        tableModel = new DefaultTableModel(columns, 0);

        // Creating JTable
        JTable table = new JTable(tableModel);
       // table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        // Adding table to scroll pane
        JScrollPane scrollPane = new JScrollPane(table);

        // Adding scroll pane to frame
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Fetch data from PostgreSQL database and populate the table
        fetchDataFromDatabase();
    }

    private void fetchDataFromDatabase() {
        try {
            // Connect to the PostgreSQL database
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/msg", "postgres", "root");

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute query to fetch college details
            ResultSet resultSet = statement.executeQuery("SELECT cid, cname, address, year FROM college");

            // Add rows to the table model
            while (resultSet.next()) {
                String cid = resultSet.getString("cid");
                String cname = resultSet.getString("cname");
                String address = resultSet.getString("address");
                String year = resultSet.getString("year");
                tableModel.addRow(new String[]{cid, cname, address, year});
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
            prog1 gui = new prog1();
            gui.setVisible(true);
   
    }
}
