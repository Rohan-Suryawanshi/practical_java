/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Slip3;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class prog2 {

    public static void main(String[] args) {
        // Create a LinkedList of String objects
        LinkedList<String> linkedList = new LinkedList<>();

        // i. Add elements at the end of the list
        linkedList.add("Element 1");
        linkedList.add("Element 2");
        linkedList.add("Element 3");

        System.out.println("Initial contents of the list:");
        displayList(linkedList);

        // ii. Delete the first element of the list
        if (!linkedList.isEmpty()) {
            linkedList.removeFirst();
            System.out.println("\nAfter deleting the first element:");
            displayList(linkedList);
        } else {
            System.out.println("\nThe list is already empty.");
        }

        // iii. Display the contents of the list in reverse order
        System.out.println("\nContents of the list in reverse order:");
        displayReverseList(linkedList);
    }

    // Method to display contents of a list
    public static void displayList(List<String> list) {
        for (String element : list) {
            System.out.println(element);
        }
    }

    // Method to display contents of a list in reverse order
    public static void displayReverseList(List<String> list) {
        ListIterator<String> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }
}

