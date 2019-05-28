package JavaSE;

import java.util.HashMap;

/**
 * 对象回收自救
 */
public class Test{
    //GCRoots
    private static Test test;
    public void Alive(){
            System.out.println("i am alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("execute");
        //test与当前对象建立联系
        test = this;

    }


    public static void main(String[] args) throws Throwable {
        //----------第一次--------------
        //连接
        test = new Test();
        //断开连接
        test = null;
        //回收
        System.gc();
        Thread.sleep(500);
        //判断是否还活着
        if(test != null){
            test.Alive();
        }else{
            System.out.println("i am dead");
        }
        //----------第二次-finalize已被调用过------
        //自救会失败
        test = null;
        //回收
        System.gc();
        Thread.sleep(500);
        //判断是否还活着
        if(test != null){
            test.Alive();
        }else{
            System.out.println("i am dead");
        }
    }
}

