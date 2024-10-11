import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Target {
    int x; int y;
    public Target(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static final int MAX_N = 20;
    public static final int LEN = 8;
    public static int n, m;
    public static int[][] grid = new int[MAX_N][MAX_N];
    public static int[] dx = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dy = new int[]{0, 1, 1, 1, 0, -1, -1, -1};

    public static Target getTarget(int val) {
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j ++) {
                if(grid[i][j] == val) {
                    return new Target(i, j);
                }
            }
        }
        return new Target(0, 0);
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && 0 <= y && x < n && y < n;
    }

    public static void swap(Target target) {
        int maxVal = -1;
        int currVal = grid[target.x][target.y];
        Target nTarget = new Target(0,0);
        for(int i = 0; i < LEN; i++) {
            int nx = target.x + dx[i];
            int ny = target.y + dy[i];
            if(inRange(nx, ny) && maxVal < grid[nx][ny]) {
                maxVal = grid[nx][ny];
                nTarget = new Target(nx, ny);
            }
        }
        grid[target.x][target.y] = maxVal;
        grid[nTarget.x][nTarget.y] = currVal;
    }

    public static void solution() {
        for(int i = 1; i <= n * n; i ++) {
            Target target = getTarget(i);
            swap(target);
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
            for(int j = 0; j < n ; j ++) {
                int num = Integer.parseInt(stk.nextToken());
                grid[i][j] = num;
            }
        }

        while(m -- > 0) {
            solution();
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n ; j ++) {
                sb.append(grid[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}