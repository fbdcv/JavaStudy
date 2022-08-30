import java.io.File;

public class Test06 {
    public static void main(String[] args) {
        File file = new File("text01.txt");//创建文件对象，这个路径可以是相对路径也可以是绝对路径
        System.out.println("文件是否存在："+file.exists());
        System.out.println("文件大小："+file.length());
        System.out.println("文件是否为一个文件夹："+file.isDirectory());
        System.out.println("文件是否可读："+file.canRead());
        System.out.println("文件是否可写："+file.canWrite());
        System.out.println("文件是否可执行："+file.canExecute());
    }
}
