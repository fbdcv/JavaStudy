import javax.swing.JFrame;

public class StartGames {
    public static void main(String[] args) {
        JFrame frame = new JFrame("贪吃蛇");
        frame.setBounds(300, 300, 900, 720);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new GamePanel());
        frame.setVisible(true);
        
    }
}
