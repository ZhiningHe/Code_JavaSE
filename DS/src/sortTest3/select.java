package sortTest3;

public class select {
    public static void selectSort(int[] arr){
        if (arr.length<=1) return;
        for (int i=0; i<arr.length; i++){
            int min = i;
            for (int j=i+1; j<arr.length-1; j++){
                if (arr[j]<arr[min]){
                    min = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2,4,3,6,56,45,54};
        selectSort(arr);
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i]+"、");
        }
    }
}
