import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[] visited;

    public static int fibo(int val) {
        if(visited[val] != 0) return visited[val];

        return visited[val] = fibo(val - 1) + fibo(val - 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        visited = new int[n];
        visited[0] = 1;
        visited[1] = 1;

        int ans = fibo(n - 1);

        bw.write(ans + "");
        bw.flush();
    }
}