package Sort;

public class QuickSort {
    public static int[] qiuckSort(int[] array){
        if(array.length <=1) return array;
        //闭区间
        qiuck(array,0,array.length-1);
        return array;
    }
    private static void qiuck(int[] array ,int start, int end){
        if(start >=end) return;
        //选取key值
        int key = selectionKey(array, start, end);
        //key左边快排
        qiuck(array,start,key-1);
        //key右边快排
        qiuck(array,key+1,end);
    }
    //l…<……>…r
    //v……j……i
    private static int selectionKey(int[] array, int start, int end){
        //先设置为第一个元素
        int key = array[start];
        //[start,j]是<key的区域
        int j = start;
        //[j+1,i]是>key的区域
        int i = start+1;
        while(i <= end){
            //大于key不动 小于key跟array[j]交换
            if(array[i] <key){
                swap(array,j+1,i);
                j++;
            }
            i++;
        }
        //当遍历完之后把key放在j处 也就是最终位置处
       swap(array,start,j);
        return j;
    }



    //双路快速排序
    //优化重复元素多的数组
    public static int[] qiuckSort2(int[] array){
        if (array.length <=1) return array;
        qiuck2(array,0,array.length-1);
        return array;
    }
    private static void qiuck2(int[] array ,int start, int end){
        if(start >end) return;
        int key = selectionKey2(array,start,end);
        qiuck2(array,start,key-1);
        qiuck2(array,key+1,end);
    }
    private static int selectionKey2(int[] array, int start, int end){
        int random = (int)(Math.random()*(end-start+1)+start);
        swap(array,random,start);
        //找到一个随机key
        int value = array[start];
        //从头开始往后[start+1,i-1]
        int i = start+1;
        //从尾开始往前[j+1,end]
        int j = end;
        while (true){
                //相当于把等于key的值均分到两边
                while (i<=end && array [i] <value ) i++;
                while (j>=start+1 &&array [j] >value ) j--;
                //交换后两个指针都移动一步
            if(i>j) break;
            swap(array,i,j);
            i++;j--;
            }
        swap(array,start,j);
            return j;
        }



        //三路快排【推荐】
    //lt 小于v的最后一个元素，从前向后
    //[l+1,lt]<v
    //i  遍历的元素
    //[lt+1,i)==v
    //gt  大于v的第一个元素，从后向前
    //[gt,r]>v
    //l    lt   i   gt   r
    public static void qiuckSort3(int[] array){
        if(array.length <=1)return;
        int start = 0;int end = array.length-1;
        qiuck3(array,start,end);
    }
    private static void qiuck3(int[] array ,int start, int end){
        if(start >end) return;
        if(end - start <=15){
            //如果数据量少就使用直接插入
            insert(array,start,end);
            return;
        }

        int random = (int)(Math.random()*(end-start+1)+start);
        swap(array,random,start);
        //找到一个随机key
        int value = array[start];
        int lt = start; int gt = end+1; int i = start+1;
        for(;i<gt;i++){
            if(array[i]<value){
                //放到小于的区域
                swap(array,lt+1,i);
                lt++;
            }else if(array[i]>value){
                //放到大于区域
                swap(array,gt-1,i);
                gt--;
            }
        }
        swap(array,lt,start);
        //直接跳过相等元素的比较
        qiuck3(array,start,lt-1);
        qiuck3(array,gt,end);
    }
    private static void insert(int[] array,int start,int end){
        int i = start;
        for(;i<end;i++){
            int j = i-1; int value = array[i];
            for(;j>=0;j--){
                if(array[j]>value){
                    array[j+1] = array[j];
                }else break;
            }
            array[j+1] = value;
        }
    }

    private static void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
