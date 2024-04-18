/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Slip5;
import java.util.Enumeration;
import java.util.Hashtable;

public class prog1 {

    public static void main(String[] args) {
        // Create a hash table to maintain mobile numbers and student names
        Hashtable<String, String> studentTable = new Hashtable<>();

        // Adding some sample data
        studentTable.put("1234567890", "John Doe");
        studentTable.put("9876543210", "Alice Smith");
        studentTable.put("5555555555", "Bob Johnson");

        // Display the details of students using Enumeration interface
        displayStudentDetails(studentTable);
    }

    // Method to display student details using Enumeration
    public static void displayStudentDetails(Hashtable<String, String> studentTable) {
        System.out.println("Student Details:");
        System.out.println("----------------");
        
        // Get an enumeration of all the keys in the hash table
        Enumeration<String> mobileNumbers = studentTable.keys();

        // Iterate through the enumeration and display details
        while (mobileNumbers.hasMoreElements()) {
            String mobileNumber = mobileNumbers.nextElement();
            String studentName = studentTable.get(mobileNumber);
            System.out.println("Mobile Number: " + mobileNumber + ", Student Name: " + studentName);
        }
    }
}
