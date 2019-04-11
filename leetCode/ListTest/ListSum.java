package ListTest;
//实现两个链表对应位置相加，大于10可以进一位
public class ListSum {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }
    // 2->4->3
    // 5->6->4
    // 7->0->8

    //方法一
    public ListNode Sum (ListNode l1,ListNode l2){
        ListNode dummyhead = new ListNode(-1);//结果链表的虚拟头节点
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode cur = dummyhead;//分别指向三个链表的指针
        int sum =0;
        if(node1 ==null ||node2 ==null){
            //边界处理
            return null;
        }
        while (node1 !=null ||node2 !=null){
            if(node1 != null){
                //node1如果还有元素就继续相加
                sum += node1.val;
                node1 = node1.next;
            }
            if(node2 !=null){
                //node1如果还有元素就继续相加
                sum += node2.val;
                node2 = node2.next;
            }
            //创建新结点
            cur.next = new ListNode(sum%10);
            cur = cur.next;
            //如果sum>10 那么下一次就会进一位
            sum /= sum;
        }
        if(sum == 1){
            //最后一次还可以进一位 那就在创建一个结点续着
            cur.next = new ListNode(1);
        }
        //返回结果链表真正的头结点
        return dummyhead.next;
    }

    //方法二
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
                //新链表虚拟头节点
                ListNode dummyHead = new ListNode(0);
                ListNode p = l1, q = l2, curr = dummyHead;
                //表示给下一位进的数
                int carry = 0;
                while (p != null || q != null) {
                    int x = (p != null) ? p.val : 0;
                    int y = (q != null) ? q.val : 0;
                    int sum = carry + x + y;//先加1后除10
                    //修改carry的值 给下一位使用
                    carry = sum / 10;
                    curr.next = new ListNode(sum % 10);
                    curr = curr.next;
                    if (p != null) p = p.next;
                    if (q != null) q = q.next;
                }
                //循环完毕，如果还要进位在创建一个结点
                if (carry > 0) {
                    curr.next = new ListNode(carry);
                }
                return dummyHead.next;
            }
}
