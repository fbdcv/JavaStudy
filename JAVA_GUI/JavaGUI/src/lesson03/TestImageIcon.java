package lesson03;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class TestImageIcon {
    public static void main(String[] args) {
        new MyImageIcon().init();
    }
}

class MyImageIcon extends JFrame {
    void init() {
        //通过MyImageIcon这个类的路径来获得同同路径下其他资源的路径
        URL url = MyImageIcon.class.getResource("tx.jpeg");
        ImageIcon imageIcon = new ImageIcon(url);


        JLabel jLabel = new JLabel("ImageIcon",SwingConstants.CENTER);
        jLabel.setIcon(imageIcon);

        Container container = this.getContentPane();
        container.add(jLabel);

        setVisible(true);
        setBounds(400,400,500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }

}
