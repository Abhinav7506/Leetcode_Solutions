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
    class Pair {
        TreeNode node;
        long index;

        Pair(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0L));

        int maxWidth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            long minIndex = queue.peek().index;
            long first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair curr = queue.poll();
                TreeNode node = curr.node;
                long index = curr.index - minIndex;

                if (i == 0) first = index;
                if (i == size - 1) last = index;

                if (node.left != null) {
                    queue.offer(new Pair(node.left, 2 * index + 1));
                }

                if (node.right != null) {
                    queue.offer(new Pair(node.right, 2 * index + 2));
                }
            }

            maxWidth = (int) Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;
    }
}
