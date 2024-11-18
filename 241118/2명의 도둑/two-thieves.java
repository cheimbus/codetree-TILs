import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static final int MAX_N = 10;
    public static int n, m, c, ans, maxVal;
    public static int[][] grid = new int[MAX_N][MAX_N];
    public static int[] arr = new int[MAX_N];

    public static void findMaxVal(int currNum, int currW, int currVal) {
        if(currNum == m) {
            if(currW <= c) {
                maxVal = Math.max(maxVal, currVal);
            }
            return;
        }

        findMaxVal(currNum + 1, currW, currVal);
        findMaxVal(currNum + 1, currW + arr[currNum],
                currVal + arr[currNum] * arr[currNum]);
    }

    public static int findMax(int x, int y) {
        for(int i = y; i < n; i ++) {
            arr[i - y] = grid[x][i];
        }

        maxVal = 0;
        findMaxVal(0, 0, 0);

        return maxVal;
    }

    public static boolean possible(int x1, int y1, int x2, int y2) {
        if(y1 + m - 1 >= n || y2 + m - 1 >= n) return false;

        if(x1 != x2) return true;

        int ny1 = y1 + m - 1;
        int ny2 = y2 + m - 1;

        if(ny1 > y2 || ny2 > y1) return false;

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        c = Integer.parseInt(stk.nextToken());

        for(int i = 0; i < n; i ++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j ++) {
                int num = Integer.parseInt(stk.nextToken());
                grid[i][j] = num;
            }
        }

        for(int sx1 = 0; sx1 < n; sx1 ++)
            for(int sy1 = 0; sy1 < n; sy1 ++)
                for(int sx2 = 0; sx2 < n; sx2 ++)
                    for(int sy2 = 0; sy2 < n; sy2 ++) {
                        if(possible(sx1, sy1, sx2, sy2)) {
                            ans = Math.max(ans, findMax(sx1, sy1) + findMax(sx2, sy2));
                        }
                    }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}