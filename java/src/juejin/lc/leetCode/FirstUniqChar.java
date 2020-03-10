package juejin.lc.leetCode;

public class FirstUniqChar {
    /**
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     * <p>
     * 案例:
     * <p>
     * s = "leetcode"
     * 返回 0.
     * <p>
     * s = "loveleetcode",
     * 返回 2.
     *
     * @param s s
     * @return r
     */
    private int solution(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (s.indexOf(chars[i]) == s.lastIndexOf(chars[i])) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstUniqChar firstUniqChar = new FirstUniqChar();
        String s = "cc";
        int res = firstUniqChar.solution(s);
        System.out.println("res = " + res);
    }
}
