package lesson01;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//Panel可以看成一个不能单独存在的空间
public class TestPanel {
    public static void main(String[] args) {
        //在idea中ctrl+alt+v快捷键实现快速实例化
        Frame frame = new Frame();
        //在面板中有布局的概念
        Panel panel = new Panel();
        //设置布局,不设置的话panel会完全覆盖frame的内部窗口
        frame.setLayout(null);
        frame.setBounds(300,300,500,500);
        frame.setBackground(Color.GREEN);

        //面板位置相对于frame
        panel.setBounds(50,50,400,400);
        panel.setBackground(Color.ORANGE);

        frame.add(panel);
        frame.setVisible(true);

        //设置监听事件，监听窗口关闭事件 System.exit(0)
        //适配器模式：使用接口要实现该接口的所有方法（匿名内部类），但我们只想使用接口中的一个方法
        //我们可以写一个抽象类来继承这个接口，然后将其他方法默认实现，留下一个我们想要实现的抽象方法，给我们特异化实现
        frame.addWindowListener(new WindowAdapter() {
            //点击窗口关闭时的事件
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
