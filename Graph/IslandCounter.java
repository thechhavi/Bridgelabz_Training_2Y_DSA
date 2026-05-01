
public class IslandCounter {
    static int[][] grid;
    static int m, n;

    public static int countIslandsDFS(int[][] g) {
        grid = g;
        m = grid.length;
        n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    static void dfs(int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) return;

        grid[i][j] = 0;
        dfs(i+1, j);
        dfs(i-1, j);
        dfs(i, j+1);
        dfs(i, j-1);
    }
}
