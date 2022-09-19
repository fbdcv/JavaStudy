package lambda;

interface Grade{
    String judge(int x);
}
public class Demo2 {
    public static void main(String[] args) {
        Grade grade = (x)->{
            if(x>=60&&x<=100){
                return "及格";
            } else if (x>=0&&x<60) {
                return "不及格";
            }
            else {
                return "ERROR";
            }
        };
        System.out.println(grade.judge(66));
    }
}
