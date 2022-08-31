import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
class People implements Serializable{
    String name;
    transient String value = "value";       //被transient修饰，无法序列化
    public People(String name){
        this.name = name;
    }
}

public class Test19 {
    public static void main(String[] args) {

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("text09.txt"))){

            oos.writeObject(new People("niubility"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

