package lesson01;

import java.awt.*;

public class TestPaint {
    public static void main(String[] args) {
        new MyPaint();
    }
}

class MyPaint extends Frame{
    public MyPaint() {
        setBounds(400,400,400,400);
        setVisible(true);
    }
    //画笔，该函数会自发进行调用
    @Override
    public void paint(Graphics g) {
        //设置画笔颜色
        g.setColor(Color.red);
        //画一个空心矩形
        g.drawRect(50,50,100,100);
        //重新设置画笔颜色
        g.setColor(Color.ORANGE);
        //画一个实心圆形
        g.fillOval(150,150,100,100);
        //养成习惯，画笔用完，将他还原到最初的颜色，防止下次画笔使用上次画笔的颜色
    }
}