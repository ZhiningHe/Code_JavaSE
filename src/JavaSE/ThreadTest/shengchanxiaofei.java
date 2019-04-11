package JavaSE.ThreadTest;

/**
 * 第三方
 */
class Goods{
    private String goodsName;
    private Integer count = 0;
    //生产
    public synchronized void setGoods(String goodsName){
        while (this.count>0){
            try {
                System.out.println("仅剩"+this.count+"件产品了");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.goodsName = goodsName;
        this.count++;
        System.out.println("生产一个"+toString());
        notify();
    }
    //获取
    public synchronized void getGoods(){
        while (this.count == 0){
            try {
                System.out.println("商品卖完了~等等吧");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.count--;
        System.out.println("消费一个"+toString());
        notify();
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsName='" + goodsName + '\'' +
                ", count=" + count +
                '}';
    }
}

/**
 * 生产者
 */
class Producter implements Runnable{
    private Goods goods;

    public Producter(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        this.goods.setGoods("生产一个产品");
    }
}

/**
 * 消费者
 */
class Consumer implements Runnable{
    public Consumer(Goods goods) {
        this.goods = goods;
    }

    private Goods goods;
    @Override
    public void run() {
        this.goods.getGoods();
    }
}

public class shengchanxiaofei {
    public static void main(String[] args) {
        Goods goods = new Goods();
        Producter producter = new Producter(goods);
        Consumer consumer = new Consumer(goods);
        Thread thread1 = new Thread(producter);
        Thread thread2 = new Thread(consumer);
        thread1.start();
        thread2.start();
    }
}
