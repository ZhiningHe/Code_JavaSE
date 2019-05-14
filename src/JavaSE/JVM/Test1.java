package JavaSE.JVM;


import java.util.ArrayList;
import java.util.List;

/**
 * 参数：-xmx20m -Xms20m -XX:+HeapDumpOnOutOfMemeryError
 * 写一个堆溢出
 */
public class Test1 {

    static class OOM{

    }
    public static void main(String[] args) {
        List<OOM> list = new ArrayList<>();
        while (true){
            list.add(new OOM());
        }
    }
}
