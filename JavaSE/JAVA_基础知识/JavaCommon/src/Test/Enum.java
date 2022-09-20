package Test;

enum Season{
    Spring,Summer,Autumn,Winter
}
public class Enum {
    public static void main(String[] args) {
        Season[] values = Season.values();
        for(Season s:values){
            System.out.println(s);
        }
    }
}
