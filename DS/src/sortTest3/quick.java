package sortTest3;

public class quick {
    public static void QuickSore3(int[] arr){
        if(arr.length<=1){
            return;
        }
        quick3(arr,0,arr.length-1);
    }

    private static void quick3(int[] arr,int start, int end){
        if (start>end) return;
        int key = findKey(arr,start,end);
        quick3(arr,start,key-1);
        quick3(arr,key+1,end);
    }

    private static int findKey(int[] arr, int start, int end) {
        int random = (int)(Math.random()*(end-start+1)+start);
        swap3(arr,random,start);
        int value = arr[start];
        int lt = start+1;
        int gt = end;
        while (true){
            while (lt<=end && arr[lt]<=value) lt++;
            while (gt>=start+1 && arr[gt]>=value) gt--;
            if (lt >gt) break;
            swap3(arr,lt,gt);
            lt++;gt--;
        }
        swap3(arr,gt,start);
        return gt;
    }

    private static void swap3(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{2,4,3,6,56,45,54};
        quick.QuickSore3(arr);
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i]+"、");
        }
    }
}
