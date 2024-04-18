
package Slip8;
class PrintThread extends Thread {
    private String text;
    private int times;

    public PrintThread(String text, int times) {
        this.text = text;
        this.times = times;
    }

    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.println(text);
            try {
                Thread.sleep(100); // Adding some delay for better visualization
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class prog1 {
    public static void main(String[] args) {
        PrintThread thread1 = new PrintThread("COVID19", 10);
        PrintThread thread2 = new PrintThread("LOCKDOWN2020", 20);
        PrintThread thread3 = new PrintThread("VACCINATED2021", 30);

   
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
