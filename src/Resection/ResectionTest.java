package Resection;
/**
 * 单向片后方交会
 */

import java.io.*;

public class ResectionTest {
    public static void main(String[] args) throws IOException {
        //读入数据
        System.out.println("已知点接收中……");
        File file = new File("H:\\data.txt");
        FileReader read = new FileReader(file);
        double[][] data = ResectionUtil.dataScanf(read);
        //进行后方交会处理
        System.out.println("开始处理数据……");
        ResectionProcessor.Test(data,4,0.1);
        System.out.println("处理完毕！");
        }
    }
