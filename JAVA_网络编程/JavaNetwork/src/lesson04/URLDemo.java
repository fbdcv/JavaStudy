package lesson04;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://dl.stream.qqmusic.qq.com/RS02060W4yus39IeNv.mp3?guid=3942257025&vkey=C77E982B21DBBE50FEA312B7E40F56AB1E81EECB5ED81AA9F0CC863CB4187A0AE0CA37CC9C64F25C5C14C457EB57AA598336CE9C83B6B37A&uin=&fromtag=120052");
        // 建立与url的连接
        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
        //得到输入流，将url中的内容输入到缓冲区，再通过缓冲区输出到文件
        InputStream is = urlConnection.getInputStream();
        FileOutputStream fos = new FileOutputStream("RS02060W4yus39IeNv.mp3");
        byte[] buffer = new byte[1024];
        int len;
        while((len=is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        //关闭流与连接
        fos.close();
        is.close();
        urlConnection.disconnect();
    }
}
