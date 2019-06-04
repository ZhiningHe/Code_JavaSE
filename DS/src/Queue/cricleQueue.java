package Queue;


/**
 * 设置一个标记位，不放元素：
 * 为空： head == tail；  为满：（tail+1）%length == head
 * 数组实现
 */



public class cricleQueue<E> implements Queue<E> {
    int[] data;
    int head = 0;
    int tail = 0;
    int size =0;
    int max ;
    public cricleQueue(int k) {
        this.max = k;
        this.data = new int[k];
    }

    @Override
    public void enQueue(E e) {
        if(size == max){
            return;
        }
    //   data[tail%max] = (int) e;
        tail++;
        size++;
    }

    @Override
    public E deQueue() {

        if(size ==0){

        }
        Object tmp = data[head];
        size--;
        head++;
        return (E) tmp;
    }

    @Override
    public E peek() {
        if(size ==0){

        }
        Object tmp = data[head];
        return (E) tmp;

    }

    @Override
    public int getSize() {

        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == max;
    }
}
