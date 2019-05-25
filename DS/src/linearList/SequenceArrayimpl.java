package linearList;

import java.util.Arrays;

public class SequenceArrayimpl implements ISequence {
    private int staticlen = 2;
    private Object [] array = new Object[staticlen];
    private int realen;

//ok
    @Override
    public void add(Object data) {
        if(realen + 1 <= staticlen){
            array[realen++] = data;
        }
        //扩容 再添加
        else {
            array = expandrange(array);
            add(data);
        }
    }

    @Override
    public boolean remove(int index) {
        if(index >=0 || index <realen){
            System.arraycopy(array,index+1,array,index,realen-index);
            realen--;
            return true;
        }
        return false;
    }
//ok
    @Override
    public Object get(int index) {
        if(index <= 0 || index >= realen) {
            return -1;
        }
        return array[index];
    }
//ok
    @Override
    public Object contains(Object data) {
        for (int i=0; i<realen; i++)
            if (data.equals(array[i])) {
                return i;
            }
        return -1;
    }
//ok
    @Override
    public Object set(int index, Object newData) {
        if(get(index) != null) {
            array[index] = newData;
            realen++;
            return array[index];
        }
        return null;
    }
//ok
    @Override
    public int size() {
        return realen;
    }

//ok
    @Override
    public void clear() {
        for(int i=0; i<realen; i++){
            array[i] = null;
        }
        realen = 0;
    }
    @Override
    public Object[] toArray() {
        return array;
    }

    //ok
    //扩容
    private Object[] expandrange(Object[] array){
        staticlen =staticlen * 2;
        return Arrays.copyOf(array,staticlen);
    }
}
