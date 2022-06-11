package FindKthToTail.EntryNodeOfLoop;
/**
 * Created by zhaocl on 2021/10/6 20:51.
 * desc：
 */

/**
 * @program: offer
 * @description:
 * @author: zhaochenliang
 * @create: 2021-10-06 20:51
 **/

/**
 *    public class linkedListNode.FindKthToTail.ListNode {
 *        int val;
 *        linkedListNode.FindKthToTail.ListNode next = null;
 *
 *        linkedListNode.FindKthToTail.ListNode(int val) {
 *            this.val = val;
 *        }
 *    }
 *
 */

public class Solution {

    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return  null;
        }
       // 先找到链表中有没有环:用两个指针，快慢指针
        boolean flag =false ;
        ListNode low = pHead;
        ListNode fast = pHead;
        while (fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;
            if (low == fast) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            return null;
        }
        // 查找环节点的个数
        int n=1;
        ListNode l = low.next;
        while (l != fast) {
            l=l.next;
            n ++;
        }
        // 查找环的入口
        low = fast = pHead;
        for (int i = 0; i < n; i++) {
            low = low.next;
        }
        while (low != fast) {
            low = low.next;
            fast = fast.next;
        }
        return low;
    }


        static class ListNode{
        int val;
        ListNode next = null;

        ListNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);

        listNode1.next = listNode2;

        ListNode listNode = EntryNodeOfLoop(listNode1);
        System.out.println(listNode);


    }
}
