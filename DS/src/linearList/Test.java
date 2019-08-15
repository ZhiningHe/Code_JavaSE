package linearList;

public class Test {
    public static void main(String[] args) {
        SequenceListimpl doubleList = new SequenceListimpl();
        doubleList.add(1);
        doubleList.add(10);
        doubleList.add(20);
        doubleList.add(30);
        doubleList.add(40);
        doubleList.remove(2);
        doubleList.remove(0);
        System.out.println(doubleList.get(0));
        Object[] arrays = doubleList.toArray();
        for (Object i:arrays) {
            System.out.print(i+"、");
        }

    }
}
