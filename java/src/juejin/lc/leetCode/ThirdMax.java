package juejin.lc.leetCode;

import java.util.TreeSet;

public class ThirdMax {
    /**
     * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [3, 2, 1]
     * <p>
     * 输出: 1
     * <p>
     * 解释: 第三大的数是 1.
     * 示例 2:
     * <p>
     * 输入: [1, 2]
     * <p>
     * 输出: 2
     * <p>
     * 解释: 第三大的数不存在, 所以返回最大的数 2 .
     * 示例 3:
     * <p>
     * 输入: [2, 2, 3, 1]
     * <p>
     * 输出: 1
     * <p>
     * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
     * 存在两个值为2的数，它们都排第二。
     *
     * @param nums
     * @return
     */
    public int solution(int[] nums) {
        // 边界条件
        if (null == nums || nums.length == 0) {
            throw new RuntimeException("error");
        }
        // 需要去重，第一时间要考虑 set
        // 只存放3个元素的 红黑树
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            treeSet.add(nums[i]);
            if (treeSet.size() > 3) {
                treeSet.remove(treeSet.first());
            }
        }
        System.out.println(treeSet);
        return treeSet.size() > 2 ? treeSet.first() : treeSet.last();
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 1};
        int res1 = new ThirdMax().solution(nums1);
        System.out.println("res1 = " + res1);
        int[] nums2 = {1, 2};
        int res2 = new ThirdMax().solution(nums2);
        System.out.println("res2 = " + res2);
        int[] nums3 = {2, 2, 3, 1};
        int res3 = new ThirdMax().solution(nums3);
        System.out.println("res3 = " + res3);
    }
}
