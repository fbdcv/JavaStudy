package lesson01;

import java.awt.*;

public class TestFrame2 {
    public static void main(String[] args) {
        //展示多个窗口
        MyFrame myFrame1 = new MyFrame(100,100,200,200,Color.BLACK);
        MyFrame myFrame2 = new MyFrame(300,100,200,200,Color.RED);
        MyFrame myFrame3 = new MyFrame(100,300,200,200,Color.GREEN);
        MyFrame myFrame4 = new MyFrame(300,300,200,200,Color.BLUE);
    }
}

class MyFrame extends Frame{
    static  int id =0;//设置一个类变量做记数器
    public MyFrame(int x,int y,int w,int h,Color color){
        super("Myframe"+(++id));
        setBounds(x,y,w,h);
        setBackground(color);
        setVisible(true);
    }
}
