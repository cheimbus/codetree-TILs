import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

class Tuple implements Comparable<Tuple> {
    int x, y, z;

    public Tuple(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public int compareTo(Tuple b) {
        if(x != b.x) return b.x - x;
        if(y != b.y) return b.y - y;
        return b.z - z;
    }
}

class Next {
    int x, y, z;
    public Next(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Main {
    public static final int MAX_N = 50;
    public static int n, m, t, k, cnt;
    public static int[] ASCII_CODE = new int[128];
    public static ArrayList<Tuple>[][] grid = new ArrayList[MAX_N + 1][MAX_N + 1];
    public static ArrayList<Tuple>[][] tmpGrid = new ArrayList[MAX_N + 1][MAX_N + 1];
    public static int[] dx = new int[]{-1, 0, 0, 1};
    public static int[] dy = new int[]{0, 1, -1, 0};

    public static boolean inRange(int x, int y) {
        return 1 <= x && 1 <= y && x <= n && y <= n;
    }

    public static Next move(int x, int y, int v, int dir) {
        while(v -- > 0) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(!inRange(nx, ny)) {
                dir = 3 - dir;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            x = nx;
            y = ny;
        }
        return new Next(x, y, dir);
    }

    public static void moveAll() {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j ++) {
                for(int l = 0; l < grid[i][j].size(); l ++) {
                    Tuple marble = grid[i][j].get(l);
                    int v = marble.x, idx = marble.y, dir = marble.z;
                    Next moved = move(i, j, v, dir);
                    int nx = moved.x, ny = moved.y, ndir = moved.z;
                    tmpGrid[nx][ny].add(new Tuple(v, idx, ndir));
                }
            }
        }
    }

    public static void removeDuplicated() {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j ++) {
                if(tmpGrid[i][j].size() > k) {
                    Collections.sort(tmpGrid[i][j]);
                    while(tmpGrid[i][j].size() > k) {
                        tmpGrid[i][j].remove(tmpGrid[i][j].size() -1);
                    }
                }
            }
        }
    }

    public static void simulate() {
        for(int i = 1; i <= n; i ++)
            for(int j = 1; j <= n; j ++)
                tmpGrid[i][j] = new ArrayList<>();

        moveAll();
        removeDuplicated();

        for(int i = 1; i <= n; i ++)
            for(int j = 1; j <= n; j ++)
                grid[i][j] = tmpGrid[i][j];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        t = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        ASCII_CODE['U'] = 0;
        ASCII_CODE['R'] = 1;
        ASCII_CODE['L'] = 2;
        ASCII_CODE['D'] = 3;

        for(int i = 1; i <= n; i ++)
            for(int j = 1; j <= n; j ++) {
                grid[i][j] = new ArrayList<>();
            }

        for(int i = 1; i <= m; i ++) {
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            int dir = ASCII_CODE[stk.nextToken().charAt(0)];
            int v = Integer.parseInt(stk.nextToken());

            grid[x][y].add(new Tuple(v, i, dir));
        }

        while(t -- > 0) {
            simulate();
        }

        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j ++)
                for(int l = 0; l < grid[i][j].size(); l ++) {
                    if(!grid[i][j].isEmpty()) cnt ++;
                }


        bw.write(cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }
}