
package Slip15;

import Slip18.*;

class ThreadInfo extends Thread {
    public void run() {
        // Display the name of the thread
        System.out.println("Thread name: " + getName());

        // Display the priority of the thread
        System.out.println("Thread priority: " + getPriority());
    }
}

public class prog1 {
    public static void main(String[] args) {
        // Create an instance of the ThreadInfo class
        ThreadInfo thread = new ThreadInfo();

        // Start the thread
        thread.start();
    }
}
