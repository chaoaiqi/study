package juejin.lc.leetCode;

import java.util.Arrays;
import java.util.Comparator;

public class Merge {
    /**
     * 给出一个区间的集合，请合并所有重叠的区间。
     * <p>
     * 示例 1:
     * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * <p>
     * 示例 2:
     * 输入: intervals = [[1,4],[4,5]]
     * 输出: [[1,5]]
     * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
     *
     * @param intervals
     * @return
     */
    public static int[][] solution(int[][] intervals) {
        // 先按照区间起始位置排序
//        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
        // 遍历区间
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval : intervals) {
            // 如果结果数组是空的，或者当前区间的起始位置> 结果数组的最后区间的终止位置
            // 则不合并、
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                // 反之将当前区间合并至结果数组的最后区间
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        // 取res中有值的数组集合
        return Arrays.copyOf(res, idx + 1);
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res = solution(nums);
        System.out.println(Arrays.deepToString(res));
    }
}
