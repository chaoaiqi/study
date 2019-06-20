package juejin.lc.dynamicProgramming;

/**
 * 最长递增子序列
 * @author liuchao
 * @date 2019/6/19
 */
public class LongestIncreasingSubSequence {
    /**
     * 最长递增子序列（Longest Increasing Subsequence）是指找到一个给定序列的最长子序列的长度，使得子序列中的所有元素单调递增。
     * 例如：{ 3，5，7，1，2，8 } 的 LIS 是 { 3，5，7，8 }，长度为 4。
     * @param s 字符串
     * @return 返回长度
     */
    private int solution(String s){
        //推公式
        //F[x] = max{1,F[i]+1|ai<ax && i<x}
        return 0;
    }
}
