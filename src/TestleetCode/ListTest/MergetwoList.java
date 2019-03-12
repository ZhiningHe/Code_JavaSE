package TestleetCode.ListTest;
//将两个有序链表合并

public class MergetwoList {

      public static class ListNode {
          int val;
          ListNode next;
          public ListNode(int val) {
              this.val = val;
          }
      }
      public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
          if(l1 == null && l2 == null) return null;
          ListNode p1 = l1;//为l1设置一个指针
          ListNode p2 = l2;
          ListNode cru = new ListNode(-1);//目前结点的位置
          ListNode head = cru;
          while(p1 !=null && p2 !=null) {//当两个链表都有结点的时候
              if (p1.val <= p2.val) {//放入对应较小的
                  cru.next = p1;
                  p1 = p1.next;
              } else {
                  cru.next = p2;
                  p2 = p2.next;
              }
              cru = cru.next;//当前指针往后移动
          }
          //若是第一个链表未完则把剩下的加入
          if (p1 == null) {
              cru.next = p2;
          } else {
              cru.next = p1;
          }
          return head.next;
      }
}
