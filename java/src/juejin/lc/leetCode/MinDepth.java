package juejin.lc.leetCode;


/**
 * 二叉树的最小深度
 *
 * @author liuchao
 * @date 2019/5/29
 */
public class MinDepth {
    /**
     * @param root 二叉树
     * @return 最小深度
     */
    private int solution(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = solution(root.left);
        int right = solution(root.right);
        if (left == 0) {
            return right + 1;
        }
        if (right == 0) {
            return left + 1;
        }
        return Math.min(left, right) + 1;
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
