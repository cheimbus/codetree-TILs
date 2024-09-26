import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static final int MAX_VAL = 20;
    public static final int MIN_VAL = Integer.MIN_VALUE;
    public static int n, m;
    public static int[][] grid = new int[MAX_VAL][MAX_VAL];

    public static boolean isMinus(int x1, int y1) {
        return grid[x1][y1] <= 0;
    }

    public static boolean checkRect(int x1, int y1, int x2, int y2) {
        boolean isRight = true;

        for(int i = x1; i <= x2; i ++) {
            for(int j = y1; j <= y2; j ++) {
                if (isMinus(i, j)) {
                    return false;
                }
            }
        }
        return isRight;
    }

    public static int rectMaxLen(int x1, int y1, int x2, int y2) {
        int maxLen = 0;

        for(int i = x1; i <= x2; i ++) {
            for(int j = y1; j <= y2; j ++) {
                maxLen ++;
            }
        }

        return maxLen;
    }

    public static int findMaxVal() {
        int maxVal = 0;

        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j ++) {
                for(int k = i; k < n; k ++) {
                    for(int l = j; l < m; l ++) {
                        if(checkRect(i, j, k, l)) {
                            maxVal = Math.max(maxVal, rectMaxLen(i, j, k, l));
                        }
                    }
                }
            }
        }

        return maxVal;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        for(int i = 0; i < n; i ++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j ++) {
                int num = Integer.parseInt(stk.nextToken());
                grid[i][j] = num;
            }
        }

        int ans = findMaxVal();

        int res = ans == 0 ? -1 : ans;

        bw.write(res + "\n");

        bw.flush();
        bw.close();
    }
}