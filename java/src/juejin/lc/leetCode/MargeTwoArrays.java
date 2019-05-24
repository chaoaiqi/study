package juejin.lc.leetCode;


/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * @author liuchao
 * @date 2019/5/24
 */
public class MargeTwoArrays {
    /**
     * 输入:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     * 输出: [1,2,2,3,5,6]
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length == 0) {
            return nums2;
        }
        if (nums2.length == 0) {
            return nums1;
        }
        int num = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (j >= 0) {
            nums1[num--] = i >= 0 && nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        return nums1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        MargeTwoArrays margeTwoArrays = new MargeTwoArrays();
        int[] res = margeTwoArrays.merge(nums1, m, nums2, n);
        System.out.println(res.length);
    }
}
