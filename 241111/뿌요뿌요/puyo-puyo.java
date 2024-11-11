import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static final int MAX_N = 100;
    public static final int LEN = 4;
    public static int n, currCnt, cnt = 0, k;
    public static int[][] grid = new int[MAX_N][MAX_N];
    public static boolean[][] visited = new boolean[MAX_N][MAX_N];
    public static int[] dx = new int[]{1, 0, -1, 0};
    public static int[] dy = new int[]{0, -1, 0, 1};

    public static boolean inRange(int x, int y) {
        return 0 <= x && 0 <= y && x < n && y < n;
    }

    public static void DFS(int x, int y, int num) {
        for(int i = 0; i < LEN; i ++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(inRange(nx, ny) && !visited[nx][ny] && num == grid[nx][ny]) {
                currCnt ++;
                visited[nx][ny] = true;
                DFS(nx, ny, num);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i ++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j ++) {
                int num = Integer.parseInt(stk.nextToken());
                grid[i][j] = num;
            }
        }

        for(int i = 0; i < n; i ++)
            for(int j = 0; j < n; j ++) {
                int currN = grid[i][j];
                visited[i][j] = true;
                currCnt = 1;
                DFS(i, j, currN);
                if(cnt < currCnt) {
                    cnt = currCnt;
                }
                if(4 <= currCnt) k ++;
            }

        bw.write(k + " " + cnt);
        bw.flush();
        bw.close();
        br.close();
    }
}