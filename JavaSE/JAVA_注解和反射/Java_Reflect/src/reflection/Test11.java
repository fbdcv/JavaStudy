package reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

//通过反射获取泛型
public class Test11 {

    public void test01(Map<String,User> map, List<User> list){
        System.out.println("test01");
    }

    public Map<String,User> test02(){
        System.out.println("test02");
        return null;
    }

    public static void main(String[] args) throws Exception{

        Method method = Test11.class.getMethod("test01", Map.class, List.class);
        Type[] genericParameterTypes = method.getGenericParameterTypes();       //获得方法参数的泛型
        for (Type genericParameterType : genericParameterTypes) {
            System.out.println("#" + genericParameterType);
            if(genericParameterType instanceof ParameterizedType){  //如果这个泛型的参数类型属于参数化类型
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();//获得真实的参数信息
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println(actualTypeArgument);
                }
            }
        }

        System.out.println("______________________________________");

        method = Test11.class.getMethod("test02",null);
        Type genericReturnType = method.getGenericReturnType();     //获得方法返回值的泛型
        if(genericReturnType instanceof ParameterizedType){  //如果这个泛型的参数类型属于参数化类型
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();//获得真实的参数信息
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println(actualTypeArgument);
            }
        }
    }
}
