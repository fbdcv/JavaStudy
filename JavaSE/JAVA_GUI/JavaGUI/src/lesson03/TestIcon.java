package lesson03;

import javax.swing.*;
import java.awt.*;

public class TestIcon {
    public static void main(String[] args) {
        new MyIcon().init();
    }
}

class MyIcon extends JFrame implements Icon{
    int height,width;
    //在Java中如果自定义了构造方法则默认构造方法会被覆盖，所以这里为了方便main方法调用，又重载了一个无参的构造方法
    public MyIcon(){}
    public MyIcon(int height ,int width){
        this.height = height;
        this.width = width;
    }
    void init(){
        //通过构造器设置图标的大小
        MyIcon myIcon = new MyIcon(15,15);
        //将图标嵌入到jLabel中
        JLabel jLabel = new JLabel("icontest",myIcon,SwingConstants.CENTER);
        Container container = getContentPane();
        container.add(jLabel);
        container.setBackground(Color.ORANGE);

        this.setBounds(400,400,100,100);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }
    //实现Icon接口中的内容
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.fillOval(x,y,width,height);
    }

    @Override
    public int getIconWidth() {
        return width;
    }

    @Override
    public int getIconHeight() {
        return height;
    }
}