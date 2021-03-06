package Tree;

import java.sql.Statement;
import java.util.*;

/**
 * 二分搜索树的实现
 * @param <E>
 */

public class implBinSearchTree<E extends Comparable<E>> implements BinTree<E> {

    private class Node {
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



    //添加元素
    @Override
    public void add(E e) {
        root = add(root, e);
    }
    //查找值
    @Override
    public boolean contain(E e) {
        if (root == null) {
            return false;
        } else if (root.data.compareTo(e) == 0) {
            return true;
        }
        return contains(root, e);
    }

    //前序遍历
    @Override
    public void preOrder() {
        preOrder(root);
        for (Integer i:prelist
             ) {
            System.out.print(i+"、");
        }
    }
    //中序遍历
    @Override
    public void inOrder() {
        inOrder(root);
        for (Integer i:orderlist
                ) {
            System.out.print(i+"、");
        }
    }
    //后序遍历
    @Override
    public void postOrder() {
        postOrder(root);
    }
    //层序遍历
    @Override
    public void levelOrder() {
        levelOrder(root);
    }

    //获取最小值（左）
    @Override
    public E getMin() {
        //中序遍历的第一个值就是最小值
        Object result = inOrder(root).get(0);
        return (E) result;
    }
    private Node getMin(Node node) {
        if (node.left == null) {
            return node;
        }
        return getMin(node.left);
    }

    //获取最大值（右）
    @Override
    public E getMax() throws Exception {
        if (root == null) {
            throw new Exception("root结点为空");
        }
        return getMax(root).data;
    }
    private Node getMax(Node node) {
        if (node.right == null) {
            return node;
        }
        return getMax(node.right);
    }

    //删除最小值
    @Override
    public E rmMin() {
        return (E) removemin(root);
    }
    private Node removemin(Node node) {
        //找到了最小值
        if (node.left == null) {
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

    //删除最大值
    @Override
    public E rmMax() {
        return (E) removemin(root);
    }
    private Node removemax(Node node) {
        if (node.right == null) {
            Node leftnode = node.left;
            node.left = null;
            size--;
            return node;
        }
        node.right = removemin(node.right);
        return node;
    }

    //删除指定结点
    @Override
    public boolean remove(E e) {
        root = remove(root, e);
        return true;
    }
    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        //在左边删
        if (e.compareTo(node.data) < 0) {
            node.left = remove(node.left, e);
            return node;
        }
        //在右边删
        if (e.compareTo(node.data) > 0) {
            node.right = remove(node.right, e);
            return node;
        }

        //正好等于值，已经找到
        else {
            if (node.left == null) {
                Node noderight = node.right;
                size--;
                //删除
                node.right = null;
                return noderight;
            }
            if (node.right == null) {
                Node nodeleft = node.left;
                size--;
                node.left = null;
                return nodeleft;
            }
            //左右孩子都有
            //后继s（一定是叶子节点）
            Node s = getMin(node.right);
            s.right = removemin(node.right);
            //s.left = root.left
            s.left = node.left;
            //删除要删除的结点
            node.left = node.right = null;
            //返回s结点的树
            return s;
            //到最后把改变的node传出
        }
}

    //返回树的个数
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
        if(e.compareTo(node.data)<=0 ){
            node.left = add(node.left,e);
        }
        if(e.compareTo(node.data)>=0 ){
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
    //前序遍历
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
    //中序遍历
    private ArrayList<Integer> inOrder(Node node) {
        if(node == null){
            return orderlist;
        }
        inOrder(node.left);
        orderlist.add((Integer) node.data);
        inOrder(node.right);
        return orderlist;

    }
    //后序遍历
    private void postOrder(Node node) {
        if(node == null){
            return;
        }
        inOrder(node.left);
        inOrder(node.right);
        System.out.println(node.data);
    }
    //层序遍历
    private void levelOrder(Node root) {
        if (root ==null) return ;
        Queue<Node> level = new LinkedList<>();
        //根节点入队
        level.add(root);
        while (!level.isEmpty()){
            //先保存这个Node
            Node tmp = level.poll();
            //输出队头元素
            System.out.print(tmp.data+"、");
            //再添加子节点，按左右顺序添加
            if (tmp.left!=null)
            level.add(tmp.left);
            if (tmp.right!=null)
            level.add(tmp.right);
        }
    }
}

