import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static final int MAX_N = 20;
    public static final int LEN = 4;
    public static int n, m, t, cnt;
    public static int[][] grid = new int[MAX_N + 1][MAX_N + 1];
    public static int[] dx = new int[]{-1, 1, 0, 0};
    public static int[] dy = new int[]{0, 0, -1, 1};
    public static int[][] beads;

    public static boolean inRange(int x, int y) {
        return 1 <= x && 1 <= y && x <= n && y <= n;
    }

    public static void move() {
        for(int i = 0; i < m; i ++) {
            int x = beads[i][0];
            int y = beads[i][1];
            int maxVal = 0;
            int maxX = 0;
            int maxY = 0;
            for(int j = 0; j < LEN; j ++) {
                int nx = x + dx[j];
                int ny = y + dy[j];
                if(inRange(nx, ny) && maxVal < grid[nx][ny]) {
                    maxVal = grid[nx][ny];
                    maxX = nx; maxY = ny;
                }
            }
            beads[i][0] = maxX;
            beads[i][1] = maxY;
        }
    }

    public static void count() {
        int[][] cntGrid = new int[MAX_N + 1][MAX_N + 1];
        for(int i = 0; i < m; i ++) {
            int x = beads[i][0];
            int y = beads[i][1];
            cntGrid[x][y] += 1;
        }

        int tmpCnt = 0;

        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= n; j ++) {
                if(cntGrid[i][j] == 1) tmpCnt ++;
            }
        }

        cnt = tmpCnt;
    }

    public static void simulation() {
        move();
        count();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        t = Integer.parseInt(stk.nextToken());

        for(int i = 1; i <= n; i ++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j ++) {
                int num = Integer.parseInt(stk.nextToken());
                grid[i][j] = num;
            }
        }

        beads = new int[m][2];

        for(int i = 0; i < m; i ++) {
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            beads[i][0] = x;
            beads[i][1] = y;
        }

        while(t --> 0) {
            simulation();
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}