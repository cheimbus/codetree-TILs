import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Main {
    public static ArrayList<Integer>[] graph;
    public static boolean[] visited;
    public static int cnt;
    public static int n,m;

    public static void DFS(int vertex) {
        for(int i = 0; i < graph[vertex].size(); i++) {
            int getVertex = graph[vertex].get(i);
            if(!visited[getVertex]) {
                cnt++;
                visited[getVertex] = true;
                DFS(getVertex);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int vtx1 = Integer.parseInt(stk.nextToken());
            int vtx2 = Integer.parseInt(stk.nextToken());
            graph[vtx1].add(vtx2);
            graph[vtx2].add(vtx1);
        }

        int first = 1;
        visited[first] = true;
        DFS(first);
        
        System.out.print(cnt);
    }
}