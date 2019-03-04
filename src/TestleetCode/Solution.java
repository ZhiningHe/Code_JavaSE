package TestleetCode;
//
///**
// * Definition for singly-linked list.
// * public class ListNode {
// *     int val;
// *     ListNode next;
// *     ListNode(int x) { val = x; }
// * }
// */
//
//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode(int x) {
//        val = x;
//    }
//}
//
//class Solution1 {
//    public ListNode removeElements(ListNode head, int val) {
//        ListNode dummyHead = new ListNode(-1);
//        dummyHead.next = head;
//        ListNode prev = dummyHead;
//
//        while (prev.next != null) {
//            if (prev.next.val == val) {
//                prev.next = prev.next.next;
//            } else {
//                prev = prev.next;
//            }
//        }
//        return head;
//    }
//}
//
///**
// * Definition for singly-linked list.
// * public class ListNode {
// *     int val;
// *     ListNode next;
// *     ListNode(int x) { val = x; }
// * }
// */
//
//class Solution {
//    public ListNode FindKthToTail(ListNode head,int k) {
//        ListNode tmp = head;
//        int size = 0;
//        while (tmp != null) {
//            tmp = tmp.next;
//            size++;
//        }
//        if (size < k) {
//            return null;
//        } else {
//            tmp = head;
//            for (int j = 0; j < size - k; j++) {
//                tmp = tmp.next;
//            }
//            return tmp;
//        }
//    }
//}
//
//
//class Solution2 {
//    public ListNode FindKthToTail(ListNode head,int k) {
//        ListNode dummyHead = new ListNode(-1);
//        dummyHead.next = head;
//        ListNode first = dummyHead.next;
//        ListNode second = first.next;
//        if(first == null ||second ==null){
//            return head;
//        }else{
//            while(second != null){
//                first.next = second.next;
//                second.next = dummyHead.next;
//                dummyHead.next = second;
//                second = first.next;
//            }
//            return dummyHead.next;
//        }
//    }
//}

import java.util.Arrays;

 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    class Solution {
            public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
                ListNode dummyHead = new ListNode(0);
                ListNode p = l1, q = l2, curr = dummyHead;
                int carry = 0;
                while (p != null || q != null) {
                    int x = (p != null) ? p.val : 0;
                    int y = (q != null) ? q.val : 0;
                    int sum = carry + x + y;//先加1后除10
                    carry = sum / 10;
                    curr.next = new ListNode(sum % 10);
                    curr = curr.next;
                    if (p != null) p = p.next;
                    if (q != null) q = q.next;
                }
                if (carry > 0) {
                    curr.next = new ListNode(carry);
                }
                return dummyHead.next;
            }

        public static void main(String[] args) {

        }
    }

