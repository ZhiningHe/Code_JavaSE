package TestleetCode.ListTest;
//翻转链表

public class ResetList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
    class Solution2 {
        //链表的反转 ：三指针法
        public ListNode FindKthToTail(ListNode head, int k) {
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode first = dummyHead.next;
            ListNode second = first.next;
            if (first == null || second == null) {
                return head;
            } else {
                while (second != null) {
                    first.next = second.next;
                    second.next = dummyHead.next;
                    dummyHead.next = second;
                    second = first.next;
                }
                return dummyHead.next;
            }
        }
    }
}


