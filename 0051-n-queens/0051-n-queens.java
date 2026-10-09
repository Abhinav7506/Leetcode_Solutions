class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        backtrack(0, board, n, ans);
        return ans;
    }

    private void backtrack(
            int row, char[][] board, int n,
            List<List<String>> ans) {
        if (row == n) {
            List<String> solution = new ArrayList<>();

            for (char[] r : board) {
                solution.add(new String(r));
            }
            ans.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {

            if (!isSafe(board, row, col, n)) {
                continue;
            }
            board[row][col] = 'Q';
            backtrack(row + 1, board, n, ans);
            board[row][col] = '.';
        }
    }
    private boolean isSafe(
            char[][] board, int row, int col, int n) {

        for (int r = 0; r < row; r++) {
            if (board[r][col] == 'Q') {
                return false;
            }
        }
        for (int r = row - 1, c = col - 1;
             r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }
        for (int r = row - 1, c = col + 1;
             r >= 0 && c < n; r--, c++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }
        return true;
    }
}