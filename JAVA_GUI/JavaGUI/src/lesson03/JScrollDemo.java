package lesson03;

import javax.swing.*;
import java.awt.*;

public class JScrollDemo extends JFrame {
    public JScrollDemo(){
        Container container = getContentPane();
        //文本域
        JTextArea  jTextArea = new JTextArea(20,50);
        jTextArea.setText("狂神说Java");
        //创建带滚动条的面板将文本域插入面板中
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        container.add(jScrollPane);
        //设置JFrame的属性
        this.setBounds(400,400,400,400);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }
    public static void main(String[] args) {
        new JScrollDemo();
    }
}

