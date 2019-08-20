package sortTest2;

/**
 * 插入排序
 * 把数组分为两个区域：已排序和未排序
 * 从后往前比较
 */
public class insert {
    public static void main(String[] args) {
        long start = System.nanoTime();
        int[] arr = new int[]{23, 444, 53, 4, 24, 98, 2};

        //i前面是已排
        for (int i = 1; i <arr.length; i++) {
            //带插入元素
            int tmp = arr[i];int j = i - 1;
            for ( ;j >= 0; j--) {
                //如果大于则往后移
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                }
                //否则就插入
                else {
                    break;
                }
            }
            arr[j + 1] = tmp;
        }


            long end = System.nanoTime();
            System.out.println((double) (end - start) + " nm");
            for (int k = 0; k < arr.length; k++) {
                System.out.print(arr[k] + "、");
            }
        }
    }
