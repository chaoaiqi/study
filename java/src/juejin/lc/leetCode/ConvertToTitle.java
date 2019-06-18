package juejin.lc.leetCode;

/**
 * Excel表列名称
 *
 * @author liuchao
 * @date 2019/6/18
 */
public class ConvertToTitle {
    /**
     * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
     * 例如，
     * 1 -> A
     * 2 -> B
     * 3 -> C
     * ...
     * 26 -> Z
     * 27 -> AA
     * 28 -> AB
     * ...
     * 示例 1:
     * 输入: 1
     * 输出: "A"
     * 示例 2:
     * 输入: 28
     * 输出: "AB"
     * 示例 3:
     * 输入: 701
     * 输出: "ZY"
     *
     * @param n line
     * @return row
     */
    private String solution(int n) {
        if (n <= 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (n > 0) {
            --n;
            System.out.println(n + " % 26 = " + (char) (n % 26 + 'A'));
            stringBuilder.append((char) (n % 26 + 'A'));
            System.out.println(n + " / 26 = " + (n / 26));
            n /= 26;
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        ConvertToTitle convertToTitle = new ConvertToTitle();
        int n = 703;
        String str = convertToTitle.solution(n);
        System.out.println("result:" + str);
    }
}
