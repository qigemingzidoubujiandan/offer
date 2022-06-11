package FindKthToTail;
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

    public ListNode FindKthToTail (ListNode pHead, int k) {
        ListNode r = pHead;
        for (int i = 0; i < k; i++) {
            if(r == null) return r;

            r = r.next;
        }
        ListNode l = pHead;
        while (r != null) {
            l = l.next;
            r = r.next;
        }
        return l;
    }

    static class ListNode{
        int val;
        ListNode next = null;

        ListNode(int val){
            this.val = val;
        }
    }


}
