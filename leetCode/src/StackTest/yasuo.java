package StackTest;

import java.util.Scanner;
import java.util.Stack;

//HG[3|B[2|CA]]F
//HG BCACA BCACA BCACA F

//未完
public class yasuo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] data = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();
        Stack<Character> stacktmp = new Stack<Character>();
        //把[之前的先存起来
        int i=0;
        while (data[i++] != '['){
            sb.append(data[i]);
        }
        while (i<data.length){
            if (data[i] != ']'){
                stack.push(data[i++]);
            }
            else{
                while (true){
                    if (stack.peek() == '['){
                        stack.pop();
                        break;
                    }else{
                        stacktmp.push(stack.pop());
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                while (!stacktmp.empty()){
                    stringBuilder.append(stacktmp.pop());
                }
                for (int q=0;q<stacktmp.pop();q++){
                    stringBuilder.append(stringBuilder);
                }
                sb = stringBuilder;
            }
        }
    }
}
