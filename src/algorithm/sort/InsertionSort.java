package algorithm.sort;

/**
 * 插入排序
 * @author zcl
 */
public class InsertionSort {


    /**
     * 插入排序：
     * 分为有序区 和 无序区 从无序去一个个放到有序区
     * @param arr
     * @return
     */
    public static int[] sort(int[] arr) {
        if (arr.length <= 0) {
            return arr;
        }
        int length = arr.length;
        // 默认第一个元素是有序区间
        for (int i = 1; i < length; i++) {
            // 当前比较的元素
            int val = arr[i];
            int j = i - 1;
            for (; j >= 0 ; j--) {
                if (arr[j] > val) {
                    // 数据移动
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            // 插入数据
            arr[j + 1] = val;
        }
        return arr;
    }



    public static void main(String[] args) {
        int[] array = {10, 33, 4, 55, 6};
        int[] sort = sort(array);
        for (int i = 0; i < sort.length; i++) {
            System.out.println(sort[i]);
        }
    }
}
