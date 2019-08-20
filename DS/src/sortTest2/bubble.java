package sortTest2;

/**
 * bubble of sort
 * 进行了标志位优化
 * 记录运行时间
 *
 * 4800 nm
 */
public class bubble {
    public static void main(String[] args) {
        long start = System.nanoTime();
        int [] arr = new int[]{23,444,53,4,24,98,2};

        for(int i=0; i<arr.length; i++){
            boolean flag = false;
            for(int j=0; j<arr.length-1; j++){
                if(arr[j] >arr[j+1]){
                    flag =true;
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
            if(!flag) break;
        }
        long end = System.nanoTime();
        System.out.println((double) (end-start)+" nm");
        for (int k=0; k<arr.length; k++){
            System.out.print(arr[k]+"、");
        }
    }
}
