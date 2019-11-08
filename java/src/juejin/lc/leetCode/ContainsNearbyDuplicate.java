package juejin.lc.leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * 存在重复元素II
 */
public class ContainsNearbyDuplicate {
    /**
     * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
     * 使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [1,2,3,1], k = 3
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: nums = [1,0,1,1], k = 1
     * 输出: true
     * 示例 3:
     * <p>
     * 输入: nums = [1,2,3,1,2,3], k = 2
     * 输出: false
     *
     * @param nums 数组
     * @param k    绝对差值
     * @return 返回结果
     */
    private boolean solution(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            System.out.println("size = " + set.size() + ",k = " + k);
            if (set.size() > k) {
                System.out.println("nums[" + i + " - " +  k + "] = " + nums[i - k]);
                set.remove(nums[i - k]);
            }
            System.out.println("set = " + set.toString());
        }
        return false;
    }

    private boolean solution1(int[] nums, int k) {
        if (nums.length == 0) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= k; j++) {
                if (i + j < nums.length && nums[i] == nums[i + j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsNearbyDuplicate containsNearbyDuplicate = new ContainsNearbyDuplicate();
        int[] nums = {1,0,1,1};
        int k = 3;
        boolean result = containsNearbyDuplicate.solution(nums, k);
        System.out.println("result = " + result);
    }
}
