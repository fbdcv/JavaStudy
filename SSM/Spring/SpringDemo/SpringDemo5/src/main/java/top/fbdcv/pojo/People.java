package top.fbdcv.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

@Data
public class People {
    @Autowired
    @Qualifier(value = "cat222")
    private Cat cat;
    @Resource( name = "dog222")
    private Dog dog;
    private String name;

}
