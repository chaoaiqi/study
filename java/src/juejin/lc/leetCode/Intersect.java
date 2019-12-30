package juejin.lc.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersect {
    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2,2]
     * 示例 2:
     * <p>
     * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出: [4,9]
     * 说明：
     * <p>
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
     * 我们可以不考虑输出结果的顺序。
     * 进阶:
     * <p>
     * 如果给定的数组已经排好序呢？你将如何优化你的算法？
     * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
     * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
     *
     * @param nums1 数组一
     * @param nums2 数组二
     * @return 返回结果
     */
    private int[] solution(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>();
        for (Integer n : nums1) {
            list1.add(n);
        }
        List<Integer> list2 = new ArrayList<>();
        for (Integer n : nums2) {
            list2.add(n);
        }
        return nums1.length > nums2.length ? setIntersect(list2, list1) : setIntersect(list1, list2);
    }

    private int[] setIntersect(List<Integer> list1, List<Integer> list2) {
        int[] output = new int[list1.size()];
        int idx = 0;
        for (Integer s : list1) {
            if (list2.contains(s)) {
                output[idx++] = s;
                list2.remove(s);
            }
        }
        return Arrays.copyOf(output, idx);
    }

    public static void main(String[] args) {
        Intersect intersect = new Intersect();
        int[] nums1 = {3, 1, 2};
        int[] nums2 = {1, 1};
        int[] arrs = intersect.solution(nums1, nums2);
        System.out.println("arrs = " + Arrays.toString(arrs));
    }
}
