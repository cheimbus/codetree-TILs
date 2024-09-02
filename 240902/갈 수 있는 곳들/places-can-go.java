import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class Main {

    static class Pair {
        int col, row;

        public Pair(int col, int row) {
            this.col = col;
            this.row = row;
        }
    }

    public static int n, k;
    public static int[][] grid;
    public static boolean[][] visited;
    public static int cnt = 0;
    public static Queue<Pair> q = new LinkedList<>();
    public static int[] dx = new int[]{1, 0, -1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static void push(int col, int row) {
        visited[col][row] = true;
        q.add(new Pair(col, row));
    }

    public static boolean canGo(int col, int row) {
        if(col < 0 || col >= n || row < 0 || row >= n) {
            return false;
        }
        if(visited[col][row] || grid[col][row] == 1) {
            return false;
        }
        return true;
    }

    public static void BFS() {
        while(!q.isEmpty()) {
            Pair matrix = q.poll();
            for(int i = 0; i < dx.length; i++) {
                int col = matrix.col + dx[i];
                int row = matrix.row + dy[i];
                if(canGo(col, row)) {
                    push(col, row);
                    cnt++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        grid = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int vertax = Integer.parseInt(stk.nextToken());
                grid[i][j] = vertax;
            }
        }

        for(int i = 0; i < k; i++) {
            stk = new StringTokenizer(br.readLine());
            int col = Integer.parseInt(stk.nextToken());
            int row = Integer.parseInt(stk.nextToken());
            if(visited[col - 1][row - 1]) cnt++;
            push(col - 1, row - 1);
            BFS();
        }

        System.out.print(cnt);
    }
}