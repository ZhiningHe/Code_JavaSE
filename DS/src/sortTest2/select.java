package sortTest2;

/**
 * select of sort
 * 循环n遍，每一次选择i（包括i）位置后最小的一个元素与i位置交换
 *
 * 稳定
 * 3000 nm
 */
public class select {
    public static void main(String[] args) {
        int[] arr = new int[]{23,444,53,4,24,98,2};
        long start = System.nanoTime();
        for (int i=0; i<arr.length-1; i++){
            int tmp = arr[i]; int min = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j] <arr[min]) min = j;
            }
            //第一位和剩下最小值交换
            arr[i] = arr[min];
            arr[min] = tmp;
        }
        long end = System.nanoTime();
        System.out.println((double) (end-start)+" nm");
        for (int k=0; k<arr.length; k++){
            System.out.print(arr[k]+"、");
        }
    }
}
