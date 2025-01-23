import java.io.*;
import java.util.*;

class Pair {
    int x;
    int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int n, k, m, ans;
    public static int[][] grid;
    public static boolean[][] visited;
    public static ArrayList<Pair> arr = new ArrayList<>();
    public static Queue<Pair> q = new LinkedList<>();
    public static int x, y;
    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};
    public static boolean[][] tmp;
    public static boolean[][] bfsVisited;

    public static boolean inRange(int x, int y) {
        return 1 <= x && 1 <= y && x <= n && y <= n;
    }

    public static int calc() {
        int val = 0;

        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= n; j ++) {
                if(tmp[i][j]) val ++;
            }
        }

        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= n; j ++) {
                tmp[i][j] = false;
            }
        }

        return val;
    }

    public static boolean possible(int x, int y) {
        return grid[x][y] != 1 || visited[x][y];
    }

    public static void bfs() {
        while(!q.isEmpty()) {
            Pair p = q.poll();
            int ax = p.x;
            int ay = p.y;
            for(int i = 0; i < 4; i ++) {
                int nx = ax + dx[i];
                int ny = ay + dy[i];
                if(inRange(nx, ny) && !bfsVisited[nx][ny]) {
                    if(possible(nx, ny)) {
                        q.add(new Pair(nx, ny));
                        tmp[nx][ny] = true;
                        bfsVisited[nx][ny] = true;
                    }
                }
            }
        }
    }

    public static void dfs(int depth) {
        if(depth == m) {
            q.add(new Pair(x, y));
            bfs();
            ans = Math.max(ans, calc());
            bfsVisited = new boolean[n + 1][n + 1];
            return;
        }

        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= n; j ++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    visited[i][j] = true;
                    dfs(depth + 1);
                    visited[i][j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        grid = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];
        tmp = new boolean[n + 1][n + 1];
        bfsVisited = new boolean[n + 1][n + 1];

        for(int i = 1; i <= n; i ++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j ++) {
                grid[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        while(k -- > 0) {
            stk = new StringTokenizer(br.readLine());
            x = Integer.parseInt(stk.nextToken());
            y = Integer.parseInt(stk.nextToken());
            dfs(0);
        }

        bw.write(ans + "");
        bw.flush();
    }
}