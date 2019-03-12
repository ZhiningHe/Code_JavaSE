package TestleetCode.ListTest;
//判断是否是回文链表
public class isPalindrome {
    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }
    public static boolean isPalindrome(Node head) {
        if(head == null || head.next == null) {
            return true;
        }
        Node low,fast;
        low = fast = head;
        while(fast != null && low!=null && fast.next != null) {
            fast = fast.next.next;
            low = low.next;
        }
        Node mid = low;
        // 反转中间节点后的链表
        Node dummyHead = new Node(-1);
        dummyHead.next = mid;
        Node cur = dummyHead.next;
        Node sec = cur.next;
        while(sec != null) {
            cur.next = sec.next;
            sec.next = dummyHead.next;
            dummyHead.next = sec;
            sec = cur.next;
        }
        fast = head;
        // 从前开始遍历两个链表，若遇到节点值不同的直接返回false
        while(fast != null && dummyHead.next != null) {
            if(fast.val != dummyHead.next.val){
                return false;
            }
            fast = fast.next;
            dummyHead.next = dummyHead.next.next;
        }
        return true;
    }
}
