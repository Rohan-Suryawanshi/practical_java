/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Slip6;

import java.util.*;

public class prog1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> numbers = new TreeSet<>(); // Using TreeSet to maintain sorted order and eliminate duplicates

        System.out.print("Enter the number of integers (n): ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        System.out.println("Enter the integers:");
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            numbers.add(num);
        }

        // Displaying sorted unique integers
        System.out.println("Sorted unique integers:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Searching for a particular element
        System.out.print("Enter the integer to search: ");
        int searchNum = scanner.nextInt();
        if (numbers.contains(searchNum)) {
            System.out.println(searchNum + " found in the collection.");
        } else {
            System.out.println(searchNum + " not found in the collection.");
        }

        scanner.close();
    }
}
