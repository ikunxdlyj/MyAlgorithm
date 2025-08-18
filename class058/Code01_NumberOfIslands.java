package class058;

public class Code01_NumberOfIslands {
    public int numIslands(char[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    dfs(i,j, grid);
                }
            }
        }
        return cnt;
    }
    public void dfs(int i, int j, char[][] grid) {
        if(i<0||i>grid.length-1||j<0||j>grid[0].length-1||grid[i][j]!='1') return;
        grid[i][j]='#';
        dfs(i-1, j, grid);
        dfs(i+1, j, grid);
        dfs(i, j-1, grid);
        dfs(i, j+1, grid);
    }
}