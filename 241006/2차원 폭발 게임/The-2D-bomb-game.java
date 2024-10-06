import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static final int MAX_N = 100;
    public static int n,m,k;
    public static int[][] grid = new int[MAX_N][MAX_N];

    public static void toZero(int row1, int row2, int col) {
        for(int i = row1; i <= row2; i ++) {
            grid[i][col] = 0;
        }
    }

    public static void bomb() {

        for(int col = 0; col < n; col ++) {
            for(int row1 = 0; row1 <= n - 1; row1 ++) {
                if(grid[row1][col] == 0) continue;
                int target = grid[row1][col];
                int mCnt = 1;
                int row2Range = 0;
                for(int row2 = row1 + 1; row2 < n; row2 ++) {
                    if(target == grid[row2][col]) {
                        mCnt ++;
                        row2Range = row2;
                    }
                    else break;
                }
                if(mCnt >= m) {
                    toZero(row1, row2Range, col);
                }
            }
        }
    }

    public static void drop() {
        int[][] tmpGrid = new int[MAX_N][MAX_N];
        for(int col = 0; col < n; col ++) {
            int tmpCnt = n - 1;
            for(int row = n - 1; row >= 0; row --) {
                if(grid[row][col] != 0) tmpGrid[tmpCnt --][col] = grid[row][col];
            }
        }

        for(int row = 0; row < n; row ++) {
            for(int col = 0; col < n; col ++) {
                grid[row][col] = tmpGrid[row][col];
            }
        }
    }

    public static void tilt() {
        int[][] tmpGrid = new int[MAX_N][MAX_N];

        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j ++) {
                tmpGrid[i][j] = grid[n - 1 - j][i];
            }
        }

        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j ++) {
                grid[i][j] = tmpGrid[i][j];
            }
        }
    }

    public static int countBomb() {
        int cnt = 0;
        for(int row = 0; row < n; row ++) {
            for(int col = 0; col < n; col ++) {
                if(grid[row][col] != 0) cnt ++;
            }
        }

        return cnt;
    }

    public static int simulation() {
        for(int i = 0; i < k; i ++) {
            bomb();
            drop();
            tilt();
            drop();
        }

        bomb();
        drop();

        int cnt = countBomb();

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        for(int i = 0; i < n; i ++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j ++) {
                int num = Integer.parseInt(stk.nextToken());
                grid[i][j] = num;
            }
        }

        int cnt = simulation();

        bw.write(cnt+"\n");
        bw.flush();
        bw.close();
    }
}