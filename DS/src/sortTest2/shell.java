package sortTest2;

/**
 * 希尔排序
 *
 * 以step为循环次数的直接插入
 */
public class shell {

    public static void shell(int[] arr){
        if(arr.length<= 1){
            return;
        }
        int step = arr.length/2;
      while (step >=1){
            for (int i = step; i < arr.length; i++) {
                int value = arr[i];
                int j = i - step;
                for (; j >= 0; j -= step) {
                    if (value < arr[j]) {
                        arr[j + step] = arr[j];
                    }else{
                        break;
                    }
                }
                arr[j+step] = value;
            }
            step /=2;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 6, 4, 5, 3, 2};
        shell(arr);
        for (int i : arr
                ) {
            System.out.print(i + "、");
        }
    }
}
