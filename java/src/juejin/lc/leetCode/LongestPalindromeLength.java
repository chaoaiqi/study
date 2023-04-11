package juejin.lc.leetCode;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromeLength {
    /**
     * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
     * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
     * 注意:
     * 假设字符串的长度不会超过 1010。
     * 示例 1:
     * 输入:
     * "abccccdd"
     * 输出:
     * 7
     * 解释:
     * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
     *
     * @param s
     * @return
     */
    public int solution(String s) {
        // 边界条件
        int n = s.length();
        if (n < 2) {
            return n;
        }
        char[] chars = new char[128];
        for (char c : s.toCharArray()) {
            ++chars[c];
        }
        int ans = 0;
        for (int v : chars) {
            // 忽略奇数
            ans += v / 2 * 2;
            // 填充奇数
            if ((v & 1) == 1 && (ans & 1) == 0) {
                ++ans;
            }
        }
        return ans;
    }

    public int solution1(String s) {
        // 边界条件
        int n = s.length();
        if (n < 2) {
            return n;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], map.get(chars[i]) + 1);
            } else {
                map.put(chars[i], 1);
            }
        }

        // map场景
        // 大于2的均可以2的倍数的长度的字符串作为回文串
        // 然后找一个 奇数的其中一位作为回文串中间值
        int sum = 0;
        int center = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int v = entry.getValue();
            if ((v & 1) == 0) {
                sum += v;
            } else {
                // 奇数
                sum += (v - 1);
                if (center == 0) {
                    center = 1;
                }
            }
        }
        return sum + center;
    }

    public static void main(String[] args) {
        String s = "abccccdd";
        int sum = new LongestPalindromeLength().solution(s);
        System.out.println("sum = " + sum);
    }
}
