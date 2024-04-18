/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Slip21;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class prog1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a LinkedList to store subject names
        LinkedList<String> subjects = new LinkedList<>();

        System.out.print("Enter the number of subjects (N): ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter the subject names:");

        // Input subject names from the user and add them to the LinkedList
        for (int i = 0; i < n; i++) {
            String subject = scanner.nextLine();
            subjects.add(subject);
        }

        // Display the subject names using Iterator interface
        System.out.println("Subject names:");

        Iterator<String> iterator = subjects.iterator();
        while (iterator.hasNext()) {
            String subject = iterator.next();
            System.out.println(subject);
        }

        scanner.close();
    }
}

