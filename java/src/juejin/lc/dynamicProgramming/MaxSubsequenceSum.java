package juejin.lc.dynamicProgramming;

/**
 * 最大子序列和
 * @author liuchao
 * @date 2019/6/19
 */
public class MaxSubsequenceSum {
    /**
     *
     * @param nums 传入数组
     * @return 返回值
     */
    private int solution(int[] nums){
//        状态转移方程公式
//        dp[0] = ai; (i = 0)
//        dp[i] = dp[i-1]>=0 ? dp[i-1]+nums[i] : nums[i] (i > 1)
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(dp[i - 1] >= 0) {
                dp[i] = dp[i - 1] + nums[i];
            }else {
                dp[i] = nums[i];
            }
            System.out.println("dp[" + i  + "] = " + dp[i]);
        }
//        取dp里面最大值即可
        int res = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if(dp[i] > res) {
                res = dp[i];
            }
        }
        return res;
    }
    /**
     * 最优解
     * @param nums 传入数组
     * @return 返回值
     */
    private int solution2(int[] nums){
        int res = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            res = Math.max(res, sum);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int res = new MaxSubsequenceSum().solution2(nums);
        System.out.println("最大子序列和为：" + res);
    }
}
