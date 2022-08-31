import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Test20 {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("text09.txt"))){

            People people = (People) ois.readObject();
            System.out.println(people.name);
            System.out.println(people.value);

        }catch (ClassNotFoundException | IOException e){
            e.printStackTrace();
        }
    }
}
