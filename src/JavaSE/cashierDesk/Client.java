package JavaSE.cashierDesk;
import java.util.Scanner;


/**
 * 收银台主菜单
 */

public class Client {
    public static void main(String[] args) {
        boolean flag = true;
        GoodsManage goodsManage = new GoodsManage();
        OrderManager orderManager = new OrderManager(goodsManage);
        //接收用户的输入并正确跳转
        while (flag){
            System.out.println("***********主菜单**********");
            System.out.println("----------[U]-使用---------");
            System.out.println("----------[S]-设置---------");
            System.out.println("----------[Q]-退出---------");
            System.out.println("----------[A]-关于---------");
            System.out.println("***************************");


            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNext()){
                String choose = scanner.next();
                switch (choose){
                    case "Q":
                        flag = false;
                        break;

                    case "U":
                        Clients.U(orderManager);
                        break;

                    case "S":
                        Clients.S(goodsManage);
                        break;

                    case "A":
                        Clients.A();
                        break;
                }
            }
        }
    }

}

//客户端工具类
class Clients{
    //关于
    public static void A(){
        System.out.println("*************************************");
        System.out.println("**       名称：收银台                **");
        System.out.println("**       功能：收银系统              **");
        System.out.println("**       作者：致宁                  **");
        System.out.println("**       意见反馈：zhining@163.com   **");
        System.out.println("*************************************");
    }

    //设置
    public static void S(GoodsManage goodsManage) {
        boolean flagg = true;
        System.out.println("**************设置*************");

        while (flagg) {
        System.out.println("----------[A]-加入商品-------");
        System.out.println("----------[D]-删除商品--------");
        System.out.println("----------[C]-修改商品-----");
        System.out.println("----------[F]-查找商品-------");
        System.out.println("----------[Q]-返回上一层-------------");
        System.out.println("----------[M]-跳到主菜单-------------");
        System.out.println("*******************************");

        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
            if (scanner.hasNext()) {
                String choose = scanner.next();
                switch (choose) {
                    case "Q":
                        flagg = false;
                        System.out.println("*********退出*********");
                        break;

                    case "M":
                        return;

                    case "A":
                        while (flag) {
                            flag = addgoods(goodsManage);
                        }
                        break;

                    case "D":
                        while (flag) {
                            flag = delgoods(goodsManage);
                        }
                        break;

                    case "C":
                        while (flag) {
                            flag = changeGoods(goodsManage);
                        }
                        break;

                    case "F":
                        goodsManage.printGoods();
                        while (flag) {
                            flag = findgoods(goodsManage);
                        }
                        break;
                    default:
                        System.out.println("输入错误，请重新输入~~");

                }

                System.out.println("***********请选择操作：************");
            }
        }
    }
    //使用
    public static void U(OrderManager orderManager){
        boolean flagg = true;
        System.out.println("**************欢迎使用ZN收银台**************");

        while (flagg) {
            System.out.println("----------[A]-加入商品-------");
            System.out.println("----------[D]-删除商品--------");
            System.out.println("----------[O]-打印小票--------");
            System.out.println("----------[Q]-返回上一层-------------");
            System.out.println("----------[M]-跳到主菜单-------------");
            System.out.println("*******************************");

            boolean flag = true;
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNext()) {
                String choose = scanner.next();
                switch (choose) {
                    case "Q":
                        flagg = false;
                        System.out.println("*********退出*********");
                        break;

                    case "M":
                        return;

                    case "A":
                        while (flag) {
                            flag = addOrder(orderManager);
                        }
                        break;

                    case "D":
                        while (flag) {
                            flag = delOrder(orderManager);
                        }
                        break;

                    case "O":
                        orderManager.printOrder();
                        //打印完毕之后清空记录，开始下一个清单
                        orderManager.orderMap.clear();
                        break;

                    default:
                        System.out.println("输入错误，请重新输入~~");

                }
                System.out.println("***********请选择操作：************");
            }
        }
    }

    //仓库中的一些操作
    private static boolean addgoods(GoodsManage goodsManage) {
        System.out.println("*********加入商品--输入Q退出*********");
        System.out.println("请输入要加入仓库的商品序号、名称、价格（空格分开）：");
        Scanner in = new Scanner(System.in);
        if (in.hasNext()) {
            String input = in.nextLine();
            if ("Q".equals(input)) {
                return false;
            } else {
                String[] arrs = input.split(" ");
                int No = Integer.valueOf(arrs[0]).intValue();
                String name = arrs[1];
                int price = Integer.valueOf(arrs[2]).intValue();
                goodsManage.add(No, name, price);
                goodsManage.printGoods();
            }
        }
        return true;
    }
    private static boolean delgoods(GoodsManage goodsManage){
        System.out.println("*********删除--输入Q退出*********");
        System.out.println("请输入要从仓库删除的[商品序号]：");
        Scanner in = new Scanner(System.in);
        if (in.hasNext()) {
            String input = in.nextLine();
            if ("Q".equals(input)) {
                return false;
            } else {
                int No = Integer.valueOf(input).intValue();
                goodsManage.delete(No);
                System.out.println("删除成功！");
                goodsManage.printGoods();
            }
        }
        return true;
    }
    private static boolean changeGoods(GoodsManage goodsManage) {
        System.out.println("*********修改商品--输入Q退出*********");
        System.out.println("请输入要修改仓库[商品序号]以及[修改后的名称、价格]（空格分开）：");
        Scanner in = new Scanner(System.in);
        if (in.hasNext()) {
            String input = in.nextLine();
            if ("Q".equals(input)) {
                return false;
            } else {
                String[] arrs = input.split(" ");
                int No = Integer.valueOf(arrs[0]).intValue();
                String name = arrs[1];
                int price = Integer.valueOf(arrs[2]).intValue();
                goodsManage.change(No,name,price);
            }
        }
        return true;
    }
    private static boolean findgoods(GoodsManage goodsManage) {
        System.out.println("*********查找--输入Q退出*********");
        System.out.println("请输入要从仓库查找的[商品序号]：");
        Scanner in4 = new Scanner(System.in);
        if (in4.hasNext()) {
            String input4 = in4.nextLine();
            if ("Q".equals(input4)) {
                return false;
            } else {
                int No4 = Integer.valueOf(input4).intValue();
                //找到了返回商品名称和价格
                if (goodsManage.find(No4)) {
                    System.out.println("仓库内有此商品！"
                            + "{商品名称：" + goodsManage.getGood(No4).name + " || 商品价格："
                            + goodsManage.getGood(No4).price + "}");
                }
            }

        }
        return true;
    }

    //清单里的一些操作
    private static boolean addOrder(OrderManager orderManager) {
    System.out.println("*********添加清单--输入Q退出*********");
    System.out.println("请输入要加入清单的商品序号：");
    Scanner in = new Scanner(System.in);
    if (in.hasNext()) {
        String input = in.next();
        if ("Q".equals(input)) {
            return false;
        } else {
            int No = Integer.valueOf(input).intValue();
            orderManager.add(No);
        }
    }
    return true;
}
    private static boolean delOrder(OrderManager orderManager) {
    System.out.println("*********移除清单--输入Q退出*********");
    System.out.println("请输入要移除清单的商品序号：");
    Scanner in = new Scanner(System.in);
    if (in.hasNext()) {
        String input = in.nextLine();
        if ("Q".equals(input)) {
            return false;
        } else {
            int No = Integer.valueOf(input).intValue();
            orderManager.delete(No);
        }
    }
    return true;
}

}
