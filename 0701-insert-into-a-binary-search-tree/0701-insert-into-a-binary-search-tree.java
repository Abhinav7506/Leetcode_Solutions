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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);

        if (root == null) {
            return newNode;
        }

        TreeNode move = root;

        while (true) {
            if (val < move.val) {
                if (move.left == null) {
                    move.left = newNode;
                    break;
                }
                move = move.left;
            } else {
                if (move.right == null) {
                    move.right = newNode;
                    break;
                }
                move = move.right;
            }
        }

        return root;
    }
}