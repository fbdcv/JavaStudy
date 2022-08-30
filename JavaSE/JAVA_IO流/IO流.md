# IO流

## 初始Java IO流

输入流、输出流是针对内存而言的

输入流是将流中的数据写到内存中（相当于代码中的变量中）

输出流根据流的特性写到指定的地方，例如FileOutputStream（new File("1.txt") ），将流中的数据写到文件1.txt中

![image-20220710185534910](image-20220710185534910.png)

## IO流基类

![img](20160918140245837.jpeg)

## 文件流

### 文件字节流

#### FileInputStream

尝试读出text01.txt中的数据

![image-20220830093557011](image-20220830093557011.png)

```java
import java.io.FileInputStream;
import java.io.IOException;


public class Test01 {
    public static void main(String[] args) {

        try (FileInputStream is = new FileInputStream("text01.txt")){
            System.out.println((char) is.read());//尝试读取一个字节的数据，若没有数据（到达文件末尾）则返回-1
            System.out.println((char) is.read());//尝试读取第二个字节的数据
            System.out.println(is.available()); //查看当前可读的剩余字节数量(并不一定真实的数据量就那么多,这个方法只能做个预估)
            byte[] buffer = new byte[1024];     //设立一个缓存区，用于接受数据
            int len;                            //等下与read(bytes[])方法配合使用,该方法返回读取数据的长度
            while((len=is.read(buffer))!=-1){
                System.out.println(new String(buffer,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

![image-20220830100148466](image-20220830100148466.png)

#### FileOutputStream

将“Hello，World”写入到text02.txt中

```java
import java.io.FileOutputStream;
import java.io.IOException;

public class Test02 {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("text02.txt")) {
            fos.write("Hello,World".getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
```

![image-20220830110245517](image-20220830110245517.png)

试着将text01.txt中的数据追加到text02.txt中

```java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test03 {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("text02.txt", true);//设第二个参数为true，表示为追加
             FileInputStream fis=new FileInputStream("text01.txt")) {

            //将text01.txt中的数据读到buffer中，再将buffer中的数据写到test02.txt中
            byte[] buffer = new byte[1024];
            int len;
            while ((len=fis.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
```

![image-20220830111229567](image-20220830111229567.png)

### 文件字符流 

#### FileReader

将text02.txt文件以字符流的方式读到内存中，并显示出来

```java
import java.io.FileReader;
import java.io.IOException;

public class Test04 {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("text02.txt")) {
            char[] buffer = new char[1024];
            int len;
            while ((len=reader.read(buffer))!=-1){
                System.out.println(String.valueOf(buffer,0,len));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
```

![image-20220830174904210](image-20220830174904210.png)

#### FileWriter

创建一个内容与text02.txt一样的，文件名为text03.txt的文件

```java
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test05 {
    public static void main(String[] args) {
        try (FileReader fileReader=new FileReader("text02.txt"); FileWriter fileWriter = new FileWriter("text03.txt")){

            char[] buffer = new char[1024];
            int len;
            while ((len=fileReader.read(buffer))!=-1){
                fileWriter.write(buffer,0,len);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
```

![image-20220830175526441](image-20220830175526441.png)

### File

File类专门用于表示一个文件或文件夹，只不过它只是代表这个文件，但并不是这个文件本身，通过File对象，可以更好地管理和操作硬盘上的文件，File对象可以直接作为FileInputStream等类参数

```java
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
```

![image-20220830200216864](image-20220830200216864.png)

如果这个文件是目录文件（文件夹），还可以获取文件夹内部的文件列表的内容

```java
import java.io.File;
import java.util.Arrays;

public class Test07 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\24348\\Desktop\\JavaStudy\\JavaSE");
        System.out.println(Arrays.toString(file.listFiles()));
        for(File f:file.listFiles()){
            System.out.println(f.getAbsolutePath());
        }
    }
}
```

![image-20220830201544906](image-20220830201544906.png)

尝试拷贝文件夹下的所有文件到另一个文件夹（下面的代码实现了没有目录文件的文件夹之间的复制，并没有完全实现理想化的实现文件夹的完全复制）

```java
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test08 {
    public static void main(String[] args) {
        File file1 = new File("src/");
        System.out.println(file1.getAbsolutePath());
        File file2 = new File("src2/");
        file2.mkdir();		//创建文件夹
        for(File f:file1.listFiles()){
            try (FileInputStream fis = new FileInputStream(f);
                 FileOutputStream fos = new FileOutputStream(file2.getPath()+"/"+f.getName())){

                byte buffer[] = new byte[1024];
                int len;
                while((len=fis.read(buffer))!=-1){
                    fos.write(buffer,0,len);
                }
                fos.flush();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}

```

![image-20220830203650325](image-20220830203650325.png)

## 缓冲流

缓冲流的基本原理，是在创建流对象时，会创建一个内置的默认大小的缓冲区数组，通过缓冲区读写，减少系统IO次数，从而提高读写的效率。

![java中的包装流和缓冲流概述- CodeAntenna](70.png)

### 缓冲字节流



### 缓冲字符流



## 转换流

## 打印流

## 数据流

## 对象流

