package Sort;

public class mergeSort {
    public static void sort(int[] data){
        if(data.length <1){
            return;
        }
        divide(data,0,data.length-1);
    }
    private static void divide(int[] data,int start,int end){  //拆分
        //结束条件：拆分后的数组只剩两个元素
        if(start >= end){
            return;
        }
        //优化：因为归并对于小数据的数组效率不如直插快
        if(end - start <=15) {
            insert(data, start, end);
            return;
        }
        //计算中间值
        int mid = (start+end)/2;
        //左边数组继续拆分
        divide(data,start,mid);
        //右边数组继续拆分
        divide(data,mid+1,end);
        //合并
        merge(data,start,mid,end);
    }
    //拆分后的小数组
    private static void merge(int[]data,int start,int mid,int end ){  //合并
        int i =start;int j = mid+1;
        int[] tmp = new int[end-start+1];int k=0;
        while(i<=mid &&j<=end){
            if(data[i] <=data[j]){
                tmp[k++] = data[i++];
            }else{
                tmp[k++] = data[j++];
            }
        }
        //若左半边数组还未完
        int left =i;int right =mid;
        //若右半边数组还未完
        if(j <=end){
            left = j;
            right = end;
        }
        //把剩余的元素放进合并的tmp数组最后
        while (left <= right){
            tmp[k++] = data[left++];
        }
        //将tmp中排序合并后的元素存回给data
        for (i =0; i<=end-start; i++){
            data[start+i] = tmp[i];
        }
    }
    private static void insert(int[] array,int start,int end){
        int i = start;
        for(;i<end;i++){
            int j = i+1; int value = array[i];
            for(;j>=0;j--){
                if(array[j]>value){
                    array[j+1] = array[j];
                }else break;
            }
            array[j+1] = value;
        }
    }

}
