package algorithm.sort;

/**
 * 快排
 */
public class QuickSort {

    public static int[] sort(int[] arr) {
        if (arr.length <= 0) {
            return arr;
        }
        return sort(arr, 0, arr.length - 1);
    }

    public static int[] sort(int[] arr, int l, int r) {
        if (l >= r) {
            return arr;
        }
        // 选择标定点
        int pivot = partition(arr, l, r);
        // 分区点已经确定了，所以左边要-1，右边+1
        sort(arr, l, pivot - 1);
        sort(arr, pivot + 1, r);
        return arr;
    }

    /**
     * 分区 确定标定点
     * 把数组分为2个区间  [l, i]小于标定点  [i+1 , r] 大于等于标定点
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int partition(int[] arr, int l, int r) {
        int pivot = r;
        int i = l;
        for (int j = i; j < r; j++) {
            if (arr[j] < arr[pivot]) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
            }
        }
        int tmp2 = arr[i];
        arr[i] = arr[pivot];
        arr[pivot] = tmp2;
        return i;
    }


    public static void main(String[] args) {
        int[] array = {10, 33, 4, 55, 6};
        int[] sort = sort(array);
        for (int i = 0; i < sort.length; i++) {
            System.out.println(sort[i]);
        }
    }

}
