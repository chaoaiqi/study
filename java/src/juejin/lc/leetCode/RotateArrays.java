package juejin.lc.leetCode;

/**
 * 旋转数组
 *
 * @author liuchao
 * @date 2019/6/19
 */
public class RotateArrays {
    /**
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * 示例 1:
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     * 示例 2:
     * 输入: [-1,-100,3,99] 和 k = 2
     * 输出: [3,99,-1,-100]
     * 解释:
     * 向右旋转 1 步: [99,-1,-100,3]
     * 向右旋转 2 步: [3,99,-1,-100]
     * <p>
     * 时间复杂度：O(kn)
     * 空间复杂度：O(1)
     *
     * @param nums 数组
     * @param k    步数
     */
    public void rotate(int[] nums, int k) {
        //常规思路
        // 第一层for循环 控制步数
        // 第二层for循环做数组位置
        int n = nums.length;
        k %= n;
        for (int i = 0; i < k; i++) {
            int tmp = nums[n - 1];
            for (int j = n - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = tmp;
        }
    }

    /**
     * 法2
     * 数组反转
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums 数组
     * @param k    步数
     */
    private void rotate1(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        print(nums);
        reverse(nums, 0, n - 1);
        print(nums);
        reverse(nums, 0, k - 1);
        print(nums);
        reverse(nums, k, n - 1);
        print(nums);
    }

    /**
     * 数组反转
     *
     * @param nums  数组
     * @param start 开始
     * @param end   结束
     */
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = tmp;
        }
    }

    /**
     * 循环交换
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums 数组
     * @param k    步数
     */
    private void rotate2(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        // 第一次交换完毕后，前 k 位数字位置正确，后 n-k 位数字中最后 k 位数字顺序错误，继续交换
//        for (int start = 0; start < nums.length && k != 0; n -= k, start += k, k %= n) {
//            for (int i = 0; i < k; i++) {
//                swap(nums, start + i, nums.length - k + i);
//            }
//        }
        for (int start = 0; start < nums.length && k != 0; n -= k, start += k, k %= n) {
            for (int i = 0; i < k; i++) {
                swap(nums, start + i, nums.length - k + i);
            }
        }
    }

    /**
     * 递归交换
     * 时间复杂度：O(n)
     * 空间复杂度：O(n/k)
     *
     * @param nums 数组
     * @param k    步数
     */
    private void rotate3(int[] nums, int k) {
        recursiveSwap(nums, k, 0, nums.length);
    }

    /**
     * 递归交换
     *
     * @param nums   数组
     * @param k      长度
     * @param start  开始
     * @param length 长度
     */
    private void recursiveSwap(int[] nums, int k, int start, int length) {
        k %= length;
        if (k != 0) {
            for (int i = 0; i < k; i++) {
                swap(nums, start + i, nums.length - k + i);
            }
            recursiveSwap(nums, k, start + k, length - k);
        }
    }

    /**
     * 数组之间两两交换
     *
     * @param nums 数组
     * @param i    i
     * @param j    j
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void print(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RotateArrays rotateArrays = new RotateArrays();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotateArrays.rotate1(nums, k);
    }
}
