package Test;

public class Enum1 {
    public static void main(String[] args) {
        Season summer = Season.valueOf("Summer");
        Season[] seasons = Season.values();
        for(int i=0;i<seasons.length;i++){
            System.out.println("索引"+seasons[i].ordinal()+"  "+seasons[i]);
        }
        System.out.println(summer.compareTo(seasons[0]));
        System.out.println(summer.compareTo(seasons[1]));
        System.out.println(summer.compareTo(seasons[2]));
        System.out.println(summer.compareTo(seasons[3]));

    }
}
