package top.fbdcv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.fbdcv.pojo.User;

@Controller
//使用注解，自动注册bean
public class HelloController {

    @RequestMapping("/hello")
    //使用注解自动注册处理器的访问路径
    public String method(Model model){

        model.addAttribute("msg","hello SpringMVC Annotation");
        return "hello"; //被视图解析器处理
    }

    @GetMapping ("/user")
    public String method2(Model model, @RequestParam("username") String name){ //接收前端传入的username参数

        model.addAttribute("msg",name);
        return "hello";
    }
    @GetMapping("/user2")
    public String method3(Model model, User user) { //接收前端传入的User类中属性名对应的参数
        model.addAttribute("msg",user.toString());
        return "hello";
    }
}
