/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Slip4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class prog2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> citySTDMap = new HashMap<>();

        // Initial city names and STD codes
        citySTDMap.put("New York", "212");
        citySTDMap.put("London", "20");
        citySTDMap.put("Tokyo", "81");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a new city and its STD code");
            System.out.println("2. Remove a city from the collection");
            System.out.println("3. Search for a city name and display the code");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addCitySTD(scanner, citySTDMap);
                    break;
                case 2:
                    removeCity(scanner, citySTDMap);
                    break;
                case 3:
                    searchCity(scanner, citySTDMap);
                    break;
                case 4:
                    System.out.println("Exiting the program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }

    // Method to add a new city and its STD code
    public static void addCitySTD(Scanner scanner, Map<String, String> citySTDMap) {
        System.out.print("Enter the city name: ");
        String city = scanner.nextLine();
        System.out.print("Enter the STD code: ");
        String stdCode = scanner.nextLine();

        if (!citySTDMap.containsKey(city)) {
            citySTDMap.put(city, stdCode);
            System.out.println("City and STD code added successfully.");
        } else {
            System.out.println("City already exists. Cannot add duplicate city.");
        }
    }

    // Method to remove a city from the collection
    public static void removeCity(Scanner scanner, Map<String, String> citySTDMap) {
        System.out.print("Enter the city name to remove: ");
        String city = scanner.nextLine();

        if (citySTDMap.containsKey(city)) {
            citySTDMap.remove(city);
            System.out.println("City removed successfully.");
        } else {
            System.out.println("City not found in the collection.");
        }
    }

    // Method to search for a city name and display the STD code
    public static void searchCity(Scanner scanner, Map<String, String> citySTDMap) {
        System.out.print("Enter the city name to search: ");
        String city = scanner.nextLine();

        if (citySTDMap.containsKey(city)) {
            System.out.println("STD code for " + city + " is " + citySTDMap.get(city));
        } else {
            System.out.println("City not found in the collection.");
        }
    }
}

