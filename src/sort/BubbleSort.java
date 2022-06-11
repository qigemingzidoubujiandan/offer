package sort; /**
 * Created by zhaocl on 2021/10/8 21:58.
 * desc：
 */

/**
 * @program: offer
 * @description:
 * @author: zhaochenliang
 * @create: 2021-10-08 21:58
 **/

/**
 * 冒泡排序
 */
public class BubbleSort {

    public void  sort(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {11,333,44,2,444,5};
        new BubbleSort().sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
