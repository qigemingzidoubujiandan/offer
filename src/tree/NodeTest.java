package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zcl
 * @date 2022/6/23 16:28
 */
public class NodeTest {

    private static Queue<Node> queue = new LinkedList();

    public static void levelSort(Node node) {
        if (node == null) return;
        queue.add(node);
        while (!queue.isEmpty()) {
            Node ele = queue.poll();
            if (ele == null) {
                continue;
            }
            System.out.println(ele.data);
            queue.offer(ele.left);
            queue.offer(ele.right);

        }
    }

    public static void main(String[] args) {

        final Node node8 = new Node(8, null, null);
        final Node node9 = new Node(9, null, null);
        final Node node10 = new Node(10, null, null);
        final Node node6 = new Node(6, null, null);
        final Node node7 = new Node(7, null, null);

        final Node node4 = new Node(4, node8, node9);
        final Node node5 = new Node(5, node10, null);
        final Node node2 = new Node(2, node4, node5);
        final Node node3 = new Node(3, node6, node7);
        final Node node = new Node(1, node2, node3);
        levelSort(node);

    }

    static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
