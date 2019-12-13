package juejin.lc.leetCode;

public class FirstBadVersion {
    /**
     * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。
     * 由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
     * <p>
     * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
     * <p>
     * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。
     * 实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
     * <p>
     * 示例:
     * <p>
     * 给定 n = 5，并且 version = 4 是第一个错误的版本。
     * <p>
     * 调用 isBadVersion(3) -> false
     * 调用 isBadVersion(5) -> true
     * 调用 isBadVersion(4) -> true
     * <p>
     * 所以，4 是第一个错误的版本。
     *
     * @param n 最新版本号
     * @return 第一个错误的版本
     */
    private int solution(int n) {
        // 尽量减少调用api的次数，实际上就是二分法的变体
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static final int VERSION = 2;

    private boolean isBadVersion(int n) {
        System.out.println("调用api..." + n);
        return n >= VERSION;
    }

    public static void main(String[] args) {
        FirstBadVersion firstBadVersion = new FirstBadVersion();
        int n = 3;
        int result = firstBadVersion.solution(n);
        System.out.println("result === " + result);
    }
}
