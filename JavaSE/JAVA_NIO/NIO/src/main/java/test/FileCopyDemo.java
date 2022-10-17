package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileCopyDemo {

    public static void main(String[] args) {
        String classpath = FileCopyDemo.class.getClassLoader().getResource(".").getPath();
        System.out.println(classpath);
        File file = new File(classpath+"demo.jpg");
        System.out.println(file.exists());

        try {
            //1.读取文件的一个Channel对象
            FileChannel ipsChannel = new FileInputStream(file).getChannel();
            //2.输出文件的Channel对象
            FileChannel opsChannel = new FileOutputStream(classpath+"copy_demo.jpg").getChannel();
            //3.创建一个Buffer缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while (ipsChannel.read(buffer)!=-1){

                buffer.flip();      //转成可读模式
                opsChannel.write(buffer);
                buffer.clear();     //清空缓冲区
            }
            System.out.println("图片复制完成");
            //资源关闭
            ipsChannel.close();
            opsChannel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
