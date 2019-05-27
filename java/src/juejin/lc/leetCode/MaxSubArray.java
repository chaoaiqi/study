package juejin.lc.leetCode;

/**
 * 最大子序列和
 *
 * @author liuchao
 * @date 2019/5/27
 */
public class MaxSubArray {
    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 示例:
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     *
     * @param nums 数组
     * @return 和
     */
    private int solution(int[] nums) {
        int sum = 0;
        int res = nums[0];
        for (int num : nums) {
            System.out.println("sum-before = " + sum + ",num = " + num + ",res-before = " + res);
            //进行比较，sum存当前sum(n)
            sum = sum > 0 ? sum + num : num;
            System.out.println("sum-after = " + sum);
            //res则对此次操作进行纠正
            if (res < sum) {
                res = sum;
            }
            System.out.println("res-after = " + res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int res = new MaxSubArray().solution(nums);
        System.out.println(res);
    }
}
