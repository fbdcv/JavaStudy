package lesson02;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TestKeyListener {
    public static void main(String[] args) {
        new MyKeyWindow();
    }
}
class MyKeyWindow extends Frame {
    public MyKeyWindow() {
        setBounds(400, 400, 400, 400);
        addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    System.out.println("按下了上键");
                }
            }
        });
        setVisible(true);
    }

}