package juejin.lc.leetCode;

import java.util.Arrays;

public class NumArray {
    private int[] sum;

    /**
     * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
     * <p>
     * 示例：
     * <p>
     * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
     * <p>
     * sumRange(0, 2) -> 1
     * sumRange(2, 5) -> -1
     * sumRange(0, 5) -> -3
     * 说明:
     * <p>
     * 你可以假设数组不可变。
     * 会多次调用 sumRange 方法。
     *
     * @param nums 数组
     */
    private NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        System.out.println(Arrays.toString(sum));
    }

    private int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
//    private NumArray (int[] nums) {
//        this.nums = nums;
//    }
//
//    private int sumRange(int i, int j) {
//        int sum = 0;
//        for (int k = i; k <= j; k++) {
//            sum += nums[k];
//        }
//        return sum;
//    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        int res1 = numArray.sumRange(0, 2);
        System.out.println("res1 = " + res1);
        int res2 = numArray.sumRange(2, 5);
        System.out.println("res2 = " + res2);
        int res3 = numArray.sumRange(0, 5);
        System.out.println("res3 = " + res3);
    }
}
