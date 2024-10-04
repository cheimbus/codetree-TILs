import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static final int MAX_N = 200;
    public static final int LEN = 4;
    public static int n, m;
    public static int[][] grid = new int[MAX_N + 1][MAX_N + 1];
    public static int[] dx = new int[]{1, 0, -1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static boolean canGo(int x, int y) {
        return x >= 1 && y >= 1 && n >= x && n >= y;
    }

    public static void bomb(int col) {

        int bombRange = 1;
        int row = 1;
        for(int i = 1; i <= n; i ++) {
            if(grid[i][col] != 0) {
                bombRange = grid[i][col];
                row = i;
                break;
            }
        }

        grid[row][col] = 0;
        if(bombRange > 1) {
            for(int i = 0; i < LEN; i ++) {
                int nx = row;
                int ny = col;
                for(int j = 1; j < bombRange; j ++) {
                    nx += dx[i];
                    ny += dy[i];

                    if(canGo(nx, ny)) {
                        grid[nx][ny] = 0;
                    }
                }
            }
        }
    }

    public static void drop() {
        int[][] tmpGrid = new int[MAX_N + 1][MAX_N + 1];

        for(int col = 1; col <= n; col ++) {
            int cnt = n;
            for(int row = n; row >= 1; row --) {
                if(grid[row][col] != 0) tmpGrid[cnt --][col] = grid[row][col];
            }
        }

        for(int row = 1; row <= n; row ++) {
            for(int col = 1; col <= n; col ++) {
                grid[row][col] = tmpGrid[row][col];
            }
        }
    }

    public static void simulation(int col) {
        bomb(col);

        drop();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        for(int i = 1; i <= n; i ++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j ++) {
                int num = Integer.parseInt(stk.nextToken());
                grid[i][j] = num;
            }
        }

        for(int i = 0; i < m; i ++) {
            int col = Integer.parseInt(br.readLine());
            simulation(col);
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= n; j ++) {
                sb.append(grid[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}