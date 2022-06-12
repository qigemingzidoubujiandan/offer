package datastructure.stack;

/**
 * @author zcl
 * @date 2022/6/11 20:46
 */
public interface Stack<E> {
  //查看栈元素的数量
  int getSize();

  //查看栈元素是否为空；
  boolean isEmpty();

  //压栈
  void push(E e);

  //弹出
  E pop();

  //查看栈顶元素
  E peek();


}
