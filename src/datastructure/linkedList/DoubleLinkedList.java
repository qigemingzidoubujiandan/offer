package datastructure.linkedList;

/**
 * 双向链表
 * @author zcl
 * @date 2022/6/11 20:36
 */
public class DoubleLinkedList<E> {

    private Node head;
    private int size;

    private class Node {

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

    }

    public DoubleLinkedList() {
    }

    public DoubleLinkedList(E e) {
        head = new Node(e);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 头插法
     * @param e
     */
    public void addFirst(E e) {
        Node node = new Node(e);
        //处理是空链表时的情况
        if (head == null) {
            head = node;
        } else {
            //正常情况，next和prev都要进行处理
            node.next = head;
            head.prev = node;
            head = node;
        }
        size ++;
    }

    //尾插法
    public void addLast(E data){
        //创建一个新节点
        Node node = new Node(data);
        //处理空链表的情况
        if(this.head == null){
            this.head = node;
        }else{
            //正常情况
            Node cur = this.head;
            //遍历找到最后一个节点
            while(cur.next != null){
                cur = cur.next;
            }
            //真正进行处理
            cur.next = node;
            node.prev = cur;
        }
        size ++;
    }

    public boolean addIndex(int index,E data) {
        //判断是否是空链表
        if (this.head == null) {
            return false;
        }
        //判断坐标是否合法
        if (index > size() || index < 0) {
            return false;
        }
        //在0位置插入
        if (index == 0) {
            //头插法
            addFirst(data);
            return true;
        }
        //在末尾插入
        if (index == size()) {
            //尾插法
            addLast(data);
            return true;
        }
        //创建节点
        Node node = new Node(data);
        //循环遍历找到index指向的节点
        Node cur = this.head;
        while (index > 0) {
            cur = cur.next;
            index--;
        }
        //插入新节点
        node.next = cur;
        node.prev = cur.prev;
        cur.prev.next = node;
        cur.prev = node;
        size++;
        return true;
    }

    private int size() {
        return size;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get Failed.Illegal index.");
        }
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    //获取链表的第一个元素
    public E getFirst() {
        return get(0);
    }

    // 获得链表的最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    private E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed.Index is illegal");
        }

        Node cur = head;
        Node second = head.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        Node prev = cur.prev;
        Node next = cur.next;
        // 删除最后一个元素时next 为空
        if (next != null) {
            next.prev = prev;
        }
        cur.prev = null;
        cur.next = null;
        if (prev != null) {
            prev.next = next;
        } else {
            // 头元素删除单独处理
            head = second;
        }
        size--;
        return cur.e;
    }

    // 从链表中删除第一个元素，返回删除的元素
    public E removeFirst() {
        return remove(0);
    }

    // 从链表中删除最后一个元素，返回删除的元素
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        return "LinkedList{" +
            "head=" + head +
            ", size=" + size +
            '}';
    }

    //打印双链表
    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.e + " ");
            cur = cur.next;
        }
        //换一下行
        System.out.println();
    }

    //销毁双链表
    public void clear() {
        Node cur = this.head;
        //直接使用head
        while (this.head != null) {
            //记录下一个节点的地址
            cur = cur.next;
            //将next和prev都置null
            this.head.prev = null;
            this.head.next = null;
            //更新head的指向，继续处理下一个节点
            this.head = cur;
        }
    }

    public static void main(String[] args) {
        //创建一个双链表
        DoubleLinkedList d = new DoubleLinkedList();
        d.addLast(1);
        d.addLast(2);
        d.addLast(3);
        d.addLast(4);
        System.out.println("------------------------");
        System.out.println(d);
        d.addIndex(4,99);
        d.display();
        d.remove(0);
        d.display();
        d.remove(2);
        d.display();
        d.remove(0);
        d.display();
        d.remove(1);
        d.display();

    }
}
