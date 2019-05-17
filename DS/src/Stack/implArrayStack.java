package Stack;


import java.lang.reflect.Array;
import java.util.Arrays;

public class implArrayStack<T> implements Stack<T> {

    //存放数据的数组
    private Object [] data;
    //初始化大小
    private int size = 10;

    //当前个数
    private int concurrentSize = 0;


    @Override
    //入栈
    public boolean push(T t) {

        //如果为空，初始化数组
        if(isEmpty()){
            this.data = new Object[10];
        }

        //如果大于最大值，进行扩容
        if(this.concurrentSize >size){
            int oldSize = size;
            //扩容2倍
            int newSize = oldSize << 1;
            this.data = Arrays.copyOf(data,newSize);
            this.size = newSize;
        }

        this.data[concurrentSize] = t;
        concurrentSize++;
        return true;

    }

    @Override
    public T pop() {
        //栈为空的话，返回null
        if (isEmpty()){
            return null;
        }
        else {
            return (T) this.data[this.concurrentSize--];
        }
    }

    @Override
    public T peek() {
        if (isEmpty()){
            return null;
        }else{
            return (T)this.data[this.concurrentSize-1];
        }

    }

    @Override
    //当前个数
    public int getSize() {
        return concurrentSize;

    }

    @Override
    public boolean isEmpty() {
        if (concurrentSize == 0){
            return true;
        }
        return false;
    }




}
