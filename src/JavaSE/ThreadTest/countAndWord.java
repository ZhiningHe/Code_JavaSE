package JavaSE.ThreadTest;

/**一个线程打印数字一个线程打印字母
 * 12A34B56C……5152Z
 */
public class countAndWord {
    private boolean flag = true;
    private int count =1;
    public synchronized void printNum(){
        //true打印数子
        if(flag == false){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(count*2-1);
        System.out.print(count*2);
        flag = false;
        notify();
    }

    public synchronized void printWord(){
        //false打印字母
        if(flag ==true){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print((char) ('A'+count-1));
        flag = true;
        count++;
        notify();
    }

    public static void main(String[] args) {
        countAndWord countAndWord = new countAndWord();
        new Thread(()->{
            for (int i=0;i<26;i++){
                countAndWord.printNum();
            }
        }).start();
        new Thread(()->{
            for (int i=0;i<26;i++){
                countAndWord.printWord();
            }
        }).start();
    }
}
