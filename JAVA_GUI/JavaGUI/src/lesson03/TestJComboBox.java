package lesson03;

import javax.swing.*;
import java.awt.*;

public class TestJComboBox extends JFrame {
    public TestJComboBox() {
        Container container= this.getContentPane();

        JComboBox<String> jComboBox = new JComboBox<>();
        jComboBox.addItem("正在上映");
        jComboBox.addItem("已下架");
        jComboBox.addItem("即将上映");

        container.add(jComboBox);



        this.setBounds(400,400,200,200);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestJComboBox();
    }
}
