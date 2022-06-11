package FindKthToTail.FindFirstCommonNode;
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

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null)return null;
        ListNode p1 = null;
        ListNode p2 = null;
        while (p1 != p2) {
            p1 = pHead1.next;
            p2 = pHead2.next;
            if (p1 != p2) {
                if (p1 == null) p1 = pHead2;
                if (p2 == null) p2 = pHead1;
            }

        }
        return p1;

    }

    static class ListNode{
        int val;
        ListNode next = null;

        ListNode(int val){
            this.val = val;
        }
    }


}
