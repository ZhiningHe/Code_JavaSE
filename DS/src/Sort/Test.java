package Sort;

public class Test {
    public static void main(String[] args) {
        int [] data = new int[]{4,5,2,3,1,1,6};
//        //bubbleSort.bubble(data);
//        //sortHelpper.print(data);
//        insertSort.insert(data);
//          insertSort.halfInsert(data);
 //       shellSort.shell(data);
  //      seleteSort.selete(data);
       QuickSort.qiuckSort3(data);
  //      mergeSort.sort(data);


//        Pritics.insert(data);
         sortHelpper.print(data);
    }
}
