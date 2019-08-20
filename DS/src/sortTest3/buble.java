package sortTest3;

public class buble {
    public static void bublesort(int[] arr){
        int low,fast;
        boolean flag ;
        for (low=0; low<arr.length-1; low++){
            flag =false;
            for (fast=low+1; fast<arr.length; fast++){
                if(arr[low]>arr[fast]){
                    flag =true;
                    int tmp = arr[low];
                    arr[low] = arr[fast];
                    arr[fast] = tmp;
                }
            }
            if (flag) break;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,4,3,6,56,45,54};
        buble.bublesort(arr);
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i]+"、");
        }
    }
}
