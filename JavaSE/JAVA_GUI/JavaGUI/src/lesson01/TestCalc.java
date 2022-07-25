package lesson01;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestCalc {
    public static void main(String[] args) {
        new Calculator();
    }
}

class Calculator extends Frame{
    TextField num1,num2,num3;
    public Calculator(){
        num1 = new TextField(10);//设置文本框的字符数
        num2 = new TextField(10);
        num3 = new TextField(20);

        Label plus = new Label("+");

        Button button = new Button("=");
        button.addActionListener(new MyCalculatorListener());
        setLayout(new FlowLayout());

        add(num1);
        add(plus);
        add(num2);
        add(button);
        add(num3);

        pack();
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

    private class MyCalculatorListener implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {
            //获取变量
            int n1 = Integer.parseInt(num1.getText());
            int n2 = Integer.parseInt(num2.getText());
            //实现计算
            num3.setText(""+(n1+n2));
            //清空文本域
            num1.setText("");
            num2.setText("");
        }
    }
}

