package Resection;

public class ResectionProcessor {

    /**
     * 进行后方交会处理
     * @param data  传入已知点
     * @param number  已知点个数
     * @param V 限差
     */
    public static void Test(double[][] data,int number,double V) {
        //赋初值
        double Xs = average(data,0);
        double Ys = average(data,1);
        double Zs = average(data,2);
        double fai = 0.0,w = 0.0,k = 0.0;
        //
        int v=0;
        while (v>=V) {
            //组旋转矩阵R
            double [][]R = new double[2][2];
            R = ResectionUtil.revolve(fai,w,k);
            for (int i = 0; i < number; i++) {
            //计算下xy的近似值和lxly

            //误差方程，法化

            }
            //求未知数改正数v

            //计算改正后的外方位元素

            //迭代次数+1
        }
        //输出结果
    }


    /**
     * 求初值，平均值
     * @param data  二维数组，已知点
     * @param i 第几列求平均
     * @return
     */
    private static double average(double[][] data, int i) {
        double sum =0.0;
        for(int line=0;line<4;line++){
            sum += data[line][i];
        }
        return sum/4;
    }
}
