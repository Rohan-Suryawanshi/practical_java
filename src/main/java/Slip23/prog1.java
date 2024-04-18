/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Slip23;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class prog1 {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java StudentNames <name1> <name2> ... <nameN>");
            return;
        }

        // Create an ArrayList to store student names
        List<String> studentNames = new ArrayList<>();

        // Store student names from command line arguments into the ArrayList
        for (String arg : args) {
            studentNames.add(arg);
        }

        // Display student names using Iterator interface
        System.out.println("Student names (using Iterator):");
        displayNamesWithIterator(studentNames);

        // Display student names using ListIterator interface
        System.out.println("\nStudent names (using ListIterator):");
        displayNamesWithListIterator(studentNames);
    }

    // Method to display student names using Iterator interface
    private static void displayNamesWithIterator(List<String> studentNames) {
        Iterator<String> iterator = studentNames.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    // Method to display student names using ListIterator interface
    private static void displayNamesWithListIterator(List<String> studentNames) {
        ListIterator<String> listIterator = studentNames.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
    }
}

