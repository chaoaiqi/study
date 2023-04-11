package juejin.lc.leetCode;

/**
 * 整数反转
 * 各种回文
 *
 * @author liuchao
 * @date 2019/5/22
 */
public class NumberReverse {
    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
     * 请根据这个假设，如果反转后整数溢出那么就返回 0。
     *
     * @param x 传入整数
     */
    private static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    /**
     * 判断是否是回文数
     * 并且不将其转成字符串
     *
     * @param x 传入整数
     * @return 返回结果
     */
    private static boolean isPalindrome(int x) {
        if (x >= 0) {
            String str = String.valueOf(x);
            if (x < 10 || str.equals(new StringBuilder(str).reverse().toString())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断链表是否回文
     * 快慢指针法
     *
     * @param head 链表
     * @return 返回值
     */
    private boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (null != fast.next && null != fast.next.next) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = slow.next;
        ListNode prev = null;
        while (null != slow) {
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        while (null != prev) {
            if (head.val != prev.val) {
                return false;
            }
            head = head.next;
            prev = prev.next;
        }
        return true;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        //max = 2147483647
        int max = Integer.MAX_VALUE;
        //min = -2147483648
        int min = Integer.MIN_VALUE;
        System.out.println(reverse(max));
        System.out.println(reverse(min));
    }
}
