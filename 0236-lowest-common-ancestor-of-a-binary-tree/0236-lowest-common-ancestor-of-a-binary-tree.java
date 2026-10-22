/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathToP = new ArrayList<>();
        List<TreeNode> pathToQ = new ArrayList<>();
        rootToNode(root,p,pathToP);
        rootToNode(root,q,pathToQ);
        TreeNode lca = null;
        int i = 0;

        while (i < pathToP.size() &&
               i < pathToQ.size() &&
               pathToP.get(i) == pathToQ.get(i)) {

            lca = pathToP.get(i);
            i++;
        }

        return lca;
    }
    boolean rootToNode(TreeNode root ,TreeNode p , List<TreeNode> path){
        if(root==null) return false;
        path.add(root);

        if(root == p){
            return true;
        }
        if (rootToNode(root.left, p, path) ||
        rootToNode(root.right, p, path)) {
        return true;
    }

    path.remove(path.size() - 1);
    return false;
}
}