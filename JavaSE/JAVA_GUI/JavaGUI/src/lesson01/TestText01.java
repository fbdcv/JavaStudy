package lesson01;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestText01 {
    public static void main(String[] args) {
        //main方法一般只有启动
        new MyFrame2();
    }
}

class MyFrame2 extends Frame{
    public MyFrame2(){
        TextField textField = new TextField();
        add(textField);
        //监听文本框输入的文字,按下回车键会触发这个输入框的事件
        textField.addActionListener(new MyActionListener2());
        //设置替换编码
        textField.setEchoChar('*');
        pack();
        setVisible(true);
    }
}


class MyActionListener2 implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        //通过向下转型与强转将object 转换为TextField
        TextField textField =(TextField) e.getSource();//getSource返回一个object对象
        System.out.println(textField.getText());
        textField.setText("");//获得信息后清空文本
    }
}
