import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel implements KeyListener, ActionListener  {

    int length;
    int score;
    int[] snakeX = new int[600];
    int[] snakeY = new int[600];
    String fx;
    int foodx;
    int foody;
    Random random = new Random();
    boolean isStart;
    boolean isFail;
    Timer timer = new Timer(100,this);
    public GamePanel(){
        init();
        this.setFocusable(true);
        this.addKeyListener(this);
        timer.start();
    }

    //初始化
    public void init(){
        fx = "R";
        isStart = false; 
        isFail = false;
        length = 3;
        score = 0;
        snakeX[0] = 100; snakeY[0] = 100;
        snakeX[1] = 75;  snakeY[1] = 100;
        snakeX[2] = 50;  snakeY[2] = 100;
        foodx = 50+25*random.nextInt(32);
        foody = 100+25*random.nextInt(22);


    }

    //画图
    @Override
    protected void paintComponent(Graphics g) {
        //g可理解为画笔工具
        super.paintComponent(g);//清屏
        this.setBackground(Color.BLACK);

        //在GamePanel上显示header
        Data.header.paintIcon(this, g, 25, 15);

        //填充矩形空间
        g.fillRect(25, 75, 850, 600);

        //画蛇
        if(fx.equals("R")){
            Data.right.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        else if(fx.equals("U")){
            Data.up.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        else if(fx.equals("D")){
            Data.down.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
         else if(fx.equals("L")){
            Data.left.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        for(int i=1 ;i<length;i++){
            Data.body.paintIcon(this, g, snakeX[i], snakeY[i]);
        }

        //画食物
        Data.food.paintIcon(this, g, foodx, foody);

        //显示游戏积分和蛇的长度
        g.setColor(Color.white);
        g.setFont(new Font("微软雅黑",Font.BOLD,18));
        g.drawString("长度"+length, 750, 32);
        g.drawString("积分"+score, 750, 52);

        //停止画面
        if(isStart==false&&isFail==false){
            g.setColor(Color.WHITE);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("按下空格开始游戏", 300, 300);
        }

        //失败画面
        if(isFail==true){
            g.setColor(Color.RED);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("按下空格重新开始", 300, 300);
            isStart=false;
        }

    }

    //定时器动作
    @Override
    public void actionPerformed(ActionEvent e) {
        if(isStart){
            for(int i = length-1;i>0;i--){
                snakeX[i] = snakeX[i-1]; 
                snakeY[i] = snakeY[i-1]; 
            }
            if(fx.equals("R")){
                snakeX[0]+=25;
                if(snakeX[0]>=850)
                    snakeX[0]=25;
            }
            else if(fx.equals("L")){
                snakeX[0]-=25;
                if(snakeX[0]<=0)
                    snakeX[0]=850;
            }
            else if(fx.equals("U")){
                snakeY[0]-=25;
                if(snakeY[0]<=75)
                    snakeY[0]=650;
            }
            else if(fx.equals("D")){
                snakeY[0]+=25;
                if(snakeY[0]>=650)
                    snakeY[0]=75;
            }   
            if(snakeX[0]==foodx&&snakeY[0]==foody){
                length++;
                score+=10;
                foodx = 50+25*random.nextInt(32);
                foody = 100+25*random.nextInt(22);
            }
            for(int i=1;i<length;i++){
                if(snakeX[i]==snakeX[0]&&snakeY[i]==snakeY[0]){
                    isFail=true;
                    isStart=false;
                    break;
                }
            }
            repaint();
        }
        timer.start();
    }

    //键盘监听
    @Override
    public void keyPressed(KeyEvent e) {
        // 按下   
        int keyCode = e.getKeyCode();
        if(keyCode==KeyEvent.VK_SPACE){
            if(isFail){
                isFail=false;
                init();
                isStart=true;
            }
            else
                isStart = !isStart;
        }
        else if(isStart){
            if(keyCode==KeyEvent.VK_D && !fx.equals("L") && !fx.equals("R")){
                fx="R";
            }
            else if(keyCode==KeyEvent.VK_A&& !fx.equals("R") && !fx.equals("L")){
                fx="L";
            }
            else if(keyCode==KeyEvent.VK_W&& !fx.equals("D") && !fx.equals("U")){
                fx="U";
            }
            else if(keyCode==KeyEvent.VK_S&& !fx.equals("U") && !fx.equals("D")){
                fx="D";
            }
        }
        repaint();

    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        // 释放

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // 敲击
    }


    
}