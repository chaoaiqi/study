package juejin.lc.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 *
 * @author liuchao
 * @date 2019/5/29
 */
public class GenerateSolution {
    /**
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     * 示例:
     * 输入: 5
     * 输出:
     * [
     * [1],
     * [1,1],
     * [1,2,1],
     * [1,3,3,1],
     * [1,4,6,4,1]
     * ]
     *
     * @param numRows 整数
     * @return 返回结果
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows == 0) {
            return triangle;
        }
        //numRows = 1 特殊处理
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);
        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> perRow = triangle.get(rowNum - 1);
            row.add(1);
            for (int i = 1; i < rowNum; i++) {
                row.add(perRow.get(i - 1) + perRow.get(i));
            }
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }

    /**
     * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     * 示例:
     * 输入: 3
     * 输出: [1,3,3,1]
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        // * 获取杨辉三角的指定行
        // * 直接使用组合公式C(n,i) = n!/(i!*(n-i)!)
        // * 则第(i+1)项是第i项的倍数=(n-i)/(i+1);
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        long cur = 1;
        for (int i = 0; i <= rowIndex; i++) {
            res.add((int) cur);
            cur = cur * (rowIndex - i) / (i + 1);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
