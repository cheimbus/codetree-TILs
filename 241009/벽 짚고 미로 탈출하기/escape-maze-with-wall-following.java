import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static final int MAX_N = 100;
    public static final int LEN = 4;
    public static int n, currX, currY, currDir, cnt;
    public static char[][] grid = new char[MAX_N + 1][MAX_N + 1];
    public static int[] dx = new int[]{0, 1, 0, -1};
    public static int[] dy = new int[]{1, 0, -1, 0};
    public static boolean[][][] visited = new boolean[MAX_N + 1][MAX_N + 1][LEN];

    public static boolean inRange(int x, int y) {
        return 1 <= x && 1 <= y && x <= n && y <= n;
    }

    public static boolean wallEx(int x, int y) {
        return inRange(x, y) && grid[x][y] == '#';
    }

    public static void simulation() {
        visited[currX][currY][currDir] = true;

        int nextX = currX + dx[currDir];
        int nextY = currY + dy[currDir];

        if(wallEx(nextX, nextY)) {
            currDir = (currDir - 1 + 4) % 4;
        }

        else if(!inRange(nextX, nextY)) {
            currX = nextX; currY = nextY; cnt ++;
        }

        else {
            int nx = nextX + dx[(currDir + 1) % 4];
            int ny = nextY + dy[(currDir + 1) % 4];

            if(wallEx(nx, ny)) {
                currX = nextX; currY = nextY; cnt ++;
            }
            else {
                currX = nx; currY = ny; currDir = (currDir + 1 + 4) % 4; cnt += 2;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine());
        currX = Integer.parseInt(stk.nextToken());
        currY = Integer.parseInt(stk.nextToken());

        for(int i = 1; i <= n; i ++) {
            String s = br.readLine();
            for(int j = 1; j <= n; j ++) {
                grid[i][j] = s.charAt(j - 1);
            }
        }

        currDir = 0;

        boolean isVisited = false;
        while(inRange(currX, currY)) {
            if(visited[currX][currY][currDir]) {
                isVisited = true;
                break;
            }
            simulation();
        }
        StringBuilder sb = new StringBuilder();
        if(isVisited) sb.append(-1);
        else sb.append(cnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}