package ListTest;


public class HasCycle {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    //给定一个链表，判断链表中是否有环。
//
//为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
// 如果 pos 是 -1，则在该链表中没有环。
    public boolean hasCycle(ListNode head) {
        //利用快慢指针来寻找 如果有环就一定会相遇
        ListNode p = head, p2 = head;
        boolean hasCycle = false;
        while (p2.next != null && p2.next.next != null) {
            p = p.next;
            p2 = p2.next.next;
            if (p == p2) {
                hasCycle = true;
                break;
            }
        }
        return hasCycle;
    }

    //给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode dummyhead = head;
        ListNode p = head;
        ListNode p2 = head;
        boolean is = false;
        //直到fast是空
        while (p2.next != null && p2.next.next != null) {
            p = p.next;
            p2 = p2.next.next;
            if (p == p2) {
                is = true;
                break;
            }
        }
        //头节点到环起点的距离 等于 相遇结点到环起点的距离
        if (is == true) {
            while (p != dummyhead) {
                p = p.next;
                dummyhead = dummyhead.next;
            }
            return dummyhead;
        } else
            return null;
    }
}
