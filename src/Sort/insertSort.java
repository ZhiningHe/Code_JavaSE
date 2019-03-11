package Sort;

public class insertSort {
    public static void insert(int [] data){
        if(data.length <=1){
            return;
        }
        for(int i=1; i<data.length;i++){
            //data[i]是要插入的待排序集合的元素,data[0]是已排序集合的元素
            int tmp = data[i];
            for(int j=i-1; j>=0; j--){
                //data[j]是和data[i]比较的元素
                if(data[i]>=data[j]){
                    //如果插入的数更大，就不往后移
                    break;
                }else{
                    //如果插入的数小于已排序集合的最后一个，也就是最大的元素
                    //那么把最后一个元素往后移动，直到找到要插入的位置
                    data[j+1] = data[j];
                }
                //在指定位置插入元素
                data[j+1] = tmp;
            }
        }
    }

    public static void halfInsert(int[] data){
        if(data.length <=1){
            return;
        }
        for(int i=1; i<data.length;i++){
            //data[i]是要插入的待排序集合的元素,data[0]是已排序集合的元素
            int tmp = data[i];
            int low = 0; int high = i-1;
            //
            while (low<=high){
                //折半查找到插入位置
                int mid = (low+high)/2;
                if(tmp <= data[mid]){
                    high = mid-1;
                }if(tmp > data[mid]){
                    low = mid +1;
                }
            }
            int j=i-1;
            //插入位置是high+1,high+1之后的元素往后移动
            //把high+1到i-1之间的元素都往后移一位
              for(;j>=high+1;j--){
                    data[j+1] = data[j];
              }//退出后j=high，插入
                data[j+1] = tmp;
            }
    }
}

