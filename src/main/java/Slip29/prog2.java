/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Slip29;
import java.util.LinkedList;

public class prog2 {

    public static void main(String[] args) {
        // Create a LinkedList of Integer objects
        LinkedList<Integer> linkedList = new LinkedList<>();

        // i. Add element at the first position
        linkedList.addFirst(10);
        linkedList.addFirst(20);
        linkedList.addFirst(30);

        // ii. Delete last element
        if (!linkedList.isEmpty()) {
            linkedList.removeLast();
            System.out.println("Last element deleted successfully.");
        } else {
            System.out.println("The list is already empty.");
        }

        // iii. Display the size of the linked list
        System.out.println("Size of the linked list: " + linkedList.size());
    }
}

