import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Main {
    public static int N,M;
    public static ArrayList<Integer>[] graph;
    public static boolean[] visited;
    public static int answer;
    
    public static void DFS(int vertax) {
        for(int i = 0; i < graph[vertax].size(); i++) {
            int currV = graph[vertax].get(i);
            if(!visited[currV]) {
                visited[currV] = true;
                answer ++;
                DFS(currV);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        graph = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        visited = new boolean[N + 1];

        for(int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int parentV = Integer.parseInt(stk.nextToken());
            int childV = Integer.parseInt(stk.nextToken());
            
            graph[parentV].add(childV);
            graph[childV].add(parentV);
        }

        int firstV = 1;
        visited[firstV] = true;
        DFS(firstV);

        System.out.println(answer);
    }
}