package top.fbdcv.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //创建模型和视图
        ModelAndView mv = new ModelAndView();

        //封装对象，放在ModelAndView中
        mv.addObject("msg","HelloMVC!");

        //封装要跳转的视图，放在ModelAndView中
        mv.setViewName("hello"); //使用视图解析器 解析为/WEB-INF/jsp/hello.jsp
        return mv;
    }
}
