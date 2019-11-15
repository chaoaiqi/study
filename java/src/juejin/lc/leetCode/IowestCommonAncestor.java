package juejin.lc.leetCode;

public class IowestCommonAncestor {
    /**
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：
     * “对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大
     * （一个节点也可以是它自己的祖先）。”
     * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
     *
     * 示例 1:
     *
     * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     * 输出: 6
     * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
     * 示例 2:
     *
     * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
     * 输出: 2
     * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
     *  
     *
     * 说明:
     *
     * 所有节点的值都是唯一的。
     * p、q 为不同节点且均存在于给定的二叉搜索树中。
     *
     * @param root 二叉树
     * @param p 二叉树子节点
     * @param q 二叉树子节点
     * @return 节点树
     */
    public TreeNode solution(TreeNode root, TreeNode p, TreeNode q) {
        int rootVal = root.val;
        int pVal =  p.val;
        int qVal = q.val;
        if (pVal > rootVal && qVal > rootVal) {
            return solution(root.right,p,q);
        }else if(pVal < rootVal && qVal < rootVal) {
            return solution(root.left,p,q);
        }
        return root;
    }
    public TreeNode solution1(TreeNode root, TreeNode p, TreeNode q) {
        int pVal =  p.val;
        int qVal = q.val;
        TreeNode node = root;
        while (null != node) {
            int rootVal = node.val;
            if (pVal > rootVal && qVal > rootVal) {
                node = node.right;
            }else if(pVal < rootVal && qVal < rootVal) {
                node = node.left;
            }else {
                return node;
            }
        }
        return node;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {

    }
}
