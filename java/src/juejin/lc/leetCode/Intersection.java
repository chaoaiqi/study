package juejin.lc.leetCode;


import java.util.Arrays;
import java.util.HashSet;

public class Intersection {
    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2]
     * 示例 2:
     * <p>
     * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出: [9,4]
     * 说明:
     * <p>
     * 输出结果中的每个元素一定是唯一的。
     * 我们可以不考虑输出结果的顺序。
     * retainAll
     *
     * @param nums1 数组一
     * @param nums2 数组二
     * @return 交集数组
     */
    public int[] solution(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (Integer n : nums1) {
            set1.add(n);
        }
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (Integer n : nums2) {
            set2.add(n);
        }

        set1.retainAll(set2);

        int[] output = new int[set1.size()];
        int idx = 0;
        for (int s : set1) {
            output[idx++] = s;
        }
        return output;
    }

    private int[] solution1(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (Integer n : nums1) {
            set1.add(n);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for (Integer n : nums2) {
            set2.add(n);
        }
        // retainAll A.retainAll(B) A去重，去掉包含B的部分
        return nums1.length > nums2.length ? setIntersection(set2, set1) : setIntersection(set1, set2);
    }

    private int[] setIntersection(HashSet<Integer> set2, HashSet<Integer> set1) {
        int[] output = new int[set1.size()];
        int idx = 0;
        for (Integer s : set1) {
            if (set2.contains(s)) {
                output[idx++] = s;
            }
        }
        return Arrays.copyOf(output, idx);
    }

    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] arrs = intersection.solution(nums1, nums2);
        System.out.println("arrs = " + Arrays.toString(arrs));
    }
}
