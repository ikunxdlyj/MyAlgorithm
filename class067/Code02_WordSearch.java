package class067;

public class Code02_WordSearch {
    public boolean exist(char[][] board, String word) {
        char[] s = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, 0, board, s)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean dfs(int i, int j, int k, char[][] board, char[] s) {
        if (k == s.length) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != s[k]) return false;
//        char temp = board[i][j];
//        board[i][j] = '#';
//
//        boolean flag = dfs(i + 1, j, k + 1, board, s) || dfs(i - 1, j, k + 1, board, s)
//                || dfs(i, j + 1, k + 1, board, s) || dfs(i, j - 1, k + 1, board, s);
//        board[i][j] = temp;
//        return flag;
        char temp = board[i][j];
        board[i][j] = '#';
        boolean ans = false;
        for (int[] move : move) {
            ans |= dfs(i + move[0], j + move[1], k + 1, board, s);
        }
        board[i][j] = temp;
        return ans;
    }
}