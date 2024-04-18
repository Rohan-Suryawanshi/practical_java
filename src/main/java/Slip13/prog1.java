package Slip13;

import java.util.Random;

class LifecycleThread extends Thread {
    private Random random;
    private String threadName;

    public LifecycleThread(String threadName) {
        this.threadName = threadName;
        this.random = new Random();
    }

    public void run() {
        System.out.println(threadName + " created.");
        
        int sleepTime = random.nextInt(5000); // random sleep time between 0 and 4999 milliseconds
        System.out.println(threadName + " will sleep for " + sleepTime + " milliseconds.");
        
        try {
            Thread.sleep(sleepTime); // sleep for random duration
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(threadName + " dead.");
    }
}

public class prog1 {
    public static void main(String[] args) {
        // Create and start three threads
        LifecycleThread thread1 = new LifecycleThread("Thread 1");
        LifecycleThread thread2 = new LifecycleThread("Thread 2");
        LifecycleThread thread3 = new LifecycleThread("Thread 3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
