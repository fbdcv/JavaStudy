package lesson01;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestActionTwo {
    public static void main(String[] args) {
        //两个按钮，使用同一个事件监听
        Frame frame = new Frame();
        Button button1 = new Button("start");
        Button button2 = new Button("stop");
        //设置按钮信息，如果不自行设置的化使用按钮的默认值（按钮的label）
        button1.setActionCommand("start——111");

        button1.addActionListener(new MyMonitor());
        button2.addActionListener(new MyMonitor());

        frame.add(button1,BorderLayout.NORTH);
        frame.add(button2,BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }
}

class MyMonitor implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        //获得的按钮信息，根据按钮信息可以达到特异性识别按钮的效果
        System.out.println("按钮被点击"+e.getActionCommand());
        if(e.getActionCommand().equals("stop")){
            System.out.println("结束");
        }else{
            System.out.println("开始");
        }
    }
}
