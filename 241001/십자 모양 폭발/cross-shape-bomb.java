import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static final int MAX_VAL = 200;
    public static final int LEN = 5;
    public static int N;
    public static int[][] grid = new int[MAX_VAL + 1][MAX_VAL + 1];
    public static int[][] tmpGrid = new int[MAX_VAL + 1][MAX_VAL + 1];
    public static int[] dx = new int[]{0, 1, 0, -1, 0};
    public static int[] dy = new int[]{0, 0, 1, 0, -1};

    public static boolean isRange(int x, int y) {
        return x >= 1 && y >= 1 && N >= x && N >= y;
    }

    public static void setGrid() {
        for(int i = 1; i <= N; i ++) {
            for(int j = 1; j <= N; j ++) {
                grid[i][j] = tmpGrid[i][j];
            }
        }
    }

    public static void setTmpGrid() {
        for(int i = 1; i <= N; i ++) {
            int pos = N;
            for(int j = N; j >= 1; j --) {
                if(grid[j][i] != 0) {
                    tmpGrid[pos][i] = grid[j][i];
                    pos --;
                }
            }
        }
    }

    public static void bomb(int x, int y) {
        int bombedRange = grid[x][y];

        for(int i = 0; i < LEN; i ++) {
            int nx = x;
            int ny = y;
            for(int j = 0; j < bombedRange - 1; j ++) {
                nx += dx[i];
                ny += dy[i];
                if(isRange(nx, ny)) {
                    grid[nx][ny] = 0;
                }
            }
        }
        setTmpGrid();
        setGrid();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());

        for(int i = 1; i <= N; i ++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j ++) {
                int num = Integer.parseInt(stk.nextToken());
                grid[i][j] = num;
            }
        }

        stk = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(stk.nextToken());
        int y = Integer.parseInt(stk.nextToken());

        bomb(x, y);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i ++) {
            for(int j = 1; j <= N; j ++) {
                sb.append(grid[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}