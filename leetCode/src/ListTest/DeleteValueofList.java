package ListTest;
//删除链表中指定元素
public class DeleteValueofList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
    //方法一
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;

        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }

        return head;
    }
    //方法二
    //递归实现特定值的结点删除
    private ListNode remove(ListNode Head, int val){
             if(Head == null){
                 return Head;
             }
             //从这里一直递归直到把链表拆分成单个结点
             ListNode res = remove(Head.next,val);
             //从函数栈顶开始判断结点是不是要删除的
             if(Head.val == val){
                 //如果是，就直接返回头节点后的链表，也就是res链表
                 return res;
             }else {
                 //如果不是，就保存头节点，把Head保存并返回Head.next
                 Head.next = res;
                 return Head.next;
             }
             //三目运算
        // Head.next = Head.val == val ?  remove(Head.next,val) : remove(res,val);
    }
}
