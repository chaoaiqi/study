package juejin.lc.leetCode;

import javax.swing.tree.TreeNode;

/**
 * 判断一个二叉树是否平衡
 *
 * @author liuchao
 * @date 2019/5/29
 */
public class IsBalanced {
    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * 本题中，一棵高度平衡二叉树定义为：
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
     * 示例 1:
     * 给定二叉树 [3,9,20,null,null,15,7]
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回 true
     * 示例 2:
     * 给定二叉树 [1,2,2,3,3,null,null,4,4]
     * 1
     * / \
     * 2   2
     * / \
     * 3   3
     * / \
     * 4   4
     * 返回 false
     *
     * @param root 二叉树
     * @return 返回结果
     */
    private boolean solution(TreeNode root) {
        if (null == root) {
            return true;
        }
        return (Math.abs(depth(root.left) - depth(root.right)) <= 1) && solution(root.left) && solution(root.right);
    }

    private int depth(TreeNode root) {
        //递归出口
        if (null == root) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        IsBalanced isBalanced = new IsBalanced();
//        [1,null,2,null,3]
        TreeNode node = new TreeNode(1);
        node.left = null;
        node.right = new TreeNode(2);
        node.right.left = null;
        node.right.right = new TreeNode(3);
        boolean bool = isBalanced.solution(node);
        System.out.println(bool);
    }
}
