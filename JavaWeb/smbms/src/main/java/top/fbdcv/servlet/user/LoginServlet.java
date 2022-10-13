package top.fbdcv.servlet.user;

import org.junit.Test;
import top.fbdcv.pojo.User;
import top.fbdcv.service.user.UserServiceImpl;
import top.fbdcv.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    //Servlet:控制层,调用业务层代码

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户名和密码
        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");

        //调用业务层查找用户
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.login(userCode,userPassword);

        if(user!=null){ //若用户存在,将用户信息写在session中
            //req.getSession().setAttribute(Constants.USER_SESSION,user);
            //跳转到内部主页
            resp.sendRedirect("jsp/frame.jsp");
        }else{//若用户不存在,跳转到主页,并提示错误信息
            req.setAttribute("error","用户名或者密码不正确");
            req.getRequestDispatcher("login.jsp").forward(req,resp);

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    //使用junit进行单元测试
    @Test
    public void test(){
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.login("admin","1234567");
        System.out.println(user.getUserName());
    }
}
