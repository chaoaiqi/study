package juejin.lc.leetCode;

public class GuessNumber {
    /**
     * 我们正在玩一个猜数字游戏。 游戏规则如下：
     * 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
     * 每次你猜错了，我会告诉你这个数字是大了还是小了。
     * 你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
     * <p>
     * -1 : 我的数字比较小
     * 1 : 我的数字比较大
     * 0 : 恭喜！你猜对了！
     * 示例 :
     * <p>
     * 输入: n = 10, pick = 6
     * 输出: 6
     *
     * @param n 数字范围
     * @return 返回值
     */
    private int solution(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = guess(mid);
            if (res == 0) {
                return mid;
            } else if (res < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private int pick = 6;

    private int guess(int num) {
        if (num > pick) {
            return -1;
        } else if (num < pick) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        GuessNumber guessNumber = new GuessNumber();
        int n = 10;
        int res = guessNumber.solution(n);
        System.out.println("res = " + res);
    }
}
