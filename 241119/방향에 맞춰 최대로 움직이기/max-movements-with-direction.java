import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static final int MAX_N = 4;
    public static int n, ans;
    public static int[][] grid = new int[MAX_N][MAX_N];
    public static int[][] dir = new int[MAX_N][MAX_N];
    public static int[] dx = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dy = new int[]{0, 1, 1, 1, 0, -1, -1, -1};

    public static boolean inRange(int x, int y) {
        return 0 <= x && 0 <= y && x < n && y < n;
    }

    public static boolean canGo(int x, int y, int val) {
        return inRange(x, y) && grid[x][y] > val;
    }

    public static void recursion(int currX, int currY, int currNum) {
        ans = Math.max(ans, currNum);

        int d = dir[currX][currY] - 1;
        for(int i = 0; i < n; i ++) {
            int nx = currX + dx[d] * i, ny = currY + dy[d] * i;
            if(canGo(nx, ny, grid[currX][currY])) {
                recursion(nx, ny, currNum + 1);
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
                grid[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        for(int i = 0; i < n; i ++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j ++) {
                dir[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(stk.nextToken());
        int y = Integer.parseInt(stk.nextToken());

        recursion(x - 1, y - 1, 0);

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}