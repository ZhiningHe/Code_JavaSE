package StackTest;

import java.util.Stack;



    /**
     * 用两个栈实现一个队列
     *
     * 通过
     */

    class Solution {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public Solution() {
            stack1 = new Stack();
            stack2 = new Stack();
        }


        /** Push element x to the back of queue. */
        public void push(int x) {
            stack1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if(stack2.isEmpty()){
                while (!stack1.isEmpty()) {
                    int tmp = stack1.peek();
                    stack1.pop();
                    stack2.push(tmp);
                }
            }
            return stack2.pop();
        }

        /** Get the front element. */
        public int peek() {
            if(stack2.isEmpty()){
                while (!stack1.isEmpty()) {
                    int tmp = stack1.peek();
                    stack1.pop();
                    stack2.push(tmp);
                }
            }
            return stack2.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }
public class QueueBytwostack {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.push(1);
        solution.push(2);
        solution.push(3);
        solution.push(4);
        solution.push(5);
        solution.push(6);
        System.out.println(solution.pop());
        System.out.println(solution.pop());
        System.out.println(solution.pop());

    }
}