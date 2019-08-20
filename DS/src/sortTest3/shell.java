package sortTest3;

public class shell {
    public static void shellsort(int[] arr){
        if (arr.length<=1) return;

        int i,j,step=arr.length/2;
        while (step>=1){
            for (i=step; i<arr.length; i++){
                int tmp = arr[i];
                j = i-step;
                for (; j>=0; j-=step){
                    if (tmp >arr[j]) break;
                    else {
                        arr[j+step] = arr[j];
                    }
                }
                arr[j+step] =tmp;
            }
            step /=2;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,4,3,6,56,45,54};
        shellsort(arr);
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i]+"、");
        }
    }
}
