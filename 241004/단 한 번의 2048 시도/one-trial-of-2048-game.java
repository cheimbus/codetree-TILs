import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static final int N = 4;
    public static final int ASCII_CODE = 91;
    public static int [] dirMapper = new int[ASCII_CODE];
    public static int[][] grid = new int[N][N];

    public static void rotate() {
        int[][] tmpGrid = new int[N][N];

        for(int i = 0; i < N; i ++) {
            for(int j = 0; j < N; j ++) {
                tmpGrid[i][j] = grid[N - j - 1][i];
            }
        }

        for(int i = 0; i < N; i ++) {
            for(int j = 0; j < N; j ++) {
                grid[i][j] = tmpGrid[i][j];
            }
        }
    }

    public static void sumGrid(int row, int col) {
        grid[row][col] = grid[row][col] + grid[row - 1][col];
        grid[row - 1][col] = 0;
    }

    public static void drop() {
        int[][] tmpGrid = new int[N][N];

        for(int col = 0; col < N; col ++) {
            for(int row = N - 1; row > 1; row --) {
                if(grid[row][col] == grid[row - 1][col]) sumGrid(row, col);
            }
        }

        int tmpCnt;
        for(int col = 0; col < N; col ++) {
            tmpCnt = N - 1;
            for(int row = N - 1; row >= 0; row --) {
                if(grid[row][col] != 0) {
                    tmpGrid[tmpCnt][col] = grid[row][col];
                    tmpCnt --;
                }
            }
        }

        for(int row = 0; row < N; row ++) {
            for(int col = 0; col < N; col ++) {
                grid[row][col] = tmpGrid[row][col];
            }
        }
    }

    public static void tilt(int dir) {

        for(int i = 0; i < dir; i ++) {
            rotate();
        }
        drop();
        for(int i = 0; i < 4 - dir; i ++) {
            rotate();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i < N; i ++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j ++) {
                int num = Integer.parseInt(stk.nextToken());
                grid[i][j] = num;
            }
        }

        char curDir = br.readLine().charAt(0);
        dirMapper['D'] = 0;
        dirMapper['R'] = 1;
        dirMapper['U'] = 2;
        dirMapper['L'] = 3;

        tilt(dirMapper[curDir]);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i ++) {
            for(int j = 0; j < N; j ++) {
                sb.append(grid[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}