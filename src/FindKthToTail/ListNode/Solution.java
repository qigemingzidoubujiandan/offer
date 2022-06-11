package FindKthToTail.ListNode;
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
import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<Integer>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.empty()){
            list.add(stack.pop());
        }
        return list;
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

        ArrayList<Integer> integers = printListFromTailToHead(listNode1);
        System.out.println(integers);


    }
}
