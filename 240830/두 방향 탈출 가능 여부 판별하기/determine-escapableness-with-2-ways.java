import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
public class Main {
    public static int N,M;
    public static int[][] grid;
    public static int[][] visited;
    public static int dx[] = new int[]{1, 0};
    public static int dy[] = new int[]{0, 1};
    public static int[][] answer;

    public static boolean canGo(int x, int y) {
        if(x < 0 || x >= N || y < 0 || y >= M) {
            return false;
        }
        if(grid[x][y] == 0 || visited[x][y] == 1) {
            return false;
        }
        return true;
    }

    public static void DFS(int x, int y) {
        int setX = 0;
        int setY = 0;
        for(int i = 0; i < dx.length; i++) {
            setX = x + dx[i];
            setY = y + dy[i];
            if(canGo(setX, setY)) {
                visited[setX][setY] = 1;
                answer[setX][setY] = 1;
                DFS(setX, setY);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        grid = new int[N][M];
        visited = new int[N][M];
        answer = new int[N][M];
        
        for(int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int next = Integer.parseInt(stk.nextToken());
                grid[i][j] = next;
            }
        }

        visited[0][0] = 1;
        answer[0][0] = 1;
        DFS(0, 0);
        
        if(answer[N-1][M-1] != 1) System.out.print(0);
        else System.out.print(1);
    }
}