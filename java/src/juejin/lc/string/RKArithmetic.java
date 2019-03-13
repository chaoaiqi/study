package juejin.lc.string;

import java.math.BigInteger;
import java.util.Random;

/**
 * RK算法
 */
public class RKArithmetic {

    /**
     * 模式串
     */
    private String pattern;
    /**
     * 模式串长度
     */
    private int pLen;
    /**
     * 模式串hash值
     */
    private long patHash;
    /**
     * 一个非常大的素数
     */
    private long slat;
    /**
     * 字母表长度
     */
    private int aLen;
    /**
     * aLen^(pLen - 1) % slat
     */
    private long aps;


    /**
     * 有参构造方法
     *
     * @param pattern 模式串
     */
    private RKArithmetic(String pattern) {
        this.pattern = pattern;
        pLen = pattern.length();
        aLen = 256;
        slat = longRandomPrime();
        System.out.println("随机素数：" + slat);
        aps = 1;
        // aLen^(pLen - 1) % slat
        for (int i = 1; i <= pLen - 1; i++) {
            aps = (aLen * aps) % slat;
        }
        patHash = hash(pattern, pLen);
        System.out.println("patHash = " + patHash);
    }

    /**
     * rk
     *
     * @param txt 主串
     * @return 模式串
     */
    private int rkSearch(String txt) {
        int n = txt.length();
        if (n < pLen) return -1;
        long txtHash = hash(txt, pLen);
        if ((patHash == txtHash) && check(txt, 0))
            return 0;

        for (int i = pLen; i < n; i++) {
            txtHash = (txtHash + slat - aps * txt.charAt(i - pLen) % slat) % slat;
            txtHash = (txtHash * aLen + txt.charAt(i)) % slat;
            int offset = i - pLen + 1;
            System.out.println("第" + offset + "次txtHash = " + txtHash);
            if ((patHash == txtHash) && check(txt, offset))
                return offset;
        }
        return -1;
    }

    /**
     * hash
     *
     * @param txt 主串
     * @param i   i
     * @return 返回值
     */
    private long hash(String txt, int i) {
        long h = 0;
        for (int j = 0; j < i; j++) {
            h = (aLen * h + txt.charAt(j)) % slat;
        }
        return h;
    }

    /**
     * 校验模式串是否匹配
     *
     * @param txt 主串
     * @param i   i
     * @return 返回值
     */
    private boolean check(String txt, int i) {
        for (int j = 0; j < pLen; j++)
            if (pattern.charAt(j) != txt.charAt(i + j))
                return false;
        return true;
    }

    /**
     * 随机生成一个大素数
     *
     * @return 素数
     */
    private static long longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }

    public static void main(String[] args) {
        String pat = "world";
        String txt = "hello world";
        RKArithmetic searcher = new RKArithmetic(pat);
        int res = searcher.rkSearch(txt);
        System.out.println("RK算法匹配结果：" + res);
    }
}