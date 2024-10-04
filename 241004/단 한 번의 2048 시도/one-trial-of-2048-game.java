import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static final int N = 4;
    public static int[][] grid = new int[N][N];
    public static int ASCII_CODE = 91;
    public static int[] arrMapping = new int[ASCII_CODE];

    public static void rotate() {
        int[][] tmpGrid = new int[N][N];

        for(int col = 0; col < N; col ++) {
            for(int row = 0; row < N; row ++) {
                tmpGrid[col][row] = grid[N - 1 - row][col];
            }
        }

        for(int col = 0; col < N; col ++) {
            for(int row = 0; row < N; row ++) {
                grid[col][row] = tmpGrid[col][row];
            }
        }
    }

    public static void drop() {
        int[][] tmpGrid = new int[N][N];

        for(int col = 0; col < N; col ++) {
            for(int row1 = N - 1; row1 > 0; row1 --) {
                if(grid[row1][col] == 0) continue;

                int target = grid[row1][col];
                for(int row2 = row1 - 1; row2 >= 0; row2 --) {
                    if(grid[row2][col] == 0) continue;

                    else if(grid[row2][col] == target) {
                        grid[row1][col] = grid[row1][col] * 2;
                        grid[row2][col] = 0;
                        break;
                    }
                    else break;
                }
            }
        }

        for(int col = 0; col < N; col ++) {
            int cnt = N - 1;
            for(int row = N - 1; row >= 0; row --) {
                if(grid[row][col] != 0) tmpGrid[cnt--][col] = grid[row][col];
            }
        }

        for(int i = 0; i < N; i ++) {
            for(int j = 0; j < N; j ++) {
                grid[i][j] = tmpGrid[i][j];
            }
        }
    }

    public static void simulation(int dir) {
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

        char dir = br.readLine().charAt(0);
        arrMapping['D'] = 0;
        arrMapping['R'] = 1;
        arrMapping['U'] = 2;
        arrMapping['L'] = 3;

        simulation(arrMapping[dir]);

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