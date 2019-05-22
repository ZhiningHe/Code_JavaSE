package Queue;

public class Test {
    public static void main(String[] args) {
        //LinkedQueue queue = new LinkedQueue();
        arrayQueue queue = new arrayQueue(3);
        //true
        System.out.println(queue.isEmpty());
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.deQueue();
        queue.enQueue(4);
        queue.deQueue();
        //2
        System.out.println(queue.peek());
    }
}
