package lesson03;

import javax.swing.*;
import java.awt.*;

public class TestJCheckBox extends JFrame{

    public TestJCheckBox() {
        Container container= this.getContentPane();

        JCheckBox jCheckBox1 = new JCheckBox("多选框1");
        JCheckBox jCheckBox2 = new JCheckBox("多选框2");
        JCheckBox jCheckBox3 = new JCheckBox("多选框3");
        //需设置布局，不然会出错
        container.add(jCheckBox1,BorderLayout.NORTH);
        container.add(jCheckBox2,BorderLayout.CENTER);
        container.add(jCheckBox3,BorderLayout.SOUTH);


        this.setBounds(400,400,200,200);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestJCheckBox();
    }
}
