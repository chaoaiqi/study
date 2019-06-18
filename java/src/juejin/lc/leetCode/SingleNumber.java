package juejin.lc.leetCode;

/**
 * 只出现一次的数字
 *
 * @author liuchao
 * @date 2019/6/6
 */
public class SingleNumber {
    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 示例 1:
     * 输入: [2,2,1]
     * 输出: 1
     * 示例 2:
     * 输入: [4,1,2,1,2]
     * 输出: 4
     *
     * @param nums 数组
     * @return 返回结果
     */
    public int solution(int[] nums) {
        //思路：异或：相同为0，不同为1. 异或同一个数两次，原数不变。
        int len = nums.length;
        int result = 0;
        for (int i = 0; i < len; i++) {
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        int[] nums = {4, 1, 2, 1, 2};
        singleNumber.solution(nums);
    }
}
