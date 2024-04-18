//Write a java program to simulate traffic signal using thread
package Slip6;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class MyFrame extends JFrame {

    JLabel red, green, yellow;
    Container c;

    MyFrame() {
        this.setTitle("My Frame");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        red = new JLabel("");
        red.setBounds(200, 20, 100, 100);
        this.setContentPane(this.getContentPane());
        red.setBackground(Color.red);
        this.setLayout(null);
        red.setOpaque(true);

        green = new JLabel("");
        green.setBounds(200, 130, 100, 100);
        this.setContentPane(this.getContentPane());
        green.setBackground(Color.green);
        this.setLayout(null);
        green.setOpaque(true);

        yellow = new JLabel("");
        yellow.setBounds(200, 240, 100, 100);
        this.setContentPane(this.getContentPane());
        yellow.setBackground(Color.yellow);
        this.setLayout(null);
        yellow.setOpaque(true);

        this.add(red);
        this.add(green);
        this.add(yellow);
        this.setVisible(true);
    }

    public JLabel getRedLabel() {
        return red;
    }
    
     public JLabel getYellowLabel() {
        return yellow;
    }
     public JLabel getGreenLabel() {
        return green;
    }
}
class changeColor extends Thread{
    JLabel red,green,yellow;
    changeColor(JLabel red,JLabel green,JLabel yellow)
    {
        this.red=red;
        this.green=green;
        this.yellow=yellow;
    }
    public void run()
    {
        while(true)
        {
            red.setBackground(Color.red);
            green.setBackground(Color.black);
            yellow.setBackground(Color.BLACK);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                
            }
            
            red.setBackground(Color.BLACK);
            green.setBackground(Color.green);
            yellow.setBackground(Color.BLACK);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                
            }
            
            red.setBackground(Color.BLACK);
            green.setBackground(Color.BLACK);
            yellow.setBackground(Color.yellow);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                
            }
        }
    }
}
public class prog2 {

    public static void main(String args[]) {
        MyFrame f = new MyFrame();
        JLabel redLabel = f.getRedLabel();
        JLabel yellowLabel = f.getYellowLabel();
        JLabel greenLabel = f.getGreenLabel();
        changeColor c=new changeColor(redLabel,greenLabel,yellowLabel);
        c.start();
       
    }
}
