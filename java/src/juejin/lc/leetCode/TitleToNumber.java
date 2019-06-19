package juejin.lc.leetCode;

/**
 * Excel表序列号
 *
 * @author liuchao
 * @date 2019/6/19
 */
public class TitleToNumber {
    /**
     * 给定一个Excel表格中的列名称，返回其相应的列序号。
     * 例如，
     * A -> 1
     * B -> 2
     * C -> 3
     * ...
     * Z -> 26
     * AA -> 27
     * AB -> 28
     * ...
     * 示例 1:
     * 输入: "A"
     * 输出: 1
     * 示例 2:
     * 输入: "AB"
     * 输出: 28
     * 示例 3:
     * 输入: "ZY"
     * 输出: 701
     *
     * @param s 字符串
     * @return 返回值
     */
    private int solution(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += Math.pow(26, s.length() - 1 - i) * (s.charAt(i) - 'A' + 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        TitleToNumber titleToNumber = new TitleToNumber();
        String s = "ZY";
        int res = titleToNumber.solution(s);
        System.out.println(res);
    }
}
