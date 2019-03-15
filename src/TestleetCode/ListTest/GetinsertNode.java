package TestleetCode.ListTest;


//编写一个程序，找到两个单链表相交的起始节点。
public class GetinsertNode {

    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            //如果有链表为null
            if(headA ==null || headB ==null){
                return null;
            }
            ListNode tmpA = headA;
            ListNode tmpB = headB;
            int lenA = 0,lenB = 0;
            //判断是否相交
            while (tmpA !=null){
                tmpA = tmpA.next;
                lenA++;
            }
            while (tmpB != null) {
                tmpB = tmpB.next;
                lenB++;
            }
            if(tmpA != tmpB){
                //若是不相交
               return null;
            }
             //从头开始定义指针
                tmpA = headA;
                tmpB = headB;
            if(lenA <lenB){
                for(int i=0;i<=lenB-lenA;i++){
                    tmpB = tmpB.next;
                }
            }else {
                for (int i=0;i<=lenA-lenB;i++){
                    tmpA = tmpA.next;
                }
            }
            //判断交点
            while (tmpA != tmpB){
                tmpA = tmpA.next;
                tmpB = tmpB.next;
            }
            return tmpA;
        }
    }
}
