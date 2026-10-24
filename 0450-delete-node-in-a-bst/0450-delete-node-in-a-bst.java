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
    public TreeNode deleteNode(TreeNode root, int key) {        
        TreeNode move = root;
        TreeNode prev=null;
        while(move!=null && move.val != key){
            prev=move;
            if(move.val > key){
                move=move.left;
            }
            else{
                move=move.right;
            }
        }

        if(move==null) return root;
        if (move.left != null && move.right != null) {
            TreeNode successorParent = move;
            TreeNode successor = move.right;

            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            move.val = successor.val;

            if (successorParent.left == successor) {
                successorParent.left = successor.right;
            } else {
                successorParent.right = successor.right;
            }

            return root;
        }

        TreeNode child;

        if (move.left != null) {
            child = move.left;
        } else {
            child = move.right;
        }

        if (prev == null) {
            return child;
        }

        if (prev.left == move) {
            prev.left = child;
        } else {
            prev.right = child;
        }

        return root;
    }
}