package JavaSE.IO;

import jdk.internal.util.xml.impl.Input;

import java.io.*;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        //原文件路径
        String srcFilePath = "H:\\hhh.jpg";
        //目标文件路径
        String destFilePath = "C:\\Users\\贺致宁\\Desktop\\a.jpg";
        copyFile(srcFilePath,destFilePath);
    }
    public static void copyFile(String src,String dest) throws IOException {
        //1.取得源文件的File对象
        File srcfile = new File(src);
        File destfile = new File(dest);
        //2.取输入输出流
        //因为是文件取字节输入输出
        InputStream in = new FileInputStream(srcfile);
        OutputStream out = new FileOutputStream(destfile,true);
        //3.输入输出
        int len = 0;
        byte[] data = new byte[2048];

        long start = System.currentTimeMillis();

        while((len = in.read(data)) != -1){
            out.write(data,0,len);
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start+"ms" );
        //4.关闭流
        in.close();
        out.close();

    }
}
