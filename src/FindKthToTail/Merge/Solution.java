package FindKthToTail.Merge;
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

    public static ListNode ReverseList(ListNode head) {

        ListNode pre = null;
        ListNode next = null;
        while (head != null){
           next = head.next;
           head.next = pre;
           pre = head;
           head = next;
        }
        return pre;
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

        ListNode listNode3 = new ListNode(3);

        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode = ReverseList(listNode1);
        System.out.println(listNode);


    }
}
