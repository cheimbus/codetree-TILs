import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static int n,m;
    public static final int MAX_VAL = 5;
    public static final int MIN_VAL = Integer.MIN_VALUE;
    public static int[][] grid = new int[MAX_VAL][MAX_VAL];
    public static int[][] board = new int[MAX_VAL][MAX_VAL];

    public static boolean checkBoard() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] >= 2) return true;
            }
        }
        return false;
    }

    public static void emptyBoard() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                board[i][j] = 0;
            }
        }
    }

    public static void draw(int x1, int y1, int x2, int y2) {
        for(int i = x1; i <= x2; i++) {
            for(int j = y1; j <= y2; j++) {
                board[i][j] ++;
            }
        }
    }

    public static boolean overlapped(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        emptyBoard();
        draw(x1, y1, x2, y2);
        draw(x3, y3, x4, y4);

        return checkBoard();
    }

    public static int rectSum(int x1, int y1, int x2, int y2) {
        int sum = 0;
        for(int i = x1; i <= x2; i++) {
            for(int j = y1; j <= y2; j++) {
                sum += grid[i][j];
            }
        }
        return sum;
    }

    public static int findMaxSum(int x1, int y1, int x2, int y2) {
        int maxVal = MIN_VAL;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = i; k < n; k++) {
                    for (int l = j; l < m; l++) {
                        if(!overlapped(x1, y1, x2, y2, i, j, k, l)) {
                            maxVal = Math.max(maxVal, rectSum(x1, y1, x2, y2) + rectSum(i, j, k, l));
                        }
                    }
                }
            }
        }
        return maxVal;
    }

    public static int findMaxSum() {
        int maxVal = MIN_VAL;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int k = i; k < n; k++) {
                    for(int l = j; l < m; l++) {
                        maxVal = Math.max(maxVal, findMaxSum(i, j, k, l));
                    }
                }
            }
        }
        return maxVal;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        for(int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                int num = Integer.parseInt(stk.nextToken());
                grid[i][j] = num;
            }
        }

        int ans = findMaxSum();
        bw.write(String.valueOf(ans));

        bw.flush();
        bw.close();
    }
}