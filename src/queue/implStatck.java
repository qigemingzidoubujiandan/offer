package queue; /**
 * Created by zhaocl on 2021/10/7 17:41.
 * desc：
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program: offer
 * @description:
 * @author: zhaochenliang
 * @create: 2021-10-07 17:41
 **/
public class implStatck {


    public class Solution {

        Stack<Integer> dataStack = new Stack();
        Stack<Integer> minStack = new Stack();


        public void push(int node) {
            dataStack.push(node);
            if (minStack.isEmpty()) {
                minStack.push(node);
            }else if (minStack.peek() >= node) {
                minStack.push(node);
            }
        }

        public void pop() {
            if (dataStack.peek() == minStack.peek()) {
                minStack.pop();
            }
            dataStack.pop();
        }

        public int top() {
            return minStack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }
}

