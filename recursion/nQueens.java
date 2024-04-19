import java.util.ArrayList;
import java.util.List;

public class nQueens {
    static boolean isSafe(int row, int col, int[][] matrix) {
        int x = row;
        int y = col;

        while (y >= 0) {
            if (matrix[x][y] == 1) {
                return false;
            }
            y--;
        }
        x = row;
        y = col;

        while (x >= 0 && y >= 0) {
            if (matrix[x][y] == 1) {
                return false;
            }
            x--;
            y--;
        }

        while (x >= 0 && y >= 0) {
            if (matrix[x][y] == 1) {
                return false;
            }
            x++;
            y--;
        }
        return true;
    }

    static void solve(List<List<String>> ans, int[][] matrix, int col, int n) {
        if (col >= n) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < matrix[0].length; i++) {
                String s = "";
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[i][j] == 0) {
                        s += ".";
                    } else {
                        s += "Q";
                    }
                }
                tmp.add(s);
            }
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < matrix.length; i++) {
            if (isSafe(i, col, matrix)) {
                matrix[i][col] = 1;
                solve(ans, matrix, col + 1, n);
                matrix[i][col] = 0;
            }
        }

    }

    static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[][] matrix = new int[n][n];
        solve(ans, matrix, 0, n);
        return ans;
    }
}
