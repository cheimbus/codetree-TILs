import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
public class Main {

    static class Pair {
        int x,y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int N,M;
    public static int[][] grid;
    public static Queue<Pair> q = new LinkedList<>();
    public static boolean[][] visited;
    public static int[] dx = new int[]{1, 0, -1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static boolean canGo(int x, int y) {
        if(x < 0 || x >= N || y < 0 || y >= M) {
            return false;
        }
        if(visited[x][y] || grid[x][y] == 0) {
            return false;
        }
        return true;
    }

    public static void push(int x, int y) {
        visited[x][y] = true;
        q.add(new Pair(x, y));
    }

    public static void BFS() {
        while(!q.isEmpty()) {
            Pair curr = q.poll();
            int x = curr.x;
            int y = curr.y;
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

        grid = new int[N][M];

        for(int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        visited = new boolean[N][M];

        push(0, 0);
        BFS();
        
        int answer = visited[N-1][M-1] ? 1 : 0;
        System.out.print(answer);
    }
}