package juejin.lc.leetCode;


/**
 * 将有序数组转化为二叉搜索树
 *
 * @author liuchao
 * @date 2019/5/29
 */
public class SortedArrayToBST {
    /**
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
     * 示例:
     * 给定有序数组: [-10,-3,0,5,9],
     * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
     * 0
     * / \
     * -3   9
     * /   /
     * -10  5
     *
     * @param nums 有序数组
     * @return 二叉搜索树
     */
    private TreeNode solution(int[] nums) {
        // 左右等分建立左右子树，中间节点作为子树根节点，递归该过程
        return nums == null ? null : buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + ((high - low) >> 1);
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildTree(nums, low, mid - 1);
        node.right = buildTree(nums, mid + 1, high);
        return node;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    private void inOrderTraversal(TreeNode node){
        if (null == node){
            return;
        }
        System.out.print(node.val + " ");
        inOrderTraversal(node.left);
        inOrderTraversal(node.right);
    }
    public static void main(String[] args) {
        SortedArrayToBST sortedArrayToBST = new SortedArrayToBST();
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode node = sortedArrayToBST.solution(nums);
        sortedArrayToBST.inOrderTraversal(node);
    }
}
