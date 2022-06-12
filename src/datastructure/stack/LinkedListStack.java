package datastructure.stack;

import datastructure.linkedList.DoubleLinkedList;

/**
 * 基于链表的栈
 *
 * @author zcl
 * @date 2022/6/11 20:42
 */
public class LinkedListStack<E> implements Stack<E> {

    private DoubleLinkedList<E> list;

    public LinkedListStack() {
        list = new DoubleLinkedList<>();
    }


    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack：top");
        res.append(list);
        list.display();
        return res.toString();
    }
}