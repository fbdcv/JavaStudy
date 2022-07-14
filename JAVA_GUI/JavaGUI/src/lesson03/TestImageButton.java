package lesson03;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class TestImageButton extends JFrame {
    public TestImageButton(){
        Container container = this.getContentPane();

        URL resource = TestImageButton.class.getResource("tx.jpeg");
        Icon icon = new ImageIcon(resource);

        //注意按钮上放图标用特有的方法setIcon而非add
        JButton jButton = new JButton();
        jButton.setIcon(icon);

        container.add(jButton);

        this.setBounds(400,400,500,500);
        this.setVisible(true);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {
        new TestImageButton();
    }
}
