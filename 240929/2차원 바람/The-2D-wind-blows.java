import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static final int MAX_VAL = 100;
    public static final int D_LEN = 5;
    public static int n, m, q;
    public static int[][] grid = new int[MAX_VAL + 1][MAX_VAL + 1];
    public static int[][] avg = new int[MAX_VAL + 1][MAX_VAL + 1];
    public static int[] dx = new int[]{0, 1, 0, -1, 0};
    public static int[] dy = new int[]{0, 0, 1, 0, -1};

    public static boolean canGo(int row, int col) {
        return row >= 1 && col >= 1 && n >= row && m >= col;
    }

    public static int sumAvg(int row, int col) {
        int sum = 0;
        int cnt = 0;

        for(int i = 0; i < D_LEN; i ++) {
            int nx = row + dx[i];
            int ny = col + dy[i];
            if(canGo(nx, ny)) {
                sum += grid[nx][ny];
                cnt ++;
            }
        }

        return sum / cnt;
    }

    public static void setAvg(int row1, int col1, int row2, int col2) {
        for(int row = row1; row <= row2; row ++) {
            for(int col = col1; col <= col2; col ++) {
                avg[row][col] = sumAvg(row, col);
            }
        }

        for(int row = row1; row <= row2; row ++) {
            for(int col = col1; col <= col2; col ++) {
                grid[row][col] = avg[row][col];
            }
        }
    }

    public static void shift(int row1, int col1, int row2, int col2) {

        int tmp = grid[row1][col1];
        // up
        for(int row = row1; row <= row2 - 1; row ++) {
            grid[row][col1] = grid[row + 1][col1];
        }

        // left
        for(int col = col1; col <= col2 - 1; col ++) {
            grid[row2][col] = grid[row2][col + 1];
        }

        // down
        for(int row = row2; row >= row1 + 1; row --) {
            grid[row][col2] = grid[row - 1][col2];
        }

        // right
        for(int col = col2; col >= col1 + 1; col --) {
            grid[row1][col] = grid[row1][col - 1];
        }

        grid[row1][col1 + 1] = tmp;
    }

    public static void simulation(int row1, int col1, int row2, int col2) {
        shift(row1, col1, row2, col2);
        setAvg(row1, col1, row2, col2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        q = Integer.parseInt(stk.nextToken());

        for(int row = 1; row <= n; row ++) {
            stk = new StringTokenizer(br.readLine());
            for(int col = 1; col <= m; col ++) {
                int num = Integer.parseInt(stk.nextToken());
                grid[row][col] = num;
            }
        }

        while(q-- > 0) {
            stk = new StringTokenizer(br.readLine());
            int row1 = Integer.parseInt(stk.nextToken());
            int col1 = Integer.parseInt(stk.nextToken());
            int row2 = Integer.parseInt(stk.nextToken());
            int col2 = Integer.parseInt(stk.nextToken());

            simulation(row1, col1, row2, col2);
        }

        StringBuilder sb = new StringBuilder();
        for(int row = 1; row <= n; row ++) {
            for(int col = 1; col <= m; col ++) {
                sb.append(grid[row][col]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}