package Queue;

public class arrayQueue<E> implements Queue<E> {
    private int head,tail;
    private Object[] data;

    public arrayQueue(int Arraysize) {
        data = new Object[Arraysize];
    }

    @Override
    public void enQueue(E e) {
        //tail指向尾部后一个元素
        if (tail == data.length){
            //向前移动head个位置
            for(int i = head; i<tail; i++){
                data[i-head] = data [i];
            }
        }
        tail -= head;
        head =0;
        data[tail] =  e;
        tail++;
    }

    @Override
    public E deQueue() {
        if(isEmpty()){
            System.err.println("队列已满");
            return null;
        }
        Object tmp = data[head];
        head++;
        return (E) tmp;
    }

    @Override
    public E peek() {
        if(isEmpty()){
            System.err.println("队列已满");
            return null;
        }
        return (E) data[head];
    }

    @Override
    public int getSize() {
        return tail-head;
    }

    @Override
    public boolean isEmpty() {
        if (getSize()== 0) {
            return true;
        }
        return false;
    }
}
