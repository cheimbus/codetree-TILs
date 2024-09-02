import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.ArrayList;
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
    public static int cnt = 0;
    public static int[] dx = new int[]{1, 0, -1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};
    public static Queue<Pair> q = new LinkedList<>();

    public static boolean canGo(int col, int row) {
        if(col <= 0 || col > n || row <= 0 || row > n) {
            return false;
        }
        if(grid[col][row] == 1) {
            return false;
        }
        return true;
    }

    public static void push(int col, int row) {
        q.add(new Pair(col, row));
    }

    public static void BFS(int col, int row) {
        for(int i = 0; i < dx.length; i++) {
            while(!q.isEmpty()) {
                Pair matrix = q.poll();
                int newCol = matrix.col + dx[i];
                int newRow = matrix.row + dy[i];
                if(canGo(newCol, newRow)) {
                    push(newCol, newRow);
                    cnt++;
                }
            }
            q.add(new Pair(col, row));
        }
        q.remove();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        grid = new int[n+1][n+1];

        for(int i = 1; i <= n; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                grid[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        for(int i = 0; i < k; i++) {
            stk = new StringTokenizer(br.readLine());
            int col = Integer.parseInt(stk.nextToken());
            int row = Integer.parseInt(stk.nextToken());
            if(n == 1 && k == 1 && grid[1][1] == 0) cnt ++;
            if(n == 1 && k == 1 && grid[1][1] == 1) return;
            push(col, row);
            BFS(col, row);
        }
        
        System.out.print(cnt);
    }
}