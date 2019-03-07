package linearList;

public class SequenceDoubleListimpl implements ISequence {
    //构造函数
    private class Node{
        public Node(Object data) {
            this.data = data;
        }
        public Node() { }

        public Node(Object data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        Object data;
        Node next;
        Node prev;
    }

    private int size = 0;
    private Node Head;
    private Node Last;



    @Override
    //尾插法
    public void add(Object data) {
        Node newnode = new Node(data,null,Last);
        if(Head == null){
            Head = newnode;
        }else{
            Last.next = newnode;
        }
        Last = newnode; //将尾节点移动到插入结点处
        size++;
    }

    @Override
    public boolean remove(int index) {
        checkIndex(index);
        Node toRemove = Search(index);
        if(toRemove.prev == null){//要删除的结点是头节点之后的
            Head = toRemove.next;
        }else{
            toRemove.prev.next =toRemove.next;
        }
        if(toRemove.next == null){//要删除的结点是尾节点之前的
            Last = toRemove.prev;
        }else{
            toRemove.next.prev = toRemove.prev;
        }
        size--;
        return true;
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        return Search(index).data;
    }

    @Override
    public Object contains(Object data) {
        Node tmp = Head;
        for(int i=0; i<size; i++){
            if(data.equals(tmp.data)){
                return i;//找到返回下标序列
            }
        }
        return -1;//没找到
    }

    @Override
    public Object set(int index, Object newData) {
        checkIndex(index);
        Node tmp = Search(index);
        tmp.data = newData;
        return tmp.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for(Node tmp = Head;tmp !=null;){
            Node next = tmp.next;
            tmp.next = tmp.prev =null;
            tmp.data = null;
            tmp = next;
        }
        size = 0;
    }

    @Override
    public Object[] toArray() {
        Object [] Arrays = new Object[size];
        int i=0;
        if(size == 0){
            return new Object[]{0};
        }else {
            for (Node node = Head; node != null; node = node.next) {
                Arrays[i++] = node.data;
            }
            return Arrays;
        }
    }

    //检查index是否合法
    private void checkIndex(int index){
        if(index<0 || index >= size){
           throw  new IndexOutOfBoundsException("index error!");
        }
    }

    //遍历查找某个结点
    private Node Search(int index){
        checkIndex(index);
        Node tmp = Head;
        if(Head == null){
            return Head;
        }
        for(int i=0; i<index; i++){
            tmp = tmp.next;
        }
        return tmp;
    }
}
