package test;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

public class Download extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取资源的路径
        String url = this.getClass().getResource("/img.png").getPath();
        String filename = url.substring(url.lastIndexOf("/")+1);
        //2.设置下载文件的响应头
        resp.setHeader("Content-Disposition","attachment;filename="+filename);
        //3.通过resp的流，传输文件
        FileInputStream fis = new FileInputStream(url);
        ServletOutputStream os = resp.getOutputStream();
        int len;
        byte[] buffer = new byte[1024];
        while((len=fis.read(buffer))!=-1){
            os.write(buffer,0,len);
        }

        os.flush();

        os.close();
        fis.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
