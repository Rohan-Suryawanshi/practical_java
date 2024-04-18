//Write a java program that implements a multi-thread application that has three threads. 
//First thread generates random integer number after every one second, if the number is 
//even; second thread computes the square of that number and print it. If the number is 
//odd, the third thread computes the of cube of that number and print it. 
package Slip7;

import java.util.Random;

class generateRandomNumber extends Thread {

    public void run() {
        Random rand = new Random();
        while (true) {
            int n = rand.nextInt(10);

            if (n % 2 == 0) {
                Square s = new Square(n);
                s.start();
            } else {
                Cube c = new Cube(n);
                c.start();
            }
            
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
               
            }
        }
    }
}

class Square extends Thread {

    int n;

    Square(int n) {
        this.n = n;
    }

    public void run() {
        System.out.println("Square is " + (n * n));
    }
}

class Cube extends Thread {

    int n;

    Cube(int n) {
        this.n = n;
    }

    public void run() {
        System.out.println("Cube is " + (n * n * n));
    }
}

public class prog1 {

    public static void main(String args[]) {
        generateRandomNumber r = new generateRandomNumber();
        r.start();
    }
}
