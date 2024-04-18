//Write a Java program using Runnable interface to blink Text on the frame
package Slip20;

import Slip4.*;
import javax.swing.*;
import java.awt.*;
class MyFrame extends JFrame
{
    JLabel text;
    MyFrame(){
        this.setTitle("My Frame");
        this.setSize(1280,303);
        this .setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        text=new JLabel(new ImageIcon("D:\\Practical\\src\\main\\java\\Slip20\\Main38.png"));
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
