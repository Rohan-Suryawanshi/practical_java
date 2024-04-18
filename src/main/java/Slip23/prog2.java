/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Slip23;

import java.util.Scanner;

public class prog2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        scanner.close();

        VowelThread vowelThread = new VowelThread(input);
        vowelThread.start();
    }
}

class VowelThread extends Thread {
    private final String input;

    public VowelThread(String input) {
        this.input = input;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (isVowel(c)) {
                    System.out.println(c);
                    Thread.sleep(3000); // Sleep for 3 seconds
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }
}
