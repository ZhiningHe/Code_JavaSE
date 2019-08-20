package sortTest3;

public class inser {
    public  static  void insertSort(int[] arr){
        if (arr.length<=1) return;
        int i,j;
        for (i=1;i<arr.length;i++){
            int tmp = arr[i];j=i-1;
            for (;j>=0;j--){
                if (tmp>=arr[j]){
                    break;
                }else{
                    arr[j+1]=arr[j];
                }
            }
            arr[j+1]=tmp;
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{2,4,3,6,56,45,54};
        insertSort(arr);
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i]+"、");
        }
    }
}
