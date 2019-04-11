package Sort;

public class Pritics {
    //插入排序
    public static void insert(int[] array){
        if(array.length <=1) return;
        //设定要插入的元素
        for(int i=1; i<array.length; i++){
            //有序区域最大值
            int j = i-1;int tmp = array[i];
            for(;j>=0; j--) {
                //用来在[0,j]寻找位置的循环
                if (tmp >= array[j]) {
                    break;
                } else {
                    array[j + 1] = array[j];
                }
            }
            array[j + 1] = tmp;
        }
    }
}
