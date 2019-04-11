package JavaSE.IO;

import java.io.*;

public class PrintOwn {
    public static void main(String[] args) throws IOException {
        File file = new File("H:\\text.text");
        PrintUtil print = new PrintUtil(new FileOutputStream(file));
        print.print("hdiuewiubfui");
        print.println("hhhhhhhhhhhhhh");
        print.print(40302);
        print.closed();
    }
}
class PrintUtil{
    private OutputStream out;

    public PrintUtil(OutputStream out){
        this.out = out;
    }
    public void print(String str) throws IOException {
        this.out.write(str.getBytes());
    }
    public void println(String str) throws IOException {
        this.print(str+"\r\n");
    }
    public void print(int data) throws IOException {
        this.print(String.valueOf(data));
    }
    public void print(double dou) throws IOException {
        this.print(String.valueOf(dou));
    }
    public void closed() throws IOException {
        this.out.close();
    }
}