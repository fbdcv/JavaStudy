package reflection;

//测试class类的创建方式有哪些

class Person{
    public String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Student extends Person{
    public Student(){
        this.name="学生";
    }
}

class Teacher extends Person{
    public Teacher(){
        this.name="老师";
    }
}




public class Test03 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println("这个人是:"+person.name);

        //方式一： 通过对象.getClass获得
        Class c1 = person.getClass();
        System.out.println(c1.hashCode());

        //方式二： forName获得
        Class c2 = Class.forName("reflection.Student");
        System.out.println(c2.hashCode());

        //方式三：通过类名.class获得
        Class c3 = Student.class;
        System.out.println(c3.hashCode());

        //方式四：基本内置类型的包装类都有一个Type属性
        Class c4 = Integer.TYPE;
        System.out.println(c4);

        //方式五: 通过子类获取父类的Class对象
        Class c5 = c1.getSuperclass();
        System.out.println(c5);




    }
}
