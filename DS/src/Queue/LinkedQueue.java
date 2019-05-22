package Queue;


/**
 *
 * @param <E>
 */
public class LinkedQueue<E> implements Queue<E> {

    //队列结点类
   private class Node{
        Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
        }
    }

    private int size =0;
    private Node head;
   private Node tail;

    /**
     * 尾插法入队
     * @param e
     */
    @Override
    public void enQueue(E e) {
        Node newNode = new Node(e);
        if(isEmpty()){
            head = tail =newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * 队头出队
     * @return
     */
    @Override
    public E deQueue() {
        if(isEmpty()){
            System.err.println("empty");
            return null;
        }else{
            Object tmp = head.data;
            head.data =null;
            head = head.next;
            size--;
            return (E) tmp;
        }
    }

    @Override
    public E peek() {
        if(isEmpty()){
            System.err.println("empty");
            return null;
        }else{
            return (E) head.data;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(head ==null && tail == null){
            return true;
        }
        return false;
    }

}
