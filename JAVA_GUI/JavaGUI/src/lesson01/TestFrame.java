package lesson01;

import java.awt.*;
//GUI 的第一个界面
public class TestFrame {
    public static void main(String[] args) {

        //ctrl+鼠标左键 看源码，展开结构图看构造器的重载方法
        Frame frame= new Frame("我的第一个Java图形界面窗口");//此时看不见，在内存中
        //设置可见性
        frame.setVisible(true);
        //设置窗口大小
        frame.setSize(400,400);
        //设置背景颜色
        frame.setBackground(new Color(167, 57, 57));
        //弹出初始位置
        frame.setLocation(200,200);
        //设置大小固定
        frame.setResizable(false);

    }
}
