package juejin.lc.leetCode;

/**
 * 验证回文串
 *
 * @author liuchao
 * @date 2019/6/6
 */
public class IsPalindromeSolution {
    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     * 示例 1:
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     * 示例 2:
     * 输入: "race a car"
     * 输出: false
     *
     * @param s 输入字符串
     * @return 返回结果
     */
    private boolean solution(String s) {
        if (null == s) {
            return false;
        }
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                ++i;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                --j;
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }

    public static void main(String[] args) {
        IsPalindromeSolution isPalindromeSolution = new IsPalindromeSolution();
//        String s = "A man, a plan, a canal: Panama";
//        System.out.println(isPalindromeSolution.solution(s));
        String s1 = "race a car";
        System.out.println(isPalindromeSolution.solution(s1));
    }
}
