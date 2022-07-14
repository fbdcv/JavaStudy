package lesson02;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestWindowListener {
    public static void main(String[] args) {
        new MyWindow();
    }
}
class MyWindow extends Frame{
    public  MyWindow(){
        setBackground(Color.blue);
        setBounds(400,400,400,400);
        addWindowListener(new MyWinodwListener());
        setVisible(true);
    }
    //自建的窗口监听类，继承了一个窗口监听的抽象类（适配器），实现了监听窗口关闭与窗口激活的方法
    private class MyWinodwListener extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e) {
            System.out.println("windowClosing");
        }

        @Override
        public void windowActivated(WindowEvent e) {
            System.out.println("windowActivated");
        }
    }

}