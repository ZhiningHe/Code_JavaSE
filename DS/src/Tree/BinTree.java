package Tree;

public interface BinTree<E> {
    void add(E e);
    boolean contain(E e);

    //三种遍历
    void preOrder();
    void inOrder();
    void postOrder();


    E getMin();
    E getMax();
    E rmMin();
    E rmMax();

    //移除指定值
    boolean remove(E e);
    int size();
}
