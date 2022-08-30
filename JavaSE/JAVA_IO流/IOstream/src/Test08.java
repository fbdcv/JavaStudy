import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test08 {
    public static void main(String[] args) {
        File file1 = new File("src/");
        System.out.println(file1.getAbsolutePath());
        File file2 = new File("src2/");
        file2.mkdir();
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
