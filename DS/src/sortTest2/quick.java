package sortTest2;



public class quick {
    //一路排序
    public static void One(int[] arr){
        if(arr.length <=1){
            return;
        }
        OneQuick(arr,0,arr.length-1);
    }
    private static void OneQuick(int[] arr,int start,int end){
        if(start>=end){
            return;
        }
        int key = primrity(arr,start,end);
        OneQuick(arr,start,key-1);
        OneQuick(arr,key+1,end);

    }
    private static int primrity(int[] arr,int start, int end){
        int value = arr[start];
        //i走，j是小于的分界
        int i =start+1,j = start;
        while (i<=end){
            if(arr[i] <value){
                swap(arr,i,j+1);
                j++;
            }
            i++;
        }
        swap(arr,start,j);
        return j;
    }



    //二路快排
    public static void Two(int[] arr){
        if(arr.length <=1){
            return;
        }
        TwoQuick(arr,0,arr.length-1);
    }
    private static void TwoQuick(int[] arr,int start, int end){
        if (start>=end){
            return;
        }
        int key = keyOfTwo(arr,start,end);
        TwoQuick(arr,start,key-1);
        TwoQuick(arr,key+1,end);
    }
    private static int keyOfTwo(int []arr, int start, int end){
        int i=start+1,j=end;
        int value = arr[start];
        while (i<=j){
            while (i<end && arr[i]<=value){
                i++;
            }
            while (j>start && arr[j]>=value){
                j--;
            }
            if(i >j) break;
            swap(arr,i,j);i++;j--;
        }
        swap(arr,start,j);
        //j和i交换后，j在i之前，
        // 也就是说j是小于key的区域的最后一个数
        return j;
    }



    //三路快排
    public static void Three(int[] arr){
        if (arr.length<=1){
            return;
        }
        ThreeQuick(arr,0,arr.length);
    }
    private static void ThreeQuick(int[] arr, int start, int end){
        if(start >=end){
            return;
        }
        int key = keyOfThree(arr,start,end);
        ThreeQuick(arr,start,key-1);
        ThreeQuick(arr,key+1,end);
    }
    private static int keyOfThree(int[] arr,int start,int end){
        int value = arr[start];
        int lt = start;
        int gt =end+1;
        int i = start+1;
        for (;i<gt;i++){
            //小于的话，i和lt+1交换
            if (arr[i] <value){
                swap(arr,i,lt+1);
                lt++;
            }
            else if(arr[i] >value){
                swap(arr,i,gt-1);
                gt--;
            }
        }
        swap(arr,lt,start);
        return lt;
    }




    private static void swap(int[]arr , int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int [] arr =new int[]{5,6,4,5,3,4,2,8,67,4,23,2};
        Two(arr);
        for (int i:arr
             ) {
            System.out.print(i+"、");
        }
    }
}
