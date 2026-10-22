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
    class Entry {
    TreeNode node;
    int row, col;

    Entry(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        
        if(root==null) return answer;
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map =
            new TreeMap<>();

        Queue<Entry> queue = new ArrayDeque<>();
        queue.offer(new Entry(root, 0, 0));
        while (!queue.isEmpty()) {
            Entry item = queue.poll();
            TreeNode node = item.node;
            int row = item.row;
            int col = item.col;

            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new PriorityQueue<>());
            map.get(col).get(row).offer(node.val);

            if (node.left != null) {
                queue.offer(new Entry(node.left, row + 1, col - 1));
            }

            if (node.right != null) {
                queue.offer(new Entry(node.right, row + 1, col + 1));
            }
        }

        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {
            List<Integer> column = new ArrayList<>();

            for (PriorityQueue<Integer> values : rows.values()) {
                while (!values.isEmpty()) {
                    column.add(values.poll());
                }
            }

            answer.add(column);
        }

        return answer;
    }
}