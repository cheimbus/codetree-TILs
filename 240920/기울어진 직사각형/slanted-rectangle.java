import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static final int MAX_VAL = 20;
    public static final int DIRECTION_LEN = 4;
    public static int n;
    public static int[][] grid = new int[MAX_VAL][MAX_VAL];
    public static int[] dx = new int[]{-1, -1, 1, 1};
    public static int[] dy = new int[]{1, -1, -1, 1};

    public static boolean canGo(int x, int y) {
        return 0 <= x && 0 <= y && x < n && y < n;
    }

    public static int findMaxVal(int x, int y, int k, int l) {
        int maxVal = 0;
        int[] moveNum = new int[]{k, l, k, l};
        int nx = x;
        int ny = y;

        for(int i = 0; i < DIRECTION_LEN; i++) {
            for(int j = 0; j < moveNum[i]; j++) {
                nx += dx[i];
                ny += dy[i];
                if(!canGo(nx, ny)) {
                    return 0;
                }
                maxVal += grid[nx][ny];
            }
        }
        return maxVal;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());

        for(int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int maxVal = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 1; k < n; k++) {
                    for(int l = 0; l < n; l++) {
                        maxVal = Math.max(maxVal, findMaxVal(i, j, k, l));
                    }
                }
            }
        }

        System.out.print(maxVal);
    }
}