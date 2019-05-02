package JavaSE.cashierDesk;

import java.util.*;

/**
 * 商品类
 * 属性有 货品名称、价格
 */
class Goods{
    public String name;
    public int price;

    public Goods(String name, int price) {
        this.name = name;
        this.price = price;
    }

}


/**
 * 商品管理
 * 定义一个货品的存储仓库hashmap
 * 用货号进行查找，货号唯一
 * 完成在仓库内 增删改查 商品的操作
 */
public class GoodsManage {
    Map<Integer,Goods> goodsMap = new HashMap<>();

    public GoodsManage() { }
    //增加商品
    public void add(int No,String name,int price){
        if(!find(No)){
            System.out.println("正在加入……");
            System.out.println("加入成功！");
            Goods goods = new Goods(name,price);
            if(name != null){
                //把新创建的goods加入到map里
                this.goodsMap.put(No,goods);
            }
        }else {
            System.out.println("                     ");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("此商品货号已被设置！请检查~");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("                     ");
        }
    }

    //删除商品
    public void delete(int No){
        //查找有没有这个entry元素
        if(find(No)) {
            //有的话直接删除
            this.goodsMap.remove(No);
        }
    }

    //改正商品
    public void change(int No,String name, int price){
        //查找有没有这个entry元素
        if(find(No)){
            //有的话直接删除
            delete(No);
        }
        //把新的属性添加到hashmap中
        add(No,name,price);
        this.printGoods();
    }

    //查找商品
    public boolean find(int No){
        //查找有没有这个entry元素
        if(!this.goodsMap.containsKey(No)){
            System.out.println("很抱歉！没有此商品~");
            return false;
        }
        return true;
    }

    //返回这个产品
    public Goods getGood(int No){
         if(find(No)) {
            return this.goodsMap.get(No);
        }
        return null;
    }

    //打印仓库已有商品
    public void printGoods(){
        Set<Map.Entry<Integer,Goods>> entrySet = this.goodsMap.entrySet();
        Iterator<Map.Entry<Integer,Goods>> iterator = entrySet.iterator();
        System.out.println("----货号----名称----价格----");
        while (iterator.hasNext()){
            Map.Entry<Integer,Goods> entry = iterator.next();
            System.out.println("|-----"+entry.getKey()+"-----"
                    +entry.getValue().name+"------"
                    +entry.getValue().price+"----|");
        }
        System.out.println("----------------------------");
    }
}
