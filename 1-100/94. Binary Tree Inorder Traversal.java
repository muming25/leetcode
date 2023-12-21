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
    List<Integer> list;
    void rec(TreeNode node){
        if (node.left != null) {
            rec(node.left);
        }
        list.add(node.val);
        if (node.right != null) {
            rec(node.right);
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        list = new ArrayList();
        if (root != null) {
            rec(root);
        }
        return list;
    }
}