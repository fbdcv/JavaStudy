package lesson03;

import javax.swing.*;
import java.awt.*;

public class TestJPasswordField extends JFrame {

    public TestJPasswordField() {
        Container container= this.getContentPane();

        JPasswordField jPasswordField = new JPasswordField();
        jPasswordField.setEchoChar('*');
        jPasswordField.setText("Hello,World!");

        container.add(jPasswordField,BorderLayout.NORTH);


        this.setBounds(400,400,200,200);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestJPasswordField();
    }
}
