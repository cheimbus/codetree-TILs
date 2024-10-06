import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static final int MAX_N = 100;
    public static final int B_LEN = 4;
    public static int n;
    public static int cnt = 0;
    public static int[][] grid = new int[MAX_N + 1][MAX_N + 1];
    public static int[][] tmpGrid = new int[MAX_N + 1][MAX_N + 1];
    public static int[][] tmp2Grid = new int[MAX_N + 1][MAX_N + 1];
    public static int[] dx = new int[]{1, 0, -1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static boolean canGo(int row, int col) {
        return row >= 0 && col >= 0 && n > row && n > col;
    }

    public static void bomb(int row, int col) {
        int bombRange = tmpGrid[row][col];
        tmpGrid[row][col] = 0;
        for(int i = 0; i < B_LEN; i ++) {
            int nx = row;
            int ny = col;
            for(int j = 1; j < bombRange; j ++) {
                nx += dx[i]; ny += dy[i];
                if(canGo(nx, ny)) {
                    tmpGrid[nx][ny] = 0;
                }
            }
        }
    }

    public static void drop() {
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j ++) {
                tmp2Grid[i][j] = 0;
            }
        }

        for(int col = 0; col < n; col ++) {
            int rowCnt = n - 1;
            for(int row = n - 1; row >= 0; row --) {
                if(tmpGrid[row][col] != 0) tmp2Grid[rowCnt --][col] = tmpGrid[row][col];
            }
        }

        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j ++) {
                tmpGrid[i][j] = tmp2Grid[i][j];
            }
        }
    }

    public static int findSameNum() {

        int cnt = 0;
        for(int row = 0; row < n; row ++) {
            for(int col = 0; col < n; col ++) {
                if(tmpGrid[row][col] == 0) continue;
                int target = tmpGrid[row][col];
                for(int d = 0; d < B_LEN; d ++) {
                    int nx = row + dx[d];
                    int ny = col + dy[d];
                    if(canGo(nx, ny) && target == tmpGrid[nx][ny]) cnt ++;
                }
                tmpGrid[row][col] = 0;
            }
        }
        return cnt;
    }

    public static void resetTmp() {
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j ++) {
                tmpGrid[i][j] = grid[i][j];
            }
        }
    }

    public static void simulation() {
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j ++) {
                resetTmp();
                bomb(i, j);
                drop();
                cnt = Math.max(cnt, findSameNum());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i ++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j ++) {
                int num = Integer.parseInt(stk.nextToken());
                grid[i][j] = num;
            }
        }

        simulation();

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
}