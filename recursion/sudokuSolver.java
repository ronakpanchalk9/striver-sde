import java.util.Arrays;
import java.util.Scanner;

public class sudokuSolver {
    public boolean isSafe(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
            if (board[row][i] == num) {
                return false;
            }
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == num) {
                return false;
            }
            // return true;
        }
        return true;
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    for (char j2 = '1'; j2 <= '9'; j2++) {
                        if (isSafe(board, i, j, j2)) {
                            board[i][j] = j2;
                        }
                        if (solve(board)) {
                            return true;
                        } else {
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void sudoku(char[][] board) {
        solve(board);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            int sum = 0;
            for (int j = 0; j < n; j++) {
                a[j] = sc.nextInt();
                // sum += a[j];
            }
            for (int j = 0; j < n; j++) {
                b[j] = sc.nextInt();
                // sum += b[j];
            }
            Arrays.sort(a);
            sum = a[n-1]+b[0];
            for (int j = 0; j < b.length; j++) {
                
            }
            if (sum % n != 0) {
                System.out.println(-1);
                continue;
            } else {
                int temp = sum / n;
                int[] c = new int[n];

                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        if (a[k] + b[l] == temp) {
                            c[k] = b[l];
                            b[l] = -100;
                        }
                    }
                }
                for (int j = 0; j < n; j++) {
                    System.out.print(a[j] + " ");
                }
                System.out.println();
                for (int j = 0; j < n; j++) {
                    System.out.print(c[j] + " ");
                }
                // System.out.println(Arrays.toString(a));
                // System.out.println(Arrays.toString(c));
            }
        }
    }
}
