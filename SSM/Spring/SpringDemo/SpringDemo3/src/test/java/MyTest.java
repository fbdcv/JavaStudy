import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.fbdcv.pojo.User;


public class MyTest {


    @Test
    public void Test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User user1 = (User) context.getBean("user");
        User user2 = (User) context.getBean("user");
        System.out.println(user1==user2);
    }
}
