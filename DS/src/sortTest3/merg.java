package sortTest3;

public class merg {
    public static void mergSort(int[] arr){
        if (arr.length<=1) return;
        divide(arr,0,arr.length-1);
    }

    private static void divide(int[] arr,int start, int end){
        if (start>=end)return;
        int mid = (end+start)/2;
        divide(arr,start,mid);
        divide(arr,mid+1,end);
        merg(arr,start,mid,end);
    }

    private static void merg(int[] arr,int start, int mid,int end){
        int[] newarr = new int[end-start+1];
        int i = start;
        int k=0;
        int j = mid+1;

        while (i<=mid && j<=end){
            if (arr[i]<=arr[j]) newarr[k++]=arr[i++];
            else newarr[k++] = arr[j++];
        }
        int left = i;
        int right = mid;
        if (j<=end){
            left = j;
            right = end;
        }
        while (left<=right){
            newarr[k++] = arr[left++];
        }
        for (int p=0; p<=end-start; p++){
            arr[p+start] = newarr[p];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,4,3,6,56,45,54};
        mergSort(arr);
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i]+"、");
        }
    }
}
