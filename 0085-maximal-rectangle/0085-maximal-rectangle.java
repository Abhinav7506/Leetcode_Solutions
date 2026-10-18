class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == '1') {
                    heights[c]++;
                } else {
                    heights[c] = 0;
                }
            }
            Deque<Integer> stack = new ArrayDeque<>();

            for (int i = 0; i <= cols; i++) {
                int currentHeight = (i == cols) ? 0 : heights[i];

                while (!stack.isEmpty() &&
                       heights[stack.peek()] > currentHeight) {

                    int height = heights[stack.pop()];

                    int width = stack.isEmpty()
                            ? i
                            : i - stack.peek() - 1;

                    maxArea = Math.max(maxArea, height * width);
                }

                stack.push(i);
            }
        }

        return maxArea;
    }
}