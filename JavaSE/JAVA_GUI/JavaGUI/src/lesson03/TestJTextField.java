package lesson03;

import javax.swing.*;
import java.awt.*;

public class TestJTextField extends JFrame {

    public TestJTextField()  {
        Container container= this.getContentPane();

        JTextField jTextField = new JTextField();
        jTextField.setText("Hello,World!");

        container.add(jTextField,BorderLayout.NORTH);


        this.setBounds(400,400,200,200);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestJTextField();
    }
}
