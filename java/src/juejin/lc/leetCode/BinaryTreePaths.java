package juejin.lc.leetCode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths {
    /**
     * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
     * 说明: 叶子节点是指没有子节点的节点。
     * 示例:
     * 输入:
     *
     *    1
     *  /   \
     * 2     3
     *  \
     *   5
     * 输出: ["1->2->5", "1->3"]
     * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
     * @param root 二叉树
     * @return 二叉树的所有路径
     */
    private List<String> solution(TreeNode root) {
        LinkedList<String> paths = new LinkedList<>();
        constructPaths(root, "", paths);
        return paths;
    }

    private void constructPaths(TreeNode root, String path, LinkedList<String> paths) {
        if (null != root){
            path += Integer.toString(root.val);
            if (null == root.left && null == root.right){
                paths.add(path);
            }else {
                path += "->";
                constructPaths(root.left, path, paths);
                constructPaths(root.right, path, paths);
            }
        }
    }
    private TreeNode createTreeNode(){
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        node.left = node1;
        node.right = node2;
        node1.right = new TreeNode(5);
        return node;
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
        TreeNode root = binaryTreePaths.createTreeNode();
        List<String> list = binaryTreePaths.solution(root);
        System.out.println(list.toString());
    }

}
