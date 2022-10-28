import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Data {
    public static URL headerurl = Data.class.getResource("statics/header.png"); //这里还使用了反射机制
    public static ImageIcon header = new ImageIcon(headerurl);
    public static URL upurl = Data.class.getResource("statics/up.png"); //这里还使用了反射机制
    public static ImageIcon up = new ImageIcon(upurl);
    public static URL downurl = Data.class.getResource("statics/down.png"); //这里还使用了反射机制
    public static ImageIcon down = new ImageIcon(downurl);
    public static URL lefturl = Data.class.getResource("statics/left.png"); //这里还使用了反射机制
    public static ImageIcon left = new ImageIcon(lefturl);
    public static URL righturl = Data.class.getResource("statics/right.png"); //这里还使用了反射机制
    public static ImageIcon right = new ImageIcon(righturl);
    public static URL bodyurl = Data.class.getResource("statics/body.png"); //这里还使用了反射机制
    public static ImageIcon body = new ImageIcon(bodyurl);
    public static URL foodurl = Data.class.getResource("statics/food.png"); //这里还使用了反射机制
    public static ImageIcon food = new ImageIcon(foodurl);

}
