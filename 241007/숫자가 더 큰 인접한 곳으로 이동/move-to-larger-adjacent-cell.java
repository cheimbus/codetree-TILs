import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static final int MAX_N = 100;
    public static int n, c, r, val;
    public static int[][] grid = new int[MAX_N + 1][MAX_N + 1];
    public static StringBuilder sb = new StringBuilder();
    public static int[] dx = new int[]{-1, 1, 0, 0};
    public static int[] dy = new int[]{0, 0, -1, 1};

    public static boolean inRange(int x, int y) {
        return x >= 1 && y >= 1 && n >= x && n >= y;
    }

    public static boolean canGo(int x, int y) {
        return inRange(x, y) && grid[x][y] > val;
    }

    public static boolean simulation() {
        for(int i = 0; i < 4; i ++) {
            int nx = r + dx[i];
            int ny = c + dy[i];
            if(canGo(nx, ny)) {
                r = nx; c = ny;
                val = grid[r][c];
                sb.append(val).append(" ");
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        r = Integer.parseInt(stk.nextToken());
        c= Integer.parseInt(stk.nextToken());

        for(int i = 1; i <= n; i ++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j ++) {
                int num = Integer.parseInt(stk.nextToken());
                grid[i][j] = num;
            }
        }

        val = grid[r][c];
        sb.append(val).append(" ");

        while(true) {
            boolean greaterNumExist = simulation();
            if(!greaterNumExist) break;
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}