/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean rec(TreeNode node, int sum, int targetSum) {
        sum += node.val;
        if (node.left == null && node.right == null) {
            return sum == targetSum;
        }
        if (node.left != null){
            boolean ret = rec(node.left, sum, targetSum);
            if (ret) {
                return ret;
            }
        }
        if (node.right != null){
            boolean ret = rec(node.right, sum, targetSum);
            if (ret) {
                return ret;
            }
        }
        return false;
   }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return root != null && rec(root, 0, targetSum);
    }
}