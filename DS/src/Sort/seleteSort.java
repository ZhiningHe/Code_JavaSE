package Sort;
//选择排序 选择最小和集合第一个元素互换
public class seleteSort {
    public static void selete(int[] data){
        if(data.length <=1) return;
        //每循环一次 就有一个最小值放在该有的位置
        for(int i =0; i<data.length-1; i++){
            int min = i;
            //比较找出最小的元素
            for(int j=i+1; j<data.length; j++){
                if(data[j] < data[min]){
                    min = j;
                }
            }
            //把最小的元素放在i的位置
            int tmp = data[i];
            data[i] = data[min];
            data [min] = tmp;
        }
    }
}
