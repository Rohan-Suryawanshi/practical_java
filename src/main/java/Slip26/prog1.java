package Slip26;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
//Write a Java program to accept the details of Teacher (TNo, TName, Subject). Insert at
//least 5 Records into Teacher Table and display the details of Teacher who is teaching
//“JAVA” Subject. (Use PreparedStatement Interface) 
public class prog1 {
    public static void main(String args[]) throws SQLException
    {
        int no;
        String name,subject;
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter the teacher number");
        no=sc.nextInt();
        sc.nextLine();
        
        System.out.println("Enter the teacher Name");
        name=sc.next();
        
        System.out.println("Enter the teacher Subject");
        subject=sc.next();
        
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/msg", "postgres", "root");
        PreparedStatement prep=con.prepareStatement("INSERT INTO teacher(no, name, subject) VALUES (?, ?, ?);");
        prep.setInt(1, no);
        prep.setString(2, name);
        prep.setString(3, subject);
        
        int rowsAffected = prep.executeUpdate();
        if(rowsAffected > 0) {
            System.out.println("Data Entered Successfully");
        } else {
            System.out.println("Failed to Enter Data");
        }
        
        PreparedStatement selectStmt = con.prepareStatement("SELECT * FROM teacher WHERE subject = ?");
        selectStmt.setString(1, "Java");
        ResultSet rs = selectStmt.executeQuery();
        
        System.out.println("Teachers teaching 'JAVA' subject:");
        while (rs.next()) {
            System.out.println("Teacher Number: " + rs.getInt("no"));
            System.out.println("Teacher Name: " + rs.getString("name"));
            System.out.println("Teacher Subject: " + rs.getString("subject"));
            System.out.println();
        }

        // Close resources
        rs.close();
        selectStmt.close();
        prep.close();
        con.close();
        
        
        
        
    }
}
