package JavaSE.cashierDesk;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class OrderManager {
    //创建一个仓库类
    GoodsManage goodsManage = new GoodsManage();
    //创建订单 仓库内有序号、数量
    Map<Integer,Integer> orderMap = new HashMap<>();

    //订单中增加商品
    public void add(int No){
        if(find(No)){
            //数量+1
           orderMap.replace(No,orderMap.get(No)+1);
        }
        //添加到清单中
        orderMap.put(No,1);
    }

    //订单中删除一个商品
    public void delete(int No){
        if(find(No)){
            if(orderMap.get(No)>1){
               //数量-1
                orderMap.replace(No,orderMap.get(No)-1);
            }
            //删除这个entry元素
            orderMap.remove(No);
        }
    }

    //订单中查找商品
    public boolean find(int No){
        if(!orderMap.containsKey(No)){
            System.out.println("很抱歉！订单中查无此商品~");
            return false;
        }
        return true;
    }

    //计算总金额
    public int sum(Map<Integer,Integer> orderMap){
        int sum=0;
        Set<Map.Entry<Integer,Integer>> entrySet = orderMap.entrySet();
        Iterator<Map.Entry<Integer,Integer>> iterator = entrySet.iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,Integer> entry = iterator.next();
            sum += goodsManage.getGood(entry.getKey()).price;
        }
        return sum;
    }

}
