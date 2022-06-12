package datastructure.linkedList;

import datastructure.stack.LinkedListStack;

/**
 * @author zcl
 * @date 2022/6/11 21:33
 */
public class Test {

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        stack.pop();
        System.out.println(stack);
    }
}
