package test;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;

public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置定时刷新网页的响应头
            resp.setHeader("refresh","3");

        //2.生成验证码
        Random random = new Random();
        int tmp = random.nextInt(9999999);
        DecimalFormat format = new DecimalFormat("0000000");
        String num = format.format(tmp);

        //3.创建验证码图片
        BufferedImage image = new BufferedImage(80,20,BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D)image.getGraphics();
        g.setBackground(Color.WHITE);
        g.fillRect(0,0,80,20);
        g.setColor(Color.BLUE);
        g.setFont(new Font(null,Font.BOLD,20));
        g.drawString(num,0,20);
        //4.设置响应头，使图片可以刷新显示
        resp.setContentType("image/jpeg");
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");
        //5.将图片传输到客户端上
        ImageIO.write(image,"jpg",resp.getOutputStream());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
