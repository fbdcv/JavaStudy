package lesson01;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Practice1 {
    public static void main(String[] args) {
        Frame frame = new Frame();
        Panel panel1 = new Panel();
        Panel panel2 = new Panel();
        Panel panel3 = new Panel();
        Panel panel4 = new Panel();
        Panel panel5 = new Panel();
        Panel panel6 = new Panel();

        Button button1 = new Button("1");
        Button button2 = new Button("2");
        Button button3 = new Button("3");
        Button button4 = new Button("4");
        Button button5 = new Button("5");
        Button button6 = new Button("6");
        Button button7 = new Button("7");
        Button button8 = new Button("8");
        Button button9 = new Button("9");
        Button button10 = new Button("10");

        frame.setLayout(new GridLayout(2,3));
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel4);
        frame.add(panel5);
        frame.add(panel6);

        panel1.add(button1);

        panel2.setLayout(new GridLayout(2,1));
        panel2.add(button2);
        panel2.add(button3);

        panel3.add(button4);

        panel4.add(button5);

        panel5.setLayout(new GridLayout(2,2));
        panel5.add(button6);
        panel5.add(button7);
        panel5.add(button8);
        panel5.add(button9);

        panel6.add(button10);
        frame.setSize(400,400);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
