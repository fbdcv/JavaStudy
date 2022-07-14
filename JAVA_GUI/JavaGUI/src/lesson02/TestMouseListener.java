package lesson02;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class TestMouseListener {
    public static void main(String[] args) {
        new MyFrame("画点");
    }
}
class MyFrame extends Frame{
    //存储点
    ArrayList<Point> points;
    public  MyFrame(String title){
        super(title);
        setBounds(400,400,400,400);
        points = new ArrayList<>();
        addMouseListener(new MyMouseListener());
        setVisible(true);
    }

    //显示点
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.blue);
        for (Point point : points) {
            g.fillOval(point.x,point.y,10,10);
        }
    }

    //鼠标事件，用于收集点
    private  class MyMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            points.add(new Point(e.getX(),e.getY()));
            repaint();
        }
    }

}
