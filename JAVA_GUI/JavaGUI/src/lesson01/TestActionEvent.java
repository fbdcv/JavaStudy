package lesson01;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestActionEvent {
    public static void main(String[] args) {
        //按下按钮，触发一些事件
        Frame frame = new Frame();
        Button button = new Button();
        button.addActionListener(new MyActionListener());
        windowClose(frame);
        frame.add(button,BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    //封装后的关闭窗体的函数，该函数必须使用static修饰符修饰
    private static void windowClose(Frame frame){
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

//这里使用继承实现了接口，我们也可以使用匿名内部类或者lambda表达式实现接口
class MyActionListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("aaa");
    }
}