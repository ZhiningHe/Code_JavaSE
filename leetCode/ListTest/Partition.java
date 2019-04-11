package ListTest;
//以给定值x为基准将链表分割成两部分，
// 所有小于x的结点排在大于或等于x的结点之前
public class Partition {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode partition(ListNode pHead, int x) {
        if (pHead == null || pHead.next == null) return null;

        //用三个指针实现
        ListNode dummyhead = new ListNode(-1);//定义虚拟头节点
        dummyhead.next = pHead;
        ListNode prev = dummyhead;
        ListNode cur = prev.next;
        ListNode insert = dummyhead;
        //因为要求结点顺序不变
        // 所以定义一个指针放在插入结点处

        while (cur != null) {
            if (cur.val < x) {//如果结点值小于x 就把结点移动到insert位置处
                prev.next = cur.next;
                cur.next = insert.next;
                insert.next = cur;
                insert = insert.next;
            }
            prev = prev.next;
            cur = prev.next;
        }
        return dummyhead.next;
    }
}
