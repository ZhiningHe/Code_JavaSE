package StackTest;

import java.util.Scanner;
import java.util.Stack;

public class kuoHaoPiPei {

   static boolean isValid(String s) {
        char[] data = s.toCharArray();
        Stack<Character> stack = new Stack();
        for (int i = 0; i < data.length; i++) {
            //为前括号直接入栈
            if (data[i] == '(' || data[i] == '{' || data[i] == '[') {
                stack.push(data[i]);
                //如果第一个字符就是后括号，直接跳出
            } else if (stack.isEmpty() && (data[i] == ')'||data[i] == '}'||data[i] == ']')){
                return false;
            }//匹配验证
            else if ((data[i] == ')' && (stack.peek() )== '(')
                    || (data[i] == '}' && stack.peek() == '{')
                    || ( (data[i] == ']') && (stack.peek() == '[') )) {
                stack.pop();
                //其他情况
            } else {
                return false;
            }
        }
        //结束后检查是不是空栈
        if(stack.isEmpty()){
            return true;
        }
     return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        System.out.println(isValid(text));
    }
}
