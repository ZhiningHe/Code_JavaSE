package TestleetCode.ListTest;


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
        if(head ==null || head.next ==null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        //直到fast是空
        while (fast.next !=null){
            if(fast == slow) return true;
            if(fast.next.next == null) fast = fast.next;
            else {
                fast = fast.next.next;
                slow = slow.next;
            }
        }
        return false;
    }

    //给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    public ListNode detectCycle(ListNode head) { return null; }
}
