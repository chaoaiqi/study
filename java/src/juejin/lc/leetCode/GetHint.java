package juejin.lc.leetCode;

import java.util.ArrayList;
import java.util.List;

public class GetHint {
    /**
     * 你正在和你的朋友玩 猜数字（Bulls and Cows）游戏：你写下一个数字让你的朋友猜。
     * 每次他猜测后，你给他一个提示，告诉他有多少位数字和确切位置都猜对了（称为“Bulls”, 公牛），
     * 有多少位数字猜对了但是位置不对（称为“Cows”, 奶牛）。
     * 你的朋友将会根据提示继续猜，直到猜出秘密数字。
     * <p>
     * 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，用 A 表示公牛，用 B 表示奶牛。
     * <p>
     * 请注意秘密数字和朋友的猜测数都可能含有重复数字。
     * 示例 1:
     * 输入: secret = "1807", guess = "7810"
     * 输出: "1A3B"
     * 解释: 1 公牛和 3 奶牛。公牛是 8，奶牛是 0, 1 和 7。
     * <p>
     * 示例 2:
     * 输入: secret = "1123", guess = "0111"
     * 输出: "1A1B"
     * 解释: 朋友猜测数中的第一个 1 是公牛，第二个或第三个 1 可被视为奶牛。
     *
     * @param secret 秘密数字
     * @param guess  猜测数
     * @return 返回结果
     */
    private String solution(String secret, String guess) {
        int bullsCount = 0;
        int cowsCount = 0;
        char[] secretArrs = secret.toCharArray();
        char[] guessArrs = guess.toCharArray();
        List<Character> secretList = new ArrayList<>();
        List<Character> guessList = new ArrayList<>();
        // 先判断 A
        for (int i = 0; i < secretArrs.length; i++) {
            if (secretArrs[i] == guessArrs[i]) {
                ++bullsCount;
            } else {
                secretList.add(secretArrs[i]);
                guessList.add(guessArrs[i]);
            }
        }
        for (Character c : guessList) {
            if (secretList.contains(c)) {
                ++cowsCount;
                secretList.remove(c);
            }
        }
        return bullsCount + "A" + cowsCount + "B";
    }

    public static void main(String[] args) {
        GetHint getHint = new GetHint();
        String secret = "11";
        String guess = "10";
        String result = getHint.solution(secret, guess);
        System.out.println("result = " + result);
    }
}
