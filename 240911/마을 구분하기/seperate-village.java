import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Collections;
public class Main {
    public static int n;
    public static ArrayList<Integer>[] graph;
    public static int pCnt;
    public static ArrayList<Integer> villages;
    public static final int MAX_LEN = 4;
    public static int[] dx = new int[]{1, 0, -1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};
    public static boolean[][] visited;

    public static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }

    public static boolean canGo(int x, int y) {
        if(!inRange(x, y)) {
            return false;
        }
        if(visited[x][y] || graph[x].get(y) == 0) {
            return false;
        }
        return true;
    }

    public static void DFS(int x, int y) {
        for(int i = 0; i < MAX_LEN; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(canGo(nx, ny)) {
                pCnt++;
                visited[nx][ny] = true;
                DFS(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        graph = new ArrayList[n];
        villages = new ArrayList<>();
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int num = Integer.parseInt(stk.nextToken());
                graph[i].add(num);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(canGo(i, j)) {
                    visited[i][j] = true;
                    pCnt = 1;
                    DFS(i, j);
                    villages.add(pCnt);
                }
            }
        }
        Collections.sort(villages);
        StringBuilder sb = new StringBuilder();
        sb.append(villages.size()).append("\n");
        for(int i = 0; i < villages.size(); i++) {
            sb.append(villages.get(i)).append("\n");
        }
        System.out.print(sb);
    }
}