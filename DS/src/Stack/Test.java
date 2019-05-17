package Stack;

public class Test {
    public static void main(String[] args) {
        //implArrayStack arrayStack = new implArrayStack();
        implListStack arrayStack = new implListStack();
        arrayStack.push("en");
        arrayStack.push("heng");
        arrayStack.push("haha");
        arrayStack.push("hao");
        // 4
        System.out.println(arrayStack.getSize());
        //hao 出栈
        arrayStack.pop();
        //haha
        System.out.println(arrayStack.peek());
        //3
        System.out.println(arrayStack.getSize());
    }

}
