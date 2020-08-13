package juejin.lc.leetCode;

public class SumOfLeftLeaves {
    private int sum = 0;
    /**
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
     * @param root 二叉树
     * @return 返回和
     */
    public int solution(TreeNode root) {
        recursion(root,"root");
        return sum;
    }
    private void recursion(TreeNode treeNode, String type) {
        if (null == treeNode) return;
        System.out.println(treeNode.val + " " + type);
        if ("left".equals(type) && null == treeNode.left && null == treeNode.right){
            sum += treeNode.val;
        }
        System.out.println("sum ====>" + sum);
        recursion(treeNode.left,"left");
        recursion(treeNode.right,"right");
    }

    private TreeNode createNode() {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(20);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        TreeNode treeNode3 = new TreeNode(15);
        TreeNode treeNode4 = new TreeNode(7);
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        return treeNode;
    }
    public static void main(String[] args) {
        SumOfLeftLeaves sumOfLeftLeaves = new SumOfLeftLeaves();
        TreeNode treeNode = sumOfLeftLeaves.createNode();
        int res = sumOfLeftLeaves.solution(treeNode);
        System.out.println("res = " + res);
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
