package juejin.lc.leetCode;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * 按层遍历
 * 自下向上输出
 *
 * @author liuchao
 * @date 2019/5/28
 */
public class LevelOrderBottom {
    /**
     * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7],
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回其自底向上的层次遍历为：
     * [
     * [15,7],
     * [9,20],
     * [3]
     * ]
     *
     * @param root 二叉树
     * @return 集合
     */
    public List<List<Integer>> solution(TreeNode root) {
        if (null == root) {
            return new ArrayList<>();
        }
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (null != node) {
                    list.add(node.val);
                    if (null != node.left) {
                        queue.offer(node.left);
                    }
                    if (null != node.right) {
                        queue.offer(node.right);
                    }
                }
            }
            lists.add(list);
        }
        Collections.reverse(lists);
        return lists;
    }

    private void traversal(TreeNode root) {
        if (null == root) return;
        System.out.print(root.val + " ");
        traversal(root.right);
        traversal(root.left);
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
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = null;
        root.left.right = new TreeNode(15);
        root.right.left = null;
        root.right.right = new TreeNode(7);
        LevelOrderBottom levelOrderBottom = new LevelOrderBottom();
        //将其输出反转就是常规二叉树的自下向上输出
//        levelOrderBottom.traversal(root);
        List<List<Integer>> lists = levelOrderBottom.solution(root);
        for (List<Integer> list : lists) {
            System.out.print("[");
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println("]");
        }
    }
}
