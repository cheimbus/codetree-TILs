import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[] visited;

    public static int recursion(int val) {
        if(visited[val] != 0) return visited[val];

        if(val <= 2) {
            if(val == 1) return visited[val] = 1;
            else return visited[val] = 2;
        }

        return visited[val] = (recursion(val - 1) + recursion(val - 2)) % 10007;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        visited = new int[n + 1];

        int ans = recursion(n);

        bw.write(ans + "");
        bw.flush();
    }
}