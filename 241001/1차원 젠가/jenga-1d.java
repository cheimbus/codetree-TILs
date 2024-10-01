import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static final int MAX_VAL = 100;
    public static int N;
    public static int[] grid = new int[MAX_VAL + 1];
    public static int[] copyGrid = new int[MAX_VAL + 1];

    public static void init() {
        for(int i = 1; i <= N; i ++) {
            copyGrid[i] = 0;
        }
    }

    public static void jenga(int x, int y) {
        for(int i = x; i <= y; i ++) {
            grid[i] = 0;
        }

        int copyCnt = 1;
        for(int i = 1; i <= N; i ++) {
            if(grid[i] != 0) {
                copyGrid[copyCnt] = grid[i];
                copyCnt ++;
            }
        }

        for(int i = 1; i <= N; i ++) {
            grid[i] = copyGrid[i];
        }

        init();
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i ++) {
            int num = Integer.parseInt(br.readLine());
            grid[i] = num;
        }

        for(int i = 0; i < 2; i ++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());

            jenga(x, y);
        }

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int i = 1; i <= N; i ++) {
            int num = grid[i];
            if(num != 0) {
                cnt ++;
            }
        }

        sb.append(cnt).append("\n");

        for(int i = 1; i <= N; i ++) {
            int num = grid[i];
            if(num != 0) {
                sb.append(num).append("\n");
            }
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}