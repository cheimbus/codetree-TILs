import java.io.*;
import java.util.*;

public class Main {
    public static int n, cnt;
    public static int[][] grid;
    public static int[][] dir;
    public static int[] dx = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dy = new int[]{0, 1, 1, 1, 0, -1, -1, -1};

    public static boolean inRange(int x, int y) {
        return 1 <= x && 1 <= y && x <= n && y <= n;
    }

    public static boolean possible(int x, int y, int val) {
        return inRange(x, y) && grid[x][y] > val;
    }

    public static void dfs(int depth, int x, int y) {
        cnt = Math.max(cnt, depth);

        int d = dir[x][y] - 1;
        for(int i = 1; i <= n; i ++) {
            int nx = x + dx[d] * i;
            int ny = y + dy[d] * i;
            if(possible(nx, ny, grid[x][y])) {
                dfs(depth + 1, nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        grid = new int[n + 1][n + 1];
        dir = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i ++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j ++) {
                grid[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        for(int i = 1; i <= n; i ++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j ++) {
                dir[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(stk.nextToken());
        int y = Integer.parseInt(stk.nextToken());
        dfs(0, x, y);

        bw.write(cnt + "");
        bw.flush();
    }
}