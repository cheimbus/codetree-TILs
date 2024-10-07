import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static final int MAX_N = 100;
    public static int n, m, k, x, y;
    public static int[][] grid = new int[MAX_N + 1][MAX_N + 1];
    public static int dx = 1;

    public static boolean inRange(int row) {
        return row < n;
    }

    public static boolean canGo(int row, int col) {
        if(inRange(row) && grid[row + 1][col] == 0) return true;
        return false;
    }

    public static boolean simulation() {
        for(int i = k; i <= y; i ++) {
            if(canGo(x, i)) continue;
            else return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        for(int i = 1; i <= n; i ++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j ++) {
                int num = Integer.parseInt(stk.nextToken());
                grid[i][j] = num;
            }
        }

        x = 1; y = k + m - 1;

        while(true) {
            boolean isTouchBlock = simulation();
            if(!isTouchBlock) break;
            x += dx;
        }

        for(int i = k; i <= y; i ++) {
            grid[x][i] = 1;
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
        br.close();
    }
}