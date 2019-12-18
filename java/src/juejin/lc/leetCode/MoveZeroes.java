package juejin.lc.leetCode;

import java.util.Arrays;

public class MoveZeroes {
    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 示例:
     * <p>
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     * <p>
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     *
     * @param nums 数组
     */
    private void solution(int[] nums) {
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }


    private void solution2(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[count++] = nums[i];
            }
        }
        for (int i = count; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    private void solution1(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i - count] == 0) {
                for (int j = i - count + 1; j < nums.length - count; j++) {
                    nums[j - 1] = nums[j];
                }
                ++count;
                nums[nums.length - count] = 0;
            }
        }
    }

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes.solution(nums);
        System.out.println("nums = " + Arrays.toString(nums));
    }
}
