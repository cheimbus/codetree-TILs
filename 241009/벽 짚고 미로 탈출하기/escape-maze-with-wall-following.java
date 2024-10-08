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
    public static boolean[][][] visited = new boolean[MAX_N + 1][MAX_N + 1][LEN];
    public static int[] dx = new int[]{0, 1, 0, -1};
    public static int[] dy = new int[]{1, 0, -1, 0};

    public static boolean inRange(int x, int y) {
        return 1 <= x && 1 <= y && x <= n && y <= n;
    }

    public static boolean isWall(int x, int y) {
        return inRange(x, y) && grid[x][y] == '#';
    }

    public static void simulation() {
        visited[currX][currY][currDir] = true;
        int nx = currX + dx[currDir];
        int ny = currY + dy[currDir];

        if(isWall(nx, ny)) {
            currDir = (currDir - 1 + 4) % 4;
        }

        else if(!inRange(nx, ny)) {
            currX = nx; currY = ny; cnt ++;
        }

        else {
            int rx = nx + dx[(currDir + 1) % 4];
            int ry = ny + dy[(currDir + 1) % 4];

            if(isWall(rx, ry)) {
                currX = nx; currY = ny; cnt ++;
            }
            else {
                currX = rx; currY = ry; cnt += 2;
                currDir = (currDir + 1) % 4;
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

        StringBuilder sb = new StringBuilder();

        currDir = 0;

        while(inRange(currX, currY) && !visited[currX][currY][currDir]) {
            simulation();
        }

        sb.append(cnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}