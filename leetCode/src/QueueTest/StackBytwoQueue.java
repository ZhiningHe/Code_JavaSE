package QueueTest;

import java.util.LinkedList;
import java.util.Queue;


/**
 * 两个队列实现一个栈
 * 已通过
 */
class MyStack {
    private Queue<Integer> queueA = new LinkedList<>();
    private Queue<Integer> queueB = new LinkedList<>();
    /** Initialize your data structure here. */
    public MyStack() {
    }

    /** Push element x onto stack. */
    public void push(int x) {
        // 保证所有元素都在一个队列中
        if (queueA.isEmpty()) {
            queueB.add(x);
        }else {
            queueA.add(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        //如果A是空，元素都在B中
        if (queueA.isEmpty()) {
            int len = queueB.size();
            //除最后一个元素外，都移动到A中
            for (int i = 0;i < len - 1;i++) {
                queueA.add(queueB.poll());
            }
            // 队列B的最后一个元素一定是最后进入的
            // 刚好是栈的栈顶元素
            int result = queueB.poll();
            return result;
        }
        else {
            int len = queueA.size();
            for (int i = 0;i < len - 1;i++) {
                // 所有元素依次放入队列A中
                queueB.add(queueA.poll());
            }
            // 队列B的最后一个元素一定是最后进入的
            // 刚好是栈的栈顶元素
            int result = queueA.poll();
            return result;
        }
    }

    /** Get the top element. */
    public int top() {
        if (queueA.isEmpty()) {
            int len = queueB.size();
            for (int i = 0;i < len - 1;i++) {
                // 所有元素依次放入队列A中
                queueA.add(queueB.poll());
            }
            // 队列B的最后一个元素一定是最后进入的
            // 刚好是栈的栈顶元素
            int result = queueB.poll();
            //最后一个元素插入到A中
            queueA.add(result);
            return result;
        }
        else {
            int len = queueA.size();
            for (int i = 0;i < len - 1;i++) {
                // 所有元素依次放入队列A中
                queueB.add(queueA.poll());
            }
            // 队列B的最后一个元素一定是最后进入的
            // 刚好是栈的栈顶元素
            int result = queueA.poll();
            queueB.add(result);
            return result;
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queueA.isEmpty() && queueB.isEmpty();
    }
}


public class StackBytwoQueue{
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);

        System.out.println(stack.top());//2
        System.out.println(stack.pop());//2

    }
}