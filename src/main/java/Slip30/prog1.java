/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Slip30;
class Counter {
    private int count = 0;

    // Synchronized method to increment the count
    public synchronized void increment() {
        count++;
    }

    // Synchronized method to decrement the count
    public synchronized void decrement() {
        count--;
    }

    // Synchronized method to get the count
    public synchronized int getCount() {
        return count;
    }
}

class IncrementThread extends Thread {
    private Counter counter;

    public IncrementThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

class DecrementThread extends Thread {
    private Counter counter;

    public DecrementThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.decrement();
        }
    }
}

public class prog1 {
    public static void main(String[] args) {
        Counter counter = new Counter();

        // Create multiple threads to increment and decrement the counter
        IncrementThread incrementThread1 = new IncrementThread(counter);
        DecrementThread decrementThread1 = new DecrementThread(counter);
        IncrementThread incrementThread2 = new IncrementThread(counter);
        DecrementThread decrementThread2 = new DecrementThread(counter);

        // Start the threads
        incrementThread1.start();
        decrementThread1.start();
        incrementThread2.start();
        decrementThread2.start();

//        try {
//            // Wait for threads to finish
//            incrementThread1.join();
//            decrementThread1.join();
//            incrementThread2.join();
//            decrementThread2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        // Print the final count
        System.out.println("Final Count: " + counter.getCount());
    }
}
