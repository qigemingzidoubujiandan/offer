package datastructure.linkedList;

/**
 * @author zcl
 * @date 2022/6/12 16:13
 */
public class Node<E> {

    private final E e;
    private Node prev;
    private Node next;

    public Node(E e, Node prev, Node next) {
        this.e = e;
        this.prev = prev;
        this.next = next;
    }

    public Node(E e) {
        this(e, null, null);
    }

    public Node() {
        this(null, null, null);
    }

    public E getE() {
        return e;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    //打印双链表
    public void display() {
        Node cur = this;
        while (cur != null) {
            System.out.print(cur.e + " ");
            cur = cur.next;
        }
        //换一下行
        System.out.println();
    }
}
