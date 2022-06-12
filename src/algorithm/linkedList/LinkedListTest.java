package algorithm.linkedList;

import datastructure.linkedList.Node;

/**
 * 1) 单链表反转
 * 2) 链表中环的检测
 * 3) 两个有序的链表合并
 * 4) 删除链表倒数第n个结点
 * 5) 求链表的中间结点
 *
 * @author zcl
 * @date 2022/6/12 16:03
 */
public class LinkedListTest {

    public static Node reverse(Node list) {
        Node cur = list;
        // 为了防止断开链表 记录下pre
        Node pre = null;
        while (cur != null) {
            Node next = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = next;
        }
        return pre;
    }

    // 检测环 快慢指针
    public static boolean checkCircle(Node list) {
        if (list == null) {
            return false;
        }

        Node slow = list;
        Node fast = list.getNext();
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // 有序链表合并 Leetcode 21

    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int x) { val = x; } }
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode();
        ListNode left = l1.val < l2.val ? l1 : l2;
        ListNode right = l1.val > l2.val ? l1 : l2;
        ListNode curNode = newNode;
        while (left != null && right != null) {
            while (left != null && right != null && left.val < right.val) {
                curNode.next = left;
                curNode = left;
                left = left.next;
            }
            // l1 完了  l1 > l2
            if (left != null && right != null && left.val > right.val) {
                while (left != null && right != null && right.val < left.val) {
                    curNode.next = right;
                    curNode = right;
                    right = right.next;
                }
            }
            if (left == null && right != null) {
                curNode.next = right;
            }
            if (right == null && left != null) {
                newNode.next = left;
            }
        }
        return newNode.next;
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode();
        ListNode curNode = newNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curNode.next = l1;
                l1 = l1.next;
            } else {
                curNode.next = l2;
                l2 = l2.next;
            }
            curNode = curNode.next;
        }
        if (l1 == null) {
            curNode.next = l2;
        }
        if (l2 == null) {
            newNode.next = l1;
        }
        return newNode.next;
    }

    // 求中间结点
    public static Node findMiddleNode(Node list) {
        if (list == null) {
            return null;
        }

        Node fast = list;
        Node slow = list;

        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }

        return slow;
    }

    // 删除倒数第K个结点
    public static Node deleteLastKth(Node list, int k) {
        Node fast = list;
        int i = 1;
        while (fast != null && i < k) {
            fast = fast.getNext();
            ++i;
        }

        if (fast == null) {
            return list;
        }

        Node slow = list;
        Node prev = null;
        while (fast.getNext() != null) {
            fast = fast.getNext();
            prev = slow;
            slow = slow.getNext();
        }

        if (prev == null) {
            list = list.getNext();
        } else {
            prev.setNext(prev.getNext().getNext());
        }
        return list;
    }

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode() {
        }

        public void display() {
            ListNode cur = this;
            while (cur != null) {
                System.out.print(cur.val + " ");
                cur = cur.next;
            }
            //换一下行
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Node<Integer> node = new Node<>(1);
        node.setNext(new Node(5));
        node.getNext().setNext(new Node(111));
        node.getNext().getNext().setNext(new Node(113));
        node.display();
//        Node reverse = reverse(node);
//        reverse.display();
        Node<Integer> node2 = new Node<>(2);
        node2.setNext(new Node(4));
        Node node3 = new Node(115);
        node2.getNext().setNext(node3);
        node2.getNext().getNext().setNext(new Node(118));
//        node2.getNext().getNext().getNext().setNext(node3);
        boolean b = checkCircle(node2);
        System.out.println(b);

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(5);
        listNode.next.next = new ListNode(111);
        listNode.next.next.next = new ListNode(113);
        node.display();
        ListNode listNode2 = new ListNode(2);
        listNode2.next = new ListNode(4);
        ListNode listNode3 = new ListNode(115);
        listNode2.next.next = listNode3;
        listNode2.next.next.next = new ListNode(118);
//        ListNode ret = mergeTwoLists(listNode, listNode2);
        ListNode ret2 = mergeTwoLists2(listNode, listNode2);
//        ret.display();
        ret2.display();

    }
}
