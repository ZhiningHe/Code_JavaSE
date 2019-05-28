package Tree;

public class implBinSearchTree<E extends Comparable<E>> implements BinTree<E> {

    private class Node{
        E data;
        Node left;
        Node right;

        public Node(E e) {
            this.data = e;
        }
    }
    //根节点
    private Node root;
    //个数
    private int size = 0;

    @Override
    public void add(E e) {
        //树为空
        if(root == null){
            Node node = new Node(e);
            root = node;
        }else{
            add(root,e);
        }
    }

    //以指定的Node为根节点插入
    private void add(Node node,E e){
        //规定不允许重复
        if(node.data.compareTo(e) == 0){
            return;
        }
        //出口
       else if(e.compareTo(node.data) <0 && node.left == null ){
            Node newnode = new Node(e);
            node.left = newnode;
            size++;
        }
        else if(e.compareTo(node.data) >0 && node.right == null){
            Node newnode = new Node(e);
            node.right = newnode;
            size++;
        }

        //否则递归
        else if(e.compareTo(node.data) < 0){
            add(node.left,e);
        }else if(e.compareTo(node.data) >0){
            add(node.right,e);
        }
    }

    @Override
    public boolean contain(E e) {
        if(root == null){
            return false;
        }else if(root.data.compareTo(e) ==0){
            return true;
        }
        return contains(root,e);
    }

    private boolean contains(Node node,E e){
        //终止条件
        if(node.data.compareTo(e) == 0){
            return true;
        }
        if(node ==null){
            return false;
        }
        //递归寻找
        if(node.data.compareTo(e) < 0 && node.left != null){
            return contains(node.left,e);
        }
        if(node.data.compareTo(e) > 0 && node.right !=null){
            return contains(node.right,e);
        }
        return false;
    }



    @Override
    public void preOrder() {

    }

    @Override
    public void inOrder() {

    }

    @Override
    public void postOrder() {

    }

    @Override
    public E getMin() {
        return null;
    }

    @Override
    public E getMax() {
        return null;
    }

    @Override
    public E rmMin() {
        return null;
    }

    @Override
    public E rmMax() {
        return null;
    }

    @Override
    public boolean remove(E e) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }
}
