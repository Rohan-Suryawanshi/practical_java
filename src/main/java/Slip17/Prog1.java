
package Slip17;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class NumberPrinter implements Runnable {
    private JTextField textField;

    public NumberPrinter(JTextField textField) {
        this.textField = textField;
    }

    public void run() {
        int number = 1;
        while (number <= 100) {
            textField.setText(Integer.toString(number));
            number++;
            try {
                Thread.sleep(100); // Adjust sleep time as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Prog1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Number Printer");
        frame.setSize(500, 500);
        JTextField textField = new JTextField(10);
        JButton startButton = new JButton("Start");

        NumberPrinter numberPrinter = new NumberPrinter(textField);
        Thread printerThread = new Thread(numberPrinter);


        startButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread printerThread = new Thread(numberPrinter);
                printerThread.start();
            }
        
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.add(textField);
        frame.add(startButton);
        frame.setVisible(true);
    }
}
