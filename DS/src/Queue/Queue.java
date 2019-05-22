package Queue;

public interface Queue<E>{

    //入队
    void enQueue(E e);

    //出队
    E deQueue();

    //返回队头
    E peek();

    //返回长度
    int getSize();

    boolean isEmpty();

}