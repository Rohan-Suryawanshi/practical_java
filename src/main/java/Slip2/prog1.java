
package Slip2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class prog1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> friendNames = new HashSet<>();

        System.out.print("Enter the number of friends (N): ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter the names of your friends:");

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            friendNames.add(name);
        }

        // Convert HashSet to TreeSet to get names in ascending order
        TreeSet<String> sortedNames = new TreeSet<>(friendNames);

        System.out.println("\nYour friends' names in ascending order:");
        for (String name : sortedNames) {
            System.out.println(name);
        }
    }
}

