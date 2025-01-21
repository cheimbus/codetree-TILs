import java.io.*;
import java.util.*;

class Tuple implements Comparable<Tuple> {
    int x;
    int y;
    int z;
    public Tuple(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    @Override
    public int compareTo(Tuple b) {
        if(z != b.z) return b.z - z;
        if(x != b.x) return x - b.x;
        return y - b.y;
    }
}

public class Main {
    public static int n, k, maxVal, currVal;
    public static int[][] grid;
    public static boolean[][] visited;
    public static int x, y;
    public static ArrayList<Tuple> arr;
    public static Queue<Tuple> q = new LinkedList<>();
    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static boolean inRange(int x, int y) {
        return 1 <= x && 1 <= y && x <= n && y <= n && grid[x][y] < currVal && !visited[x][y];
    }

    public static void bfs() {
        while(!q.isEmpty()) {
            Tuple t = q.poll();
            int currX = t.x;
            int currY = t.y;
            for(int i = 0; i < 4; i ++) {
                int nx = currX + dx[i];
                int ny = currY + dy[i];
                if(inRange(nx, ny)) {
                    arr.add(new Tuple(nx, ny, grid[nx][ny]));
                    q.add(new Tuple(nx, ny, grid[nx][ny]));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        grid = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i ++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j ++) {
                grid[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        stk = new StringTokenizer(br.readLine());
        x = Integer.parseInt(stk.nextToken());
        y = Integer.parseInt(stk.nextToken());

        currVal = grid[x][y];

        while(k -- > 0) {
            arr = new ArrayList<>();
            visited = new boolean[n + 1][n + 1];
            q.add(new Tuple(x, y, grid[x][y]));
            bfs();
            Collections.sort(arr);
            Tuple t = arr.get(0);
            x = t.x;
            y = t.y;
            currVal = grid[x][y];
        }

        bw.write(x + " " + y);
        bw.flush();
    }
}