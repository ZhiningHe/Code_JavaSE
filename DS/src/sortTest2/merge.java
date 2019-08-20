package sortTest2;

/**
 * 从中间先分开，在合并
 */

public class merge {

    public static void sort(int arr[]){
        if(arr.length <=1) return;
        divide(arr,0,arr.length-1);
    }

    private static void divide(int[] arr,int start,int end ){
        if(end <=start){
            return;
        }
        int mid =(end -start) /2+ start;
        divide(arr,start,mid);
        divide(arr,mid+1,end);
        merge(arr,start,end,mid);
    }

    private static void merge(int[] arr,int start, int end ,int mid){
        int i =start;int j= mid+1;
        int k=0;
        int [] arr_new = new int[end - start+1];
        while (i<=mid && j<=end){
            if(arr[i] <=arr[j]){
                arr_new[k++] = arr[i++];
            }else
            {
               arr_new[k++] = arr[j++];
            }
        }

        //把剩下的元素全部移动到新数组中
        int l = i; int h = mid;
        if (j<=end){
            l = j; h = end;
        }
        while (l <= h){
            arr_new[k++] = arr[l++];
        }
        for (i =0; i<=end-start; i++){
            arr[start+i] = arr_new[i];
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{5, 6, 4, 5, 3, 2};
        sort(arr);
        for (int i : arr
                ) {
            System.out.print(i + "、");
        }
    }
}
