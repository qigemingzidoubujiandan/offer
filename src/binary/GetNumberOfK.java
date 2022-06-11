package binary; /**
 * Created by zhaocl on 2021/10/7 19:58.
 * desc：
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @program: offer
 * @description:
 * @author: zhaochenliang
 * @create: 2021-10-07 19:58
 **/
public class GetNumberOfK {

    public static int GetNumberOfK(int[] array, int k) {
        int lastIndex = getLastIndex(array, k, 0,array.length-1);
        if (lastIndex == 0) {
            return 1;
        }
        int n = 0;
        for (int i =0; i <= lastIndex; i++) {
            if (array[lastIndex - i] == k){
                n ++;
            } else {
                break;
            }
        }
        return n;
    }

    public static  int getLastIndex(int[] arr, int k, int left, int right) {
        while (left <= right) {
            int mid = (right - left)/2 + left;
            if (arr[mid] > k) {
                right = mid - 1;
            } else if (arr[mid] < k) {
                left = mid +1;
            } else if (mid+1<arr.length  && arr[mid+1] == k) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    //循环写法
    private int getLastK(int [] array , int k, int start, int end){
        int length = array.length;
        int mid = (start + end) >> 1;
        while(start <= end){
            if(array[mid] > k){
                end = mid-1;
            }else if(array[mid] < k){
                start = mid+1;
            }else if(mid+1 < length && array[mid+1] == k){
                start = mid+1;
            }else{
                return mid;
            }
            mid = (start + end) >> 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {3,3,3};
        int i = GetNumberOfK(arr, 3);
        System.out.println(i);
    }
}
