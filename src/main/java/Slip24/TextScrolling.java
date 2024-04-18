/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Slip24;

public class TextScrolling {
    public static void main(String[] args) {
        // Text to be scrolled
        String text = "Hello, world! This is a scrolling text.";

        // Infinite loop for continuous scrolling
        while (true) {
            // Print the text at different positions to create scrolling effect
            for (int i = 0; i < 80; i++) {
                clearConsole(); // Clear console screen
                printTextAtPosition(text, i); // Print text at current position
                try {
                    Thread.sleep(100); // Delay for smooth scrolling (adjust as needed)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Method to print text at a specific position
    private static void printTextAtPosition(String text, int position) {
        for (int i = 0; i < position; i++) {
            System.out.print(" "); // Print spaces to shift text position
        }
        System.out.print(text); // Print text at shifted position
    }

    // Method to clear console screen
    private static void clearConsole() {
        // ANSI escape code to clear console screen
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

