package juejin.lc.leetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingNumber {
    /**
     * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [3,0,1]
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: [9,6,4,2,3,5,7,0,1]
     * 输出: 8
     *
     * @param nums 给定正整数数组
     * @return 返回缺失值
     */
    private int solution(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            System.out.println(i + "^" + nums[i] + " = " + (i ^ nums[i]));
            System.out.println(missing + "^" + i + "^" + nums[i] + " = " + (missing ^ i ^ nums[i]));
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    /**
     * 使用一个set存储
     *
     * @param nums 给定正整数数组
     * @return 返回缺失值
     */
    private int solution2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i < nums.length + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 常规思路
     *
     * @param nums 给定正整数数组
     * @return 返回缺失值
     */
    private int solution1(int[] nums) {
        Arrays.sort(nums);
        if (nums[nums.length - 1] != nums.length) {
            return nums.length;
        } else if (nums[0] != 0) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            int extraNum = nums[i - 1] + 1;
            if (nums[i] != extraNum) {
                return extraNum;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();
        int[] nums = {0, 1};
//        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        int result = missingNumber.solution2(nums);
        System.out.println("result = " + result);
    }
}
