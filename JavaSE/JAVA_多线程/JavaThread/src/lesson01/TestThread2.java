package lesson01;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//练习Thread，实现多线程同步下载图片
public class TestThread2 extends Thread{
    private String url; //网络图片地址
    private String name;//保存的文件名

    public TestThread2(String url,String name){
        this.url=url;
        this.name = name;
    }

    //下载图片线程的执行体
    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("已下载文件："+name);
    }

    public static void main(String[] args) {
        TestThread2 thread1 = new TestThread2("http://img.netbian.com/file/2020/0904/7cab180eca805cce596b6870cb4e1379.jpg","1.jpg");
        TestThread2 thread2 = new TestThread2("http://img.netbian.com/file/2021/0821/a49d58bea940c16ea6e5b2b2e159f687.jpg","2.jpg");
        TestThread2 thread3 = new TestThread2("http://img.netbian.com/file/2020/0904/919e45e8a57d4d7d3a783eeb110a7285.jpg","3.jpg");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

//下载器
class WebDownloader{
    //下载方法
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现错误");
        }
    }
}
