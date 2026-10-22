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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        markParents(root, null, parent);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(target);
        visited.add(target);

        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            if (distance == k) {
                List<Integer> result = new ArrayList<>();
                for (TreeNode node : queue) {
                    result.add(node.val);
                }
                return result;
            }

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null && visited.add(node.left)) {
                    queue.offer(node.left);
                }

                if (node.right != null && visited.add(node.right)) {
                    queue.offer(node.right);
                }

                TreeNode p = parent.get(node);
                if (p != null && visited.add(p)) {
                    queue.offer(p);
                }
            }

            distance++;
        }

        return new ArrayList<>();
    }


    
    void markParents(TreeNode node, TreeNode par,Map<TreeNode, TreeNode> parent) {
        if (node == null) return;

        parent.put(node, par);
        markParents(node.left, node, parent);
        markParents(node.right, node, parent);
    }
}
