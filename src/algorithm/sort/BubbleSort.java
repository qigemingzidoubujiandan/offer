package algorithm.sort;

/**
 * 冒泡排序
 * @author zcl
 */
public class BubbleSort {

    public static int[] sort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }



    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {10, 33, 4, 55, 6};
        int[] sort = sort(array);
        for (int i = 0; i < sort.length; i++) {
            System.out.println(sort[i]);
        }
    }
}
