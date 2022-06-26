package algorithm.sort; /**
 * Created by zhaocl on 2021/10/8 21:58.
 * desc：
 */

/**
 * @program: offer
 * @description:
 * @author: zhaochenliang
 * @create: 2021-10-08 21:58
 **/

import sort.BubbleSort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class mergeSort {

    public void  sort(int [] arr) {
       sort(arr, 0, arr.length-1);
    }

    private void sort(int[] arr, int l ,int r){
        if (l>=r) {
            return;
        }
        int mid = (r-l)/2+l;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);

        merge(arr, l, r, mid);
    }

    private void merge(int[] arr, int l, int r, int mid) {
        int[] tmp = Arrays.copyOfRange(arr, l, r+1);
        int i = l;
        int j = mid +1;
        for (int k = l; k < r-l; k++) {
            if (i >mid) {
                arr[k] = tmp[j-l]; j ++;
            } else if (j >r) {
                arr[k]  = tmp[i-l];i++;
            } else if(tmp[i - l] > tmp[j -l]) {
                arr[k] = tmp[j -l]; j++;
            } else {
                arr[k] = tmp[i -l]; i++;
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
