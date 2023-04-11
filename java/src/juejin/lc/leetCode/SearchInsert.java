package juejin.lc.leetCode;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 *
 * @author liuchao
 * @date 2019/5/24
 */
public class SearchInsert {
    /**
     * [1,3,5,6], 5   2
     * [1,3,5,6], 2   1
     * [1,3,5,6], 7   4
     * [1,3,5,6], 0   0
     *
     * @param nums   数组
     * @param target 目标
     * @return 返回位置
     */
    public int solution(int[] nums, int target) {
        int prev = -1;
        for (int i = 0; i < nums.length; i++) {
            if (target > nums[i]) {
                prev = nums[i];
            } else {
                return i;
            }
        }
        if (prev != -1) {
            return nums.length;
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInsert searchInsert = new SearchInsert();
//        [1,3,5,6], 5   2
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert.solution(nums, 5));
//        [1,3,5,6], 2   1
        System.out.println(searchInsert.solution(nums, 2));
//        [1,3,5,6], 7   4
        System.out.println(searchInsert.solution(nums, 7));
//        [1,3,5,6], 0   0
        System.out.println(searchInsert.solution(nums, 0));
    }
}
