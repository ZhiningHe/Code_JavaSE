package Stack;


interface Stack<T>{

    //入栈
    boolean push(T t);

    //出栈
    T pop();

    //输出栈顶元素，不出栈
    T peek();

    //获取栈内元素个数
    int getSize();

    //判断是不是空
    boolean isEmpty();
}


