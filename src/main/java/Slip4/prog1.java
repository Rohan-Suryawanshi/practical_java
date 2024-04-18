//Write a Java program using Runnable interface to blink Text on the frame
package Slip4;

import javax.swing.*;
import java.awt.*;
class MyFrame extends JFrame
{
    JLabel text;
    MyFrame(){
        this.setTitle("My Frame");
        this.setSize(500,500);
        this .setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        text=new JLabel("Rohan");
        this.add(text);
        this.setVisible(true);
    }
    public JLabel getLabel()
    {
        return text;
    }
}
class BlinkText implements Runnable
{
    JLabel text;
    BlinkText(JLabel text)
    {
        this.text=text;
    }
    @Override
    public void run()
    {
        while(true)
        {
            text.setVisible(true);
            try{
                Thread.sleep(1000);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            text.setVisible(false);
            try{
                Thread.sleep(1000);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }
}
public class prog1 {
    public static void main(String args[])
    {
        MyFrame f=new MyFrame();
        JLabel text=f.getLabel();
        BlinkText bt=new BlinkText(text);
        Thread t=new Thread(bt);
        t.start();
    }
}
