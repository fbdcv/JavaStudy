import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.fbdcv.service.UserService;
import top.fbdcv.service.UserServiceImpl;

public class MyTest {

    @Test
    public void UserServiceTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = (UserServiceImpl)context.getBean("userServiceImpl");
        userService.getUser();
    }
}
