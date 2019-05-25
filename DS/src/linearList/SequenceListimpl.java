package linearList;

public class SequenceListimpl implements ISequence{
    //结点
    private class Node{
        Object data;
        Node next;
        //构造
        public Node(Object data) {
            this.data = data;
        }

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
        public Node() { }
    }


    //虚拟头节点
    private Node dummyHead;
    //私有头节点
    private Node head;
    //私有长度
    private int size;


    @Override
    public void add(Object data) {
        //创建节点
        insrt(data,size);
    }


    //头插法
    public void headInsert(Object data,int index){
        Node newdata = new Node(data);
        //拼接结点
        newdata.next = head;
        head = newdata;
        // head = new Node (data,head);
    }

   //插入到任意位置
    public boolean insrt(Object data,int index) {
        //判断index是否合法
    if(index<0 ||index>size){
        throw new IndexOutOfBoundsException("index illegal!");
    }
        //若为0 则调用add
    if(index==0){
        add(data);
        size++;
    }
    else {
        //找到index-1 前驱
    Node pre = head;
    for(int i=0; i<index -1; i++){
        pre = pre.next;
    }
        //插入
    Node newdata = new Node(data);
    newdata.next = pre.next;
    pre.next = newdata;
    // pre.next = new Node(data,pre.next);
    size++;
    }
        return true;
    }


    @Override
    public boolean remove(int index) {
        Node f = new Node();
        Node s = new Node();
        Node dummyhead = new Node();
        dummyhead = head;
        f = dummyhead;
        s = f.next;
        for(int i=0; i<index; i++){
            //找到删除的位置
            f = f.next;
            s = s.next;
        }
        //删除
        f.next = s.next;
        s.data = 0;
        s.next = null;
        s = f.next;
        size--;
        return true;
    }

    @Override
    public Object get(int index) {
        check(index);Node n = new Node();
        n = head;
        for(int i=0; i<index; i++){
            n = n.next;
        }
        return n.data;
    }

    @Override
    public Object contains(Object data) {
        Node n = new Node();
        for(n.next = head; n.next == null; n = n.next){
            if(data.equals(n.data)){
                return n.data;
            }
        }
        return false;
    }

    @Override
    public Object set(int index, Object newData) {
        check(index);
        insrt(newData,index);
        return newData;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        Node n = new Node();
        Node m = new Node();
        n = head;
        m = head.next;
        while (m != null) {
            n.data = 0;
            n.next = null;
            n = m;
            m = n.next;
        }
        size = 0;
    }

    public Object[] toArray() {
        Node n = new Node();
        n.next = head;
        Object []array = new Object[size];
        for(int i=0; i<size; i++){
            array[i] = n.data;
            n = n.next;
        }
        return array;
    }

    //遍历链表
    public void viewAllList(){
        Node n = new Node();
        for(n.next = head; n.next == null; n = n.next){
            System.out.print(n.data+"、");
        }
    }

    //判断index是否合法
    private boolean check(int index){
        if(index >=0 && index <size){
            return true;
        }
        return false;
    }
}
