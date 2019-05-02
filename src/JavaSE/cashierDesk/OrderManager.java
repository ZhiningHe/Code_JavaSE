package JavaSE.cashierDesk;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


/**
 * 对订单上的商品进行操作
 * 增、删、打印小票等操作
 */
public class OrderManager {
    //创建一个仓库类
    GoodsManage goodsManage ;
    //创建订单 商品序号、数量
    Map<Integer,Integer> orderMap = new HashMap<>();

    public OrderManager(GoodsManage goodsManage) {
        this.goodsManage = goodsManage;
    }
    //订单中增加商品
    public void add(int No){
        if(find(No)){
            //数量+1
            this.orderMap.replace(No,this.orderMap.get(No)+1);
        }else {
            //添加到清单中
            if(!goodsManage.find(No)){
                System.out.println("仓库中没有这个商品哦~去添加新商品！");
                return;
            }else{
                this.orderMap.put(No, 1);
            }
        }
        this.printOrder();
    }
    //订单中删除一个商品
    public void delete(int No){
        if(find(No)){
            if(this.orderMap.get(No)>1){
               //数量-1
                this.orderMap.replace(No,this.orderMap.get(No)-1);
            }
            //删除这个entry元素
            this.orderMap.remove(No);
        }
    }
    //订单中查找商品
    private boolean find(int No){
        if(!this.orderMap.containsKey(No)){
            System.out.println("订单中暂此商品~");
            return false;
        }
        return true;
    }
    //计算总金额
    private int sum(){
        int sum=0;
        Set<Map.Entry<Integer,Integer>> entrySet = this.orderMap.entrySet();
        Iterator<Map.Entry<Integer,Integer>> iterator = entrySet.iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,Integer> entry = iterator.next();
            sum += (this.goodsManage.getGood(entry.getKey()).price * entry.getValue());
        }
        return sum;
    }
    //打印小票
    public void printOrder(){
        Set<Map.Entry<Integer,Integer>> entrySet = this.orderMap.entrySet();
        Iterator<Map.Entry<Integer,Integer>> iterator = entrySet.iterator();
        System.out.println("                    ");
        System.out.println("        欢迎光临~~ 以下是您的购物清单     ");
        System.out.println("----货号----名称----数量----单价----");
        while (iterator.hasNext()){
            Map.Entry<Integer,Integer> entry = iterator.next();
            System.out.println("|-----"+entry.getKey()+"-----"
                    +this.goodsManage.getGood(entry.getKey()).name+"------"
                    +entry.getValue()+"件----"
                    +this.goodsManage.getGood(entry.getKey()).price+"元----|");
        }
        System.out.println("        总计金额："+sum() + "元");
        System.out.println("        生活愉快~欢迎下次前来选购~~~");
        System.out.println("---------------------------------");
        System.out.println("                    ");
    }
    //打印小票后清除本清单
    private void clearOrder(){
        this.orderMap.clear();
    }
}
