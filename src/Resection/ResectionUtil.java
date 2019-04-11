package Resection;

import java.io.*;

public class ResectionUtil {
    /**
     * 按行读取文件内容,返回double的二维数组
     * @param file 输入文件的输入流
     */
    public static double[][] dataScanf(FileReader file) throws IOException {
        BufferedReader br = new BufferedReader(file);//读取文件
        String line;
        String[][] s = new String[5][5];
        int count = 0;
        //保存到二维数组
        while ((line = br.readLine()) != null) {//按行读取
            String[] sp = line.split(" ");//按空格进行分割
            for (int i = 0; i < sp.length; i++) {
                s[count][i] = sp[i];
            }
            count++;
        }
        br.close();
        double[][] data = new double[4][5];
        //转换为double
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                data[i][j] = Double.parseDouble(s[i][j]);
                // System.out.println(data[i][j]);
            }
        }
        return data;
    }

    /**
     * 计算旋转矩阵
     * @param fai 三个旋转角
     * @param w
     * @param k
     * @return
     */
    public static double[][] revolve(double fai, double w, double k) {
        double[][] R = new double[2][2];
        R[0][0] = Math.cos(fai) * Math.cos(k) - Math.sin(fai) * Math.sin(w) * Math.sin(k);
        R[0][1] = -1 * Math.cos(fai) * Math.sin(k) - Math.sin(fai) * Math.sin(w) * Math.cos(k);
        R[0][2] = -1 * Math.sin(fai) * Math.cos(w);
        R[1][0] = Math.cos(w) * Math.sin(k);
        R[1][1] = Math.cos(w) * Math.cos(k);
        R[1][2] = -1 * Math.sin(w);
        R[2][0] = Math.sin(fai) * Math.cos(k) + Math.cos(fai) * Math.sin(w) * Math.sin(k);
        R[2][1] = -1 * Math.sin(fai) * Math.sin(k) + Math.cos(fai) * Math.sin(w) * Math.cos(k);
        R[2][2] = Math.cos(fai) * Math.cos(w);
        return R;
    }

    /**
     * 矩阵相乘
     * @param a
     * @param b
     * @return
     */
    public static double[][] multiply(double[][]a,double[][]b) {
        double[][] c = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    /**
     * 矩阵求转置
     * @param A
     */
    public static double[][] transpose(double [][]A) {
        double[][] B = new double[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                B[j][i] = A[i][j];
            }
        }
        return B;
    }





}