import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static final int MAX_N = 20;
    public static int n, ans;
    public static int[][] grid = new int[MAX_N][MAX_N];
    public static int[][] bombType = new int[MAX_N][MAX_N];
    public static boolean[][] bombed = new boolean[MAX_N][MAX_N];
    public static ArrayList<Pair> bombs = new ArrayList<>();
    public static Pair[][] bombShape = new Pair[][]{
            {},
            {new Pair(-2, 0), new Pair(-1, 0), new Pair(0, 0), new Pair(1, 0), new Pair(2, 0)},
            {new Pair(-1, 0), new Pair(0, 0), new Pair(0, 1), new Pair(0, -1), new Pair(1, 0)},
            {new Pair(-1, -1), new Pair(-1, 1), new Pair(0, 0), new Pair(1, -1), new Pair(1, 1)}
    };

    public static boolean inRange(int x, int y) {
        return 0 <= x && 0 <= y && x < n && y < n;
    }

    public static void bomb(int x, int y, int type) {
        for(int i = 0; i < 5; i ++) {
            Pair pos = bombShape[type][i];
            int nx = x + pos.x;
            int ny = y + pos.y;
            if(inRange(nx, ny)) {
                bombed[nx][ny] = true;
            }
        }
    }

    public static int calc() {
        for(int i = 0; i < n; i ++)
            for(int j = 0; j < n; j ++) {
                if(bombType[i][j] > 0) {
                    bomb(i, j, bombType[i][j]);
                }
            }

        int cnt = 0;
        for(int i = 0; i < n; i ++)
            for(int j = 0; j < n; j ++) {
                if(bombed[i][j]) {
                    cnt ++;
                    bombed[i][j] = false;
                }
            }

        return cnt;
    }

    public static void recursion(int currNum) {
        if(currNum == bombs.size()) {
            ans = Math.max(ans, calc());
            return;
        }

        for(int i = 1; i <= 3; i ++) {
            Pair pos = bombs.get(currNum);
            int x = pos.x;
            int y = pos.y;
            bombType[x][y] = i;
            recursion(currNum + 1);
            bombType[x][y] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i ++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j ++) {
                int num = Integer.parseInt(stk.nextToken());
                grid[i][j] = num;
            }
        }

        for(int i = 0; i < n; i ++)
            for(int j = 0; j < n; j ++) {
                if(grid[i][j] == 1) bombs.add(new Pair(i, j));
            }

        recursion(0);

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}