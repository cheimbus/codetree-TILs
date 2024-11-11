import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int x; int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static final int MAX_N = 100;
    public static final int MAX_M = 100;
    public static final int LEN = 4;
    public static int n, m;
    public static int[][] grid = new int[MAX_N + 1][MAX_M + 1];
    public static boolean[][] visited = new boolean[MAX_N + 1][MAX_M + 1];
    public static Queue<Pair> q = new LinkedList<>();
    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static void push(int x, int y) {
        visited[x][y] = true;
        q.add(new Pair(x, y));
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && 0 <= y && x < n && y < n;
    }

    public static void BFS() {
        while(!q.isEmpty()) {
            Pair curr = q.poll();
            int x = curr.x;
            int y = curr.y;
            for(int i = 0; i < LEN; i ++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(inRange(nx, ny) && !visited[nx][ny] && grid[nx][ny] == 1) {
                    push(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        for(int i = 0; i < n; i ++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j ++) {
                int num = Integer.parseInt(stk.nextToken());
                grid[i][j] = num;
            }
        }

        push(0, 0);
        BFS();

        int ans = visited[n - 1][m - 1] ? 1 : 0;
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}