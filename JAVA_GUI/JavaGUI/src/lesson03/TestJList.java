package lesson03;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class TestJList extends JFrame {
    public TestJList() {
        Container container= this.getContentPane();

        Vector<String> vector = new Vector<String>();
        JList<String> jList = new JList<String>(vector);
        vector.add("1");
        vector.add("2");
        vector.add("3");

        container.add(jList);

        this.setBounds(400,400,200,200);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestJList();
    }
}
