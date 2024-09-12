import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;
public class Main {
    static class Pair {
        int x, y, v;
        public Pair(int x, int y, int v) {
            this.x = x;
            this.y = y;
            this.v = v;
        }
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static final int DELTA_LEN = 4;
    public static int n, k, x1, y1, v1;
    public static ArrayList<Integer>[] grid;
    public static Queue<Pair> q = new LinkedList<>();
    public static int[] dx = new int[]{1, 0, -1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};
    public static boolean[][] visited;
    public static ArrayList<Pair> restore = new ArrayList<>();

    public static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }

    public static boolean canGo(int x, int y) {
        if(!inRange(x, y)) {
            return false;
        }
        if(visited[x][y] || grid[x].get(y) >= v1) {
            return false;
        }
        return true;
    }

    public static void remover() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }

        restore.clear();
    }

    public static void findMaxValue() {
        Collections.sort(restore, (a, b) -> {
            if(b.v != a.v) {
                return Integer.compare(b.v, a.v);
            }
            else if(b.x != a.x) {
                return Integer.compare(a.x, b.x);
            }
            else {
                return Integer.compare(a.y, b.y);
            }
        });

        Pair maxValue = restore.get(0);
        x1 = maxValue.x;
        y1 = maxValue.y;
        v1 = maxValue.v;
    }

    public static void BFS() {
        while(!q.isEmpty()) {
            Pair coordinate = q.poll();
            for(int i = 0; i < DELTA_LEN; i++) {
                int nx = coordinate.x + dx[i];
                int ny = coordinate.y + dy[i];
                if(canGo(nx, ny)) {
                    int nv = grid[nx].get(ny);
                    visited[nx][ny] = true;
                    q.add(new Pair(nx, ny));
                    restore.add(new Pair(nx, ny, nv));
                }
            }
        }
        findMaxValue();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        grid = new ArrayList[n];
        visited = new boolean[n][n];
        
        for(int i = 0; i < n; i++) {
            grid[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int num = Integer.parseInt(stk.nextToken());
                grid[i].add(num);
            }
        }

        stk = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(stk.nextToken()) -1;
        y1 = Integer.parseInt(stk.nextToken()) -1;
        v1 = grid[x1].get(y1);
        for(int i = 0; i < k; i++) {
            q.add(new Pair(x1, y1));
            visited[x1][y1] = true;
            BFS();
            remover();
        }

        StringBuilder sb = new StringBuilder();
        sb.append(x1 + 1).append(" ").append(y1 + 1);

        System.out.print(sb);
    }
}