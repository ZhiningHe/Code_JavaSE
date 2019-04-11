package JavaSE.IO;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class scannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入内容：");
        //定义分隔符
        scanner.useDelimiter("\n");

        //如果有任意类型输入就打印出来
       // if(scanner.hasNext()){
        //输入是int型才进入分支
        if(scanner.hasNextInt()){
            System.out.println("输入："+scanner.next());
        }
    }
}
