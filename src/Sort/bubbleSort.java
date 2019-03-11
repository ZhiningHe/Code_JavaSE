package Sort;

public class bubbleSort {
    public static void bubble(int [] data) {
        //判断数组个数要不要排序
        if(data.length<=1){
            return;
        }
        //冒泡排序
        //O（n^2）
        for(int i=0; i<data.length; i++){
            //控制比较次数
            boolean flag = false;
            for(int j=0; j<data.length-1-i; j++){
                //两两交换比较
                if(data[j]>data[j+1]){
                    int tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                    flag = true;
                }
            }
            if(!flag){
                break;//数据集已经有序，跳出
            }
        }
    }
}
