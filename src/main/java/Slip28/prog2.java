package Slip28;


class CurrentThreadNamePrinter implements Runnable {
    public void run() {
        System.out.println("Currently executing thread: " + Thread.currentThread().getName());
    }
}

public class prog2 {
    public static void main(String[] args) {
        Thread thread = new Thread(new CurrentThreadNamePrinter());
        thread.start();
    }
}
