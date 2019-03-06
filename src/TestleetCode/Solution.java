package TestleetCode;
//
///**

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

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
//          //寻找倒数第K个元素并输出
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
//             //链表的反转 ：三指针法
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


//    class Solution {
//            public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//                //大数相加
//                //新链表虚拟头节点
//                ListNode dummyHead = new ListNode(0);
//                ListNode p = l1, q = l2, curr = dummyHead;
//                //表示给下一位进的数
//                int carry = 0;
//                while (p != null || q != null) {
//                    int x = (p != null) ? p.val : 0;
//                    int y = (q != null) ? q.val : 0;
//                    int sum = carry + x + y;//先加1后除10
//                    //修改carry的值 给下一位使用
//                    carry = sum / 10;
//                    curr.next = new ListNode(sum % 10);
//                    curr = curr.next;
//                    if (p != null) p = p.next;
//                    if (q != null) q = q.next;
//                }
//                //循环完毕，如果还要进位在创建一个结点
//                if (carry > 0) {
//                    curr.next = new ListNode(carry);
//                }
//                return dummyHead.next;
//            }
//
//        public static void main(String[] args) {
//
//        }
//    }

//回文链表
//1>2>2>1
//1>2>3>2>1
    class Solution {
         public Boolean chkpalindrome(ListNode A) {
            //快慢指针找中点
             //把后半部分反过来
             //比较前后部分的链表 都相等就是回文链表
             //注意极端情况 null
             return false;
    }


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
