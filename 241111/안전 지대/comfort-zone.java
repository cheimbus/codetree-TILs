import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static final int MAX_N = 50;
    public static int n, m, maxCnt = 0, currK = 1;
    public static int[][] grid = new int[MAX_N + 1][MAX_N + 1];
    public static boolean[][] visited = new boolean[MAX_N + 1][MAX_N + 1];
    public static int[] dx = new int[]{1, 0, -1, 0};
    public static int[] dy = new int[]{0, -1, 0, 1};

    public static boolean inRange(int x, int y) {
        return 1 <= x && 1 <= y && x <= n && y <= m;
    }

    public static void DFS(int x, int y) {
        for(int i = 0; i < 4; i ++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(inRange(nx, ny) && !visited[nx][ny]) {
                visited[nx][ny] = true;
                DFS(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        int maxVal = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i ++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j ++) {
                int num = Integer.parseInt(stk.nextToken());
                grid[i][j] = num;
                if(maxVal < num) maxVal = num;
            }
        }

        for(int k = 1; k <= maxVal; k ++) {
            for(int i = 1; i <= n; i ++)
                for(int j = 1; j <= m; j ++) {
                    visited[i][j] = false;
                }

            for(int i = 1; i <= n; i ++)
                for(int j = 1; j <= m; j ++) {
                    if(grid[i][j] <= k) visited[i][j] = true;
                }

            int currCnt = 0;
            for(int i = 1; i <= n; i ++)
                for(int j = 1; j <= m; j ++) {
                    if(!visited[i][j]) {
                        visited[i][j] = true;
                        DFS(i, j);
                        currCnt ++;
                    }
                }
            if(maxCnt < currCnt) {
                maxCnt = currCnt;
                currK = k;
            }
        }

        bw.write(currK + " " + maxCnt);
        bw.flush();
        bw.close();
        br.close();
    }
}