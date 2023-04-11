package juejin.lc.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 求众数
 *
 * @author liuchao
 * @date 2019/6/18
 */
public class MajorityElement {
    /**
     * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     * 你可以假设数组是非空的，并且给定的数组总是存在众数。
     * 示例 1:
     * 输入: [3,2,3]
     * 输出: 3
     * 示例 2:
     * 输入: [2,2,1,1,1,2,2]
     * 输出: 2
     *
     * @param nums 数组
     * @return 众数
     */
    public int solution(int[] nums) {
        //摩根投票法
        int ret = nums[0];
        System.out.println("nums[0] = " + ret);
        int count = 1;
        for (int num : nums) {
            System.out.println("num = " + num + ", ret = " + ret + ", count = " + count);
            if (num != ret) {
                count--;
                if (count == 0) {
                    count = 1;
                    ret = num;
                }
            } else {
                count++;
            }
        }
        return ret;
    }

    /**
     * 最优解
     *
     * @param nums 数组
     * @return 反转后取中间值
     */
    public int solutiont(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        int[] nums = {3, 2, 3, 1, 5, 1, 4, 1, 1};
        int res = majorityElement.solution(nums);
        System.out.println(res);
    }
}
