package sortTest4;

import java.util.Iterator;

public class buble {
    public static void bublesort(int[] array){
        boolean flag =true;
        for (int i=0;i<array.length-1;i++){
            for (int j = i+1; j<array.length; j++){
                if (array[i]>array[j]){
                    flag = false;
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
            if (flag) break;
        }
    }


    public static void main(String[] args) {
        int[] a = {345,241,867,5,4,34,2,5,4,7};
        bublesort(a);
        for (int i:a
             ) {
            System.out.print(i+"、");
        }
    }
}
