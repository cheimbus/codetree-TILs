import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
public class Main {

    static class Pair {
        int x,y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int n;
    public static ArrayList<Integer>[] grid;
    public static ArrayList<Pair> bombPos = new ArrayList<>();
    public static int ans;
    public static int MAX_NUM = 20;
    public static int[][] bombType = new int[MAX_NUM][MAX_NUM];
    public static boolean[][] bombArea = new boolean[MAX_NUM][MAX_NUM];
    public static Pair[][] bombShape = {
        {},
        {new Pair(-2, 0), new Pair(-1, 0), new Pair(0, 0), new Pair(1, 0), new Pair(2, 0)},
        {new Pair(-1, 0), new Pair(1, 0), new Pair(0, 0), new Pair(0, -1), new Pair(0, 1)},
        {new Pair(-1, -1), new Pair(-1, 1), new Pair(0, 0), new Pair(1, -1), new Pair(1, 1)}
    };

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void bombed(int x, int y, int bType) {
        for(int i = 0; i < 5; i++) {
            int dx = bombShape[bType][i].x;
            int dy = bombShape[bType][i].y;
            int nx = x + dx;
            int ny = y + dy;
            if(inRange(nx, ny)) {
                bombArea[nx][ny] = true;
            }
        }
    }

    public static int calc() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(bombType[i][j] > 0) {
                    bombed(i, j, bombType[i][j]);
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(bombArea[i][j]) {
                    cnt++;
                    bombArea[i][j] = false;
                }
            }
        }
        return cnt;
    }

    public static void findBombArea(int cnt) {
        if(cnt == bombPos.size()) {
            ans = Math.max(ans, calc());
            return;
        }

        for(int i = 1; i <= 3; i++) {
            int x = bombPos.get(cnt).x;
            int y = bombPos.get(cnt).y;
            bombType[x][y] = i;
            findBombArea(cnt + 1);
            bombType[x][y] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());

        grid = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            grid[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int num = Integer.parseInt(stk.nextToken());
                grid[i].add(num);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i].get(j) > 0) {
                    bombPos.add(new Pair(i, j));
                }
            }
        }

        findBombArea(0);

        System.out.print(ans);
    }
}