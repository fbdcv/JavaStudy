package lesson03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TestJDialog {
    public static void main(String[] args) {
        new MyJDialog();
    }
}

class MyJDialog extends JFrame {
    public MyJDialog() {
        super("测试对话框");
        setBounds(400,400,400,400);
        getContentPane().setBackground(Color.ORANGE);
        JButton jButton = new JButton("点我弹出对话框");
        //设置JButton的点击事件
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowJDialog();
            }
        });
        //绝对布局
        setLayout(null);
        jButton.setBounds(50,50,300,300);
        add(jButton);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


    }
    void ShowJDialog (){
        JDialog jDialog = new JDialog();
        jDialog.setBounds(600,600,100,100);
        jDialog.add(new JLabel("对话框",SwingConstants.CENTER));
        jDialog.setVisible(true);
    }
}