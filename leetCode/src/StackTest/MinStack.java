package StackTest;

import java.util.Stack;

/**
 * 1. 双栈解法:一个栈存放最小值，一个栈存放元素
 * 2. 单栈：既存放数据，又直到当前最小值,栈内存放的元素块分成两部分：a（真实值），b（最小值）
 */


//1。

class MinStack1 {
   private Stack<Integer> stack ;
   private Stack<Integer> minStack ;
    /** initialize your data structure here. */
    public MinStack1() {
        //1. 创建两个栈实现
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        //小于等于的放入
        if(minStack.empty()){
            minStack.push(x);
        }
        if(stack.isEmpty()||x <= minStack.peek() ){
            minStack.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        if(minStack.peek().equals(stack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
       return stack.peek();
    }

    public int getMin() {
       return minStack.peek();
    }
}

//2.

class MinStack2{
    private Stack<Integer> stack = new Stack<>();

    public MinStack2() { }

    public void push(int x) {
        int tmp = stack.peek();
        //如果为空，直接入栈两次
        if(stack.isEmpty()){
            stack.push(x);
            stack.push(x);
        }else {
            //先把数值入栈
            stack.push(x);
            //判断小的值然后选择插入
            if (x < tmp) {
                stack.push(x);
            } else {
                stack.push(tmp);
            }
        }
    }

    public void pop() {
        stack.pop();
        stack.pop();
    }

    public int top() {
        //最小值先存下来
        int tmp = stack.peek();
        //弹出最小值
        stack.pop();
        //如果弹出数值和最小值不相等
        int result = stack.peek();
        stack.push(tmp);
        return result;
    }

    public int getMin() {
       return stack.pop();
    }
}

public class MinStack{
    public static void main(String[] args) {

    }
}