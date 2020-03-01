package sortTest4;


public class quick {
    //二路快排

    public static void quick4(int[] arr) {
        if(arr.length<=1) return;
        Qui(arr,0,arr.length-1);
    }

    private static void Qui(int[] arr, int start, int end) {
        if (start>=end) return;
        int key = select(arr,start,end);
        Qui(arr,start,key-1);
        Qui(arr,key+1,end);
    }

    private static int select(int[] arr, int start, int end) {
        int key = start; int val = arr[start];
        int left = start+1; int right = end;
        while (true){
            while (left<=end && arr[left]<=val) left++;
            while (right>=start+1 && arr[right]>=val) right--;
            if (left>right) break;
            swap(arr,left,right);
        }
        swap(arr,right,start);
        return right;
    }

    private static void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {345,241,867,5,4,34,2,5,4,7};
        quick4(a);
        for (int i:a
                ) {
            System.out.print(i+"、");
        }
    }
}
