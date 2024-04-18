/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Slip17;

import java.util.Scanner;
import java.util.TreeSet;

public class prog2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a TreeSet to store integers in sorted order and eliminate duplicates
        TreeSet<Integer> numbers = new TreeSet<>();

        System.out.print("Enter the number of integers (N): ");
        int n = scanner.nextInt();

        System.out.println("Enter the integers:");

        // Input integers from the user and add them to the TreeSet
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            numbers.add(num);
        }

        // Display the sorted integers
        System.out.println("Sorted unique integers:");
        for (int num : numbers) {
            System.out.println(num);
        }

        scanner.close();
    }
}
