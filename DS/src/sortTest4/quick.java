package sortTest4;

public class quick {
    //二路快排

    public static void quick4(int[] arr){
        if (arr.length <=1){
            return;
        }
        quicksort(arr,0,arr.length-1);
    }
    public static void quicksort(int[] arr, int start,int end){
        if (start>end){
            return;

        }
        int key = selectKey(arr,start,end);

    }

    private static int selectKey(int[] arr, int start, int end) {
        return 1;
    }

    public static void main(String[] args) {
        int[] a = {345,241,867,5,4,34,2,5,4,7};
        //qiucksort(a);
        for (int i:a
                ) {
            System.out.print(i+"、");
        }
    }
}
