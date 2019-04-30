package JavaSE.cashierDesk;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        boolean flag = true;
        //接收用户的输入并正确跳转
        while (flag){
            System.out.println("----------主菜单-----------");
            System.out.println("----------[Q]-退出---------");
            System.out.println("----------[U]-使用---------");
            System.out.println("----------[S]-设置---------");
            System.out.println("----------[A]-关于---------");
            System.out.println("---------------------------");


            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNext()){
                String choose = scanner.next();
                switch (choose){
                    case "Q":
                        System.out.println("--------退出--------");
                        flag = false;
                        break;
                    case "U":
                        System.out.println("--------使用--------");
                        break;
                    case "S":
                        System.out.println("--------设置--------");
                        Clients.S();
                        break;
                    case "A":
                        System.out.println("--------信息--------");
                        Clients.A();
                        break;
                }
            }
        }
    }

}

//客户端工具类
class Clients{

    public static void A(){
        System.out.println("       名称：收银台");
        System.out.println("       功能：收银系统");
        System.out.println("       作者：致宁");
        System.out.println("       意见反馈：zhining@163.com");
    }

    public static void S(){
        System.out.println("----------[add]-加入商品-----");
        System.out.println("----------[del]-删除商品-----");
        System.out.println("----------[cha]-修改商品-----");
        System.out.println("----------[find]-查找商品----");
        System.out.println("----------------------------");

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()){
            String choose = scanner.next();
            switch (choose){
                case "add":
                    System.out.println("--------加入--------");
                    break;

                case "del":
                    System.out.println("--------删除--------");
                    System.out.println("请输入要删除的商品序号：");
                    Scanner s = new Scanner(System.in);
                    if(scanner.hasNext()) {
                        String c = scanner.next();
                        int No = Integer.valueOf(c).intValue();
                        GoodsManage goodsManage = new GoodsManage();
                        goodsManage.delete(No);
                    }
                    break;

                case "cha":
                    System.out.println("--------修改--------");
                    break;
                case "find":
                    System.out.println("--------查找--------");
                    break;
            }
        }
    }
}

class S{
    public void add(){

    }

}