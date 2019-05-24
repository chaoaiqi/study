package juejin.lc.leetCode;

/**
 * 给定一个 haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回  -1。
 * "" ""  0
 * "**" "" 0
 * "" "**" -1
 * @author liuchao
 * @date 2019/5/24
 */
public class StrStrSolution {
    public int solution(String haystack, String needle) {
        if ("".equals(needle) ||needle.equals(haystack)) {
            return 0;
        }
        if ("".equals(haystack)) {
            return -1;
        }
        int hlen = haystack.length();
        int nlen = needle.length();
        //hello ll
        for (int i = 0; i <= hlen - nlen; i++) {
            int j = 0;
            for (; j < nlen; j++) {
                System.out.println(haystack.charAt(i + j) + " -- " + needle.charAt(j));
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == nlen) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        StrStrSolution strStrSolution = new StrStrSolution();
        String hasystack = "a";
        String needle = "a";
        System.out.println(strStrSolution.solution(hasystack,needle));
    }
}
