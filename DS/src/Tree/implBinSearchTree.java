package Tree;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

/**
 * 二分搜索树的实现
 * @param <E>
 */

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
    private static ArrayList<Integer> prelist = new ArrayList<>();
    private static ArrayList<Integer> orderlist = new ArrayList<>();


    @Override
    public void add(E e) {
         root = add(root,e);
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


    @Override
    public void preOrder() {
        preOrder(root);
    }

    @Override
    public void inOrder() {
        inOrder(root);
    }

    @Override
    public void postOrder() {
        postOrder(root);
    }

    @Override
    public void levelOrder() {
        levelOrder(root);
    }

    /**
     * 一直向左走，直到底
     */
    @Override
    public E getMin() {
        //中序遍历的第一个值就是最小值
        Object result = inOrder(root).get(0);
        return (E)result;
    }

    private Node getMin(Node node){
        if(node.left ==null){
            return node;
        }
        return getMin(node.left);
    }

    /**
     * 一直向右走，直到底
     */
    @Override
    public E getMax() throws Exception{
        if(root ==null){
            throw new Exception("root结点为空");
        }
        return getMax(root).data;
    }

    private Node getMax(Node node){
        if(node.right ==null){
            return node;
        }
        return getMax(node.right);
    }



    @Override
    public E rmMin() {
        return (E) removemin(root);
    }
    private Node removemin(Node node){
        //找到了最小值
        if(node.left ==null){
            //如果还有右边，就先保存起来
            Node noderight = node.right;
            //删除最小值
            node.right = null;
            size--;
            //返回剩下的右边树
            return noderight;

        }
        //上一级的左结点 接到 删除后剩下的右树
        node.left = removemin(node.left);
        //返回这个结点
        //最后一步层层拼接返回新的root
        return node;
    }

    @Override
    public E rmMax() {
        return (E)removemin(root);
    }
    private Node removemax(Node node){
        if(node.right ==null){
            Node leftnode = node.left;
            node.left = null;
            size--;
            return node;
        }
        node.right = removemin(node.right);
        return node;
    }

    @Override
    public boolean remove(E e) {
        root = remove(root,e);
        return true;
    }
    private Node remove(Node node,E e){
        if(node ==null){
            return null;
        }
        //在左边删
        if(e.compareTo(node.data)<0){
            node.left = remove(node.left,e);
        }
        //在右边删
        if(e.compareTo(node.data)>0){
            node.right = remove(node.right,e);
        }

        //正好等于值，已经找到
        else{
            //只有左孩子
            if(node.left!=null && node.right==null){
                Node nodeleft = node.left;
                size--;
                node.left = null;
                return nodeleft;
            }
            //只有右孩子
            if(node.left== null && node.right != null){
                Node noderight = node.right;
                size--;
                //删除
                node.right = null;
                return noderight;
            }
            //左右孩子都有
            if(node.left != null &&node.right!= null){
                //后继s（一定是叶子节点）
                Node s = getMin(node.right);
                //s.left = root.left
                s.left = node.left ;
                //把root的右数（除了s）连接到s.right上，
                // 也就是删除root的右边的最小值，返回的是删除后的树，
                //把树连给s.right
                s.right = removemin(node.right);
                //删除要删除的结点
                node.left = null;
                node.right = null;
                //返回s结点的树
                return s;
            }
        }
        //到最后把改变的node传出
        return node;
    }

    @Override
    public int size() {
        return size;
    }



    //以指定的Node为根节点插入
    private Node add(Node node,E e){
        //出口
        if(node ==null){
            Node newnode = new Node(e);
            size++;
            return newnode;
        }
        if(e.compareTo(node.data)<0 ){
            node.left = add(node.left,e);
        }
        if(e.compareTo(node.data)>0 ){
            node.right = add(node.right,e);
        }
        //返回插入后得结点
        return node;
    }

    //查找
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

    /**
     * 前序遍历
     */
    private ArrayList<Integer> preOrder(Node node) {
        //根左右
        if(node == null){
            return prelist;
        }
        prelist.add((Integer) node.data);
        preOrder(node.left);
        preOrder(node.right);
        return prelist;
    }
    /**
     * 中序遍历
     */
    private ArrayList<Integer> inOrder(Node node) {
        if(node == null){
            return orderlist;
        }
        inOrder(node.left);
        orderlist.add((Integer) node.data);
        inOrder(node.right);
        return orderlist;

    }

    /**
     *后序遍历
     */
    private void postOrder(Node node) {
        if(node == null){
            return;
        }
        inOrder(node.left);
        inOrder(node.right);
        System.out.println(node.data);
    }

    /**
     * 层序遍历
     * @param root
     */
    private void levelOrder(Node root) {
        if(root ==null){
            return;
        }
        while (true){
            System.out.println(root.data);
            if(root.left!=null){
                levelOrder(root.left);
            }else if(root.right !=null){
                levelOrder(root.right);
            }
        }
    }


}

