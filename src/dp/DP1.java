package dp; /**
 * Created by zhaocl on 2021/10/8 11:01.
 * desc：
 */

/**
 * @program: offer
 * @description:
 * @author: zhaochenliang
 * @create: 2021-10-08 11:01
 **/
public class DP1 {


    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int tmp = nums[0];
        for(int i = 1; i < nums.length; i++){
            tmp = Math.max(tmp + nums[i], nums[i]);
            max = Math.max(tmp, max);
        }
        return max;
    }
}
