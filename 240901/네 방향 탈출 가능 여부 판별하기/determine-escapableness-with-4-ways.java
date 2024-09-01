import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Queue;
public class Main {
    public static int N,M;
    public static int[][] grid;
    public static boolean[][] visited;
    public static Queue<Pair> q = new LinkedList<>();
    public static int[] dx = new int[]{1, 0};
    public static int[] dy = new int[]{0, 1};

     static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void push(int x, int y) {
        visited[x][y] = true;
        q.add(new Pair(x, y));
    }

    public static boolean canGo(int x, int y) {
        if(x < 0 || x >= N || y < 0 || y >= M) {
            return false;
        }
        if(visited[x][y] || grid[x][y] == 0) {
            return false;
        }
        else return true;
    }

    public static void BFS() {
        while(!q.isEmpty()) {
            Pair newVertax = q.poll();
            int x = newVertax.x;
            int y = newVertax.y;
            for(int i = 0; i < dx.length; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if(canGo(newX, newY)) {
                    push(newX, newY);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        visited = new boolean[N][M];
        grid = new int[N][M];

        for(int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int nextV = Integer.parseInt(stk.nextToken());
                grid[i][j] = nextV;
            }
        }

        push(0, 0);
        BFS();

        if(visited[N-1][M-1] != false) System.out.print(0);
        else System.out.print(1);
    }
}