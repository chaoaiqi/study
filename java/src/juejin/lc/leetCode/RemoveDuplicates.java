package juejin.lc.leetCode;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * @author liuchao
 * @date 2019/5/23
 */
public class RemoveDuplicates {
    /**
     * 原地去重，返回新长度
     *
     * @param nums 数组
     * @return 新数组长度
     */
    public int solution(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]){
                ++index;
                continue;
            }
            if (index > 0) {
                nums[i - index] = nums[i];
            }
        }
        return nums.length - index;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int length = removeDuplicates.solution(nums);
        System.out.println("length = " + length);
    }
}
