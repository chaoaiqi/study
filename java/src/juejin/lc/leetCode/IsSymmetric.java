package juejin.lc.leetCode;

import javax.swing.tree.TreeNode;

/**
 * 对称二叉树
 *
 * @author liuchao
 * @date 2019/5/28
 */
public class IsSymmetric {
    /**
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     * 1
     * / \
     * 2   2
     * / \ / \
     * 3  4 4  3
     * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     * 1
     * / \
     * 2   2
     * \   \
     * 3    3
     *
     * @param root 二叉树
     * @return 返回结果
     */
    private boolean solution(TreeNode root) {
        if (null == root) {
            return true;
        }
        return traversal(root.left, root.right);
    }

    private boolean traversal(TreeNode left, TreeNode right) {
        if (null == left && right == null) {
            return true;
        }
        if (null != left && null != right && left.val == right.val) {
            return traversal(left.left, right.right) && traversal(left.right, right.left);
        }
        return false;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
