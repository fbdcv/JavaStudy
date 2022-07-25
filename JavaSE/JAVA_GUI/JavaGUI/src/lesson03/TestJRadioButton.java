package lesson03;

import javax.swing.*;
import java.awt.*;

public class TestJRadioButton extends JFrame {

    public TestJRadioButton() {
        Container container= this.getContentPane();

        JRadioButton radioButton1 = new JRadioButton("单选框1");
        JRadioButton radioButton2 = new JRadioButton("单选框2");
        JRadioButton radioButton3 = new JRadioButton("单选框3");
        //指定组，否则起不到单选的作用
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        buttonGroup.add(radioButton3);
        //需设置布局，不然会出错
        container.add(radioButton1,BorderLayout.NORTH);
        container.add(radioButton2,BorderLayout.CENTER);
        container.add(radioButton3,BorderLayout.SOUTH);

        this.setBounds(400,400,200,200);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new TestJRadioButton();
    }
}