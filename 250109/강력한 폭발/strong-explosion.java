import java.io.*;
import java.util.*;

public class Main {
    public static int n, m, cnt;
    public static int[][] grid;
    public static int[][] tmp;
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static int[][] dx = new int[][]{{}, {-2, -1, 0, 1, 2}, {-1, 0, 0, 1, 0}, {-1, 1, 0, 1, -1}};
    public static int[][] dy = new int[][]{{}, {0, 0, 0, 0, 0}, {0, 1, 0, 0 ,-1}, {1, 1, 0, -1, -1}};

    public static boolean inRange(int x, int y) {
        return 1 <= x && 1 <= y && x <= n && y <= n;
    }

    public static void check(int x, int y, int pos) {
        for(int i = 0; i < 5; i ++) {
            int nx = x + dx[arr.get(pos)][i];
            int ny = y + dy[arr.get(pos)][i];
            if(inRange(nx, ny)) {
                tmp[nx][ny] = 1;
            }
        }
    }

    public static int calc() {
        int val = 0;
        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= n; j ++) {
                if(grid[i][j] == 1) {
                    check(i, j, val ++);
                }
            }
        }

        int ans = 0;
        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= n; j ++) {
                if(tmp[i][j] == 1) {
                    ans ++;
                    tmp[i][j] = 0;
                }
            }
        }
        return ans;
    }

    public static void dfs(int val) {
        if(val == m) {
            cnt = Math.max(cnt, calc());
            return;
        }

        for(int i = 1; i <= 3; i ++) {
            arr.add(i);
            dfs(val + 1);
            arr.remove(arr.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        grid = new int[n + 1][n + 1];
        tmp = new int[n + 1][n + 1];

        for(int i = 1; i <= n ; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n ; j ++) {
                grid[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        for(int i = 1; i <= n ; i++) {
            for(int j = 1; j <= n ; j ++) {
                if(grid[i][j] == 1) m ++;
            }
        }

        dfs(0);

        bw.write(cnt + "");
        bw.flush();
    }
}