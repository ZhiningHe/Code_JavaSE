package JavaSE.JVM;

/**
 * -Xss128k
 * 栈溢出
 */

class SOF{
    static int length = 0;
    public void stackOverFlow(){
        length++;
        stackOverFlow();
    }
}

public class Test2 {
    public static void main(String[] args) {
        SOF sof = new SOF();
        try{
            sof.stackOverFlow();
        }catch (Throwable e){
            System.out.println("stack Over Flow");
            e.printStackTrace();
        }
    }
}
