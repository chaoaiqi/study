package juejin.lc.leetCode;

public class SumOfLeftLeaves {
    /**
     * 计算给定二叉树的所有左叶子之和。
     * <p>
     * 示例：
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * <p>
     * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
     *
     * @param root
     * @return
     */
    public int solution(TreeNode root) {
        // 边界条件
        if (null == root) {
            return 0;
        }
        return recursion(root, false);
    }

    /**
     * @param root 二叉树
     * @param flag 是否是左节点
     * @return
     */
    private int recursion(TreeNode root, boolean flag) {
        // 边界条件
        if (null == root) {
            return 0;
        }
        if (flag && null == root.left && null == root.right) {
            return root.val;
        }
        int leftSum = recursion(root.left, true);
        int rightSum = recursion(root.right, false);
        return leftSum + rightSum;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
