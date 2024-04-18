/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Slip19;

import java.util.LinkedList;
import java.util.Scanner;

public class prog1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a LinkedList to store integers
        LinkedList<Integer> numbers = new LinkedList<>();

        System.out.print("Enter the number of integers (N): ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter the integers:");

        // Input integers from the user and add them to the LinkedList
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            numbers.add(num);
        }

        // Display only the negative integers from the LinkedList
        System.out.println("Negative integers:");
        for (int num : numbers) {
            if (num < 0) {
                System.out.println(num);
            }
        }

        scanner.close();
    }
}

