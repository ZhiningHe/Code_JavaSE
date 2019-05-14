package JavaSE.JVM;


/**
 * 双重加锁双重判断
 * 懒汉式单例
 */
class Single{
    //对象使用volatile关键字保证可见性和有序性
    private static volatile Single single;
    //私有构造
    private Single(){}
    //类外调用静态方法
    public static Single get(){
        //1.第一次判断
        if(single == null){
            //第一次加锁，只允许一个线程修改
            synchronized (Single.class){
                //2.再次判断，确定第一个以后的线程不重复new对象
                if (single ==null){
                    single = new Single();
                }
            }
        }
        return single;
    }
}




public class Singletion {
    public static void main(String[] args) {

    }
}
