package sort;
/**
 * Created by zhaocl on 2021/10/23 21:20.
 * desc：
 */

/**
 * @program: offer
 * @description:
 * @author: zhaochenliang
 * @create: 2021-10-23 21:20
 **/
public class QuickSort {

    public static class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         * 将给定数组排序
         *
         * @param arr int整型一维数组 待排序的数组
         * @return int整型一维数组
         */

        public int[] MySort(int[] arr) {
            // write code here
            QuickSort(arr, 0, arr.length - 1);
            return arr;
        }

        // 快速排序
        public void QuickSort(int[] arr, int l, int r) {
            if (l >= r) return;
            int p = parttion(arr, l, r);
            QuickSort(arr, 0, p - 1);
            QuickSort(arr, p + 1, arr.length - 1);
        }

        private int parttion(int[] arr, int l, int r) {
            int v = arr[l];
            // [l , l+1] <=V [j,r] > V
            int i = l + 1;
            int j = r;
            while (true) {
                while (i < j && arr[i] <= v) {
                    i++;
                }
                while (i < j && arr[j] >= v) {
                    j--;
                }
                // 可能出想两种情况 :1.i<j
                if (i >= j) {
                    break;
                }
                swap(arr, i, j);

                i++;
                j--;
            }
            swap(arr, j, l);
            return j;
        }

        private void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {11, 12, 5, 1, 77, 3};
        int[] sort = new Solution().MySort(arr);
    }
}
