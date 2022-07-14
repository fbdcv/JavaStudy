package lesson03;

import javax.swing.*;
import java.awt.*;

public class TestJTextArea extends JFrame {
    public TestJTextArea()  {
        Container container= this.getContentPane();

        JTextArea jTextArea = new JTextArea();
        jTextArea.setText("Hello,World!");

        container.add(jTextArea,BorderLayout.NORTH);



        this.setBounds(400,400,200,200);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestJTextArea();
    }
}
