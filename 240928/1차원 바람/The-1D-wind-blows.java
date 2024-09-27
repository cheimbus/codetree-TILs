import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static final int MAX_VAL = 100;
    public static final int LEFT_SHIFT = 1;
    public static final int RIGHT_SHIFT = 0;
    public static int n,m;
    public static int[][] grid = new int[MAX_VAL + 1][MAX_VAL + 1];

    public static void shift(int row, int dir) {
        if(dir == RIGHT_SHIFT) {
            int tmp = grid[row][m];
            for(int col = m; col >= 2; col --) {
                grid[row][col] = grid[row][col - 1];
            }
            grid[row][1] = tmp;
        }
        else {
            int tmp = grid[row][1];
            for(int col = 1; col <= m - 1; col ++) {
                grid[row][col] = grid[row][col + 1];
            }
            grid[row][m] = tmp;
        }
    }

    public static int flip(int dir) {
        return dir == LEFT_SHIFT ? RIGHT_SHIFT : LEFT_SHIFT;
    }

    public static boolean hasSameNum(int row1, int row2) {
        for(int col = 1; col <= m; col ++) {
            if(grid[row1][col] == grid[row2][col]) return true;
        }
        return false;
    }

    public static void simulation(int curRow, int curDir) {

        shift(curRow, curDir);
        curDir = flip(curDir);

        //위
        for(int row = curRow, dir = curDir; row >= 2; row --) {
            if(hasSameNum(row, row - 1)) {
                shift(row - 1, dir);
                dir = flip(dir);
            }
            else break;
        }
        //아래
        for(int row = curRow, dir = curDir; row <= n - 1; row ++) {
            if(hasSameNum(row, row + 1)) {
                shift(row + 1, dir);
                dir = flip(dir);
            }
            else break;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        int q = Integer.parseInt(stk.nextToken());

        for(int row = 1; row <= n; row ++) {
            stk = new StringTokenizer(br.readLine());
            for(int col = 1; col <= m; col ++) {
                grid[row][col] = Integer.parseInt(stk.nextToken());
            }
        }

        for(int i = 0; i < q; i ++) {
            stk = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(stk.nextToken());
            char sd = stk.nextToken().charAt(0);
            int d = sd == 'L' ? RIGHT_SHIFT : LEFT_SHIFT;
            simulation(row, d);
        }

        StringBuilder sb = new StringBuilder();
        for(int row = 1; row <= n; row ++) {
            for(int col = 1; col <= m; col ++) {
                sb.append(grid[row][col]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}