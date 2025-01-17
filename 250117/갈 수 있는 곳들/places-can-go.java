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
    public static int n, k, cnt;
    public static int[][] grid;
    public static boolean[][] visited;
    public static Queue<Pair> q = new LinkedList<>();
    public static int[] dx = new int[]{-1, 1, 0, 0};
    public static int[] dy = new int[]{0, 0, 1, -1};

    public static boolean inRange(int x, int y) {
        return 1 <= x && 1 <= y && x <= n && y <= n && !visited[x][y] && grid[x][y] != 1;
    }

    public static void bfs() {
        while(!q.isEmpty()) {
            Pair val = q.poll();
            int x = val.x;
            int y = val.y;
            for(int i = 0; i < 4; i ++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(inRange(nx, ny)) {
                    visited[nx][ny] = true;
                    q.add(new Pair(nx, ny));
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
        grid = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];

        for(int i = 1; i <= n; i ++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j ++) {
                grid[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        while(k -- > 0) {
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            q.add(new Pair(x, y));
            bfs();
        }

        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= n; j ++) {
                if(visited[i][j]) cnt ++;
            }
        }

        bw.write(cnt + "");
        bw.flush();
    }
}