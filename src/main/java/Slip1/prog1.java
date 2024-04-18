//Write a Java program to display all the alphabets between ‘A’ to ‘Z’ after every 2 seconds
package Slip1;

class PrintCharacter extends Thread {

    char ch = 'A';

    public void run() {
        while(ch<='Z') {
            System.out.println(ch);
            try{
                Thread.sleep(2000);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            ch++;
        }
    }

}

public class prog1 {
    public static void main(String args[])
    {
        PrintCharacter p = new PrintCharacter();
        p.start();
    }
}
