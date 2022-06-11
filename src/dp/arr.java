package dp; /**
 * Created by zhaocl on 2021/10/8 21:42.
 * desc：
 */

/**
 * @program: offer
 * @description:
 * @author: zhaochenliang
 * @create: 2021-10-08 21:42
 **/
public class arr {
    ///**1.求数组A中互不相邻数的最大和。如数组A=[1,2,4,1,7,8,3]
    //	 * 动态规划解法
    //	 * @param arr
    //	 * @return
    //	 */
    	public static int dp_opt(int[] arr) {
    	    int [] ret = new int[arr.length];
            ret[0] = arr[0];
            ret[1] = Math.max(arr[0], arr[1]);
            for (int i = 2; i < arr.length; i++) {
                int a = arr[i-2] + arr[i];
                int b = arr[i-1];
                arr[i] = Math.max(a, b);
            }
            return ret[arr.length - 1];
        }
}
