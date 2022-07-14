package lesson03;

import javax.swing.*;
import java.awt.*;

public class JFrameDemo {
    void init(){
        JFrame jFrame = new JFrame("这是一个JFrame窗口");
        //必须在JFrame的默认内嵌容器里面设置背景颜色，直接在JFrame上设置颜色不会有效果
        jFrame.getContentPane().setBackground(Color.ORANGE);
        jFrame.setBounds(400,400,400,400);
        jFrame.setVisible(true);
        //使用Swing写好的关闭事件
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //要使JLabel的内容居中Swing有特有的方式实现
        JLabel jLabel = new JLabel("狂神说Java",SwingConstants.CENTER);
        jFrame.add(jLabel);
    }
    public static void main(String[] args) {
            new JFrameDemo().init();

    }
}
