package JavaSE.IO;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class Test {
    public static void main(String[] args) throws IOException {
        File file = new File("H:\\Test.text");
        if(file.exists()){
            System.out.println((double) file.length()/1024/1024);//M

            //打印时间
            Date date = new Date(file.lastModified());
            SimpleDateFormat simpleDateFormat
                    = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(simpleDateFormat.format(date));

            //输出字节流
            OutputStream out = new FileOutputStream(file,true);
            String str = "hello world!!!";
            out.write(str.getBytes());
            out.close();

        }else{
            file.createNewFile();
        }
        System.out.println(file.getParent());

    }
}
