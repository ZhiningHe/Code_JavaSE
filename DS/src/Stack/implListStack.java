package Stack;

public class implListStack<T> implements Stack<T>{
    //结点类
    private static class Node{
        private Object data;
        private Node next;

        public Node(Object node, Node next) {
            this.data = node;
            this.next = next;
        }
    }

    //标记栈顶
    Node top = new Node(null,null);
    //栈大小
    int concurrentSize = 0;


    @Override
    public boolean push(T t) {
        Node newNode = new Node(t,this.top.next);
        top.next = newNode;
        concurrentSize++;
        return true;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        //从链表里删除结点
        Node re = top.next;
        top.next = top.next.next;
        top.next.next = null;
        this.concurrentSize--;
        return (T)re;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return (T)top.next.data;
    }

    @Override
    public int getSize() {
        return concurrentSize;
    }

    @Override
    public boolean isEmpty() {
        if (this.concurrentSize ==0){
            return true;
        }
        return false;
    }
}
