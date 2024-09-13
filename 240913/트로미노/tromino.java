import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static int n, m, val;
    public static int[][] grid;
    public static int ans;
    public static int[][][] delta = new int[][][]{
        {{0, 0}, {1, 0}, {1, 1}},
        {{1, 0}, {0, 1}, {1, 1}},
        {{0, 0}, {1, 0}, {0, 1}},
        {{0, 0}, {0, 1}, {1, 1}},
        {{0, 0}, {0, 1}, {0, 2}},
        {{0, 0}, {1, 0}, {2, 0}}
    };

    public static boolean canGo(int x, int y) {
        return x >= 0 && y >= 0 && n > x && m > y;
    }

    public static void findMaxValue() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int k = 0; k < delta.length; k++) {
                    ans = Math.max(ans, val);
                    int canCnt = 0;
                    int addVal = 0;
                    for(int l = 0; l < 3; l++) {
                        int nx = i + delta[k][l][0];
                        int ny = j + delta[k][l][1];
                        if(canGo(nx, ny)) {
                            canCnt++;
                            addVal += grid[nx][ny];
                        } else {
                            break;
                        }
                        if(canCnt == 3) {
                            val = addVal;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        grid = new int[n][m];

        for(int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                int num = Integer.parseInt(stk.nextToken());
                grid[i][j] = num;
            }
        }

        findMaxValue();

        System.out.print(ans);
    }
}