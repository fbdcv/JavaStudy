package test;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应头
        resp.setContentType("text/html;charset=utf-8"); //设置响应文件为html格式
        //设置编码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //查看cookie中的内容
        PrintWriter out = resp.getWriter();

        //显示当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 EEEE HH时mm分ss秒");
        String date = df.format(new Date(System.currentTimeMillis()));
        out.println("当前时间："+date);
        out.println("<br>");
        out.println("Cookies<br>");
        for (Cookie cookie : req.getCookies()) {
            //显示我们设置的cookie
            if(cookie.getName().equals("name")){
                out.println("name:"+cookie.getValue());
                out.println("<br>");        //换行
            }else {
                //显示系统默认添加的cookie
                out.println(cookie.getName()+":"+cookie.getValue());
                out.println("<br>");
            }
        }

        //设置cookie
        Cookie name = new Cookie("name", "fbdcv");
        name.setMaxAge(5); //可以设置cookie的有效期，参数的单位是秒
        resp.addCookie(name);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
