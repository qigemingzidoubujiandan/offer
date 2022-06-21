package algorithm.sort;

/**
 * 选择排序
 *
 * @author Administrator
 */
public class SelectionSort {

    public static int[] sort(int[] arr) {
        if (arr.length <= 0) {
            return arr;
        }
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
                if (min != i) {
                    int temp = arr[i];
                    arr[i] = arr[min];
                    arr[min] = temp;
                }

            }
        }
        return arr;
    }


        public static void main (String[]args){
            int[] array = {10, 33, 4, 55, 6};
            int[] sort = sort(array);
            for (int i = 0; i < sort.length; i++) {
                System.out.println(sort[i]);
            }
        }
    }
