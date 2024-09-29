import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static final int MAX_VAL = 100;
    public static final int CW = 1;
    public static final int CCW = 0;
    public static final int D_LEN = 4;
    public static int[] DArr;
    public static int[] dx;
    public static int[] dy;
    public static int n;
    public static int[][] grid = new int[MAX_VAL + 1][MAX_VAL + 1];
    public static int[][] movedGrid = new int[MAX_VAL + 1][MAX_VAL + 1];

    public static void simulation(int row, int col, int l, int k, int dir) {
        if(dir == CW) {
            dx = new int[]{-1, -1, 1, 1};
            dy = new int[]{-1, 1, 1, -1};
            DArr = new int[]{k, l, k, l};
        }
        else if(dir == CCW){
            dx = new int[]{-1, -1, 1, 1};
            dy = new int[]{1, -1, -1, 1};
            DArr = new int[]{l, k, l, k};
        }

        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= n; j ++) {
                movedGrid[i][j] = grid[i][j];
            }
        }

        for(int d = 0; d < D_LEN; d ++) {
            for(int i = 0; i < DArr[d]; i ++) {
                int nx = row + dx[d];
                int ny = col + dy[d];
                movedGrid[nx][ny] = grid[row][col];
                row = nx;
                col = ny;
            }
        }

        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= n; j ++) {
                grid[i][j] = movedGrid[i][j];
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());

        for(int row = 1; row <= n; row ++) {
            stk = new StringTokenizer(br.readLine());
            for(int col = 1; col <= n; col ++) {
                int num = Integer.parseInt(stk.nextToken());
                grid[row][col] = num;
            }
        }

        stk = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(stk.nextToken());
        int col = Integer.parseInt(stk.nextToken());
        int D1 = Integer.parseInt(stk.nextToken());
        int D2 = Integer.parseInt(stk.nextToken());
        int D3 = Integer.parseInt(stk.nextToken());
        int D4 = Integer.parseInt(stk.nextToken());
        int d = Integer.parseInt(stk.nextToken());

        simulation(row, col, D1, D2, d);

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