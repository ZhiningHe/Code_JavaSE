package Queue;


/**
 * 设置一个标记位，不放元素：
 * 为空： head == tail；  为满：（tail+1）%length == head
 * 数组实现
 */
public class cricleQueue<E> implements Queue<E> {

    public cricleQueue(int size) {
        //多开辟一块标记空间；要size+1
    }

    @Override
    public void enQueue(E e) {

    }

    @Override
    public E deQueue() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public int getSize() {

        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
