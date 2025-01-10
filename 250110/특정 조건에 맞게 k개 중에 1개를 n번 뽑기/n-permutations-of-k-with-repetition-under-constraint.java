import java.io.*;
import java.util.*;

public class Main {
    public static int k, n;
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();

    public static void dfs(int depth) {
        if(depth == n) {
            for(int i = 0; i < arr.size(); i ++) {
                sb.append(arr.get(i) + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= k; i ++) {
            if(arr.size() >= 2 && arr.get(arr.size() - 2) == arr.get(arr.size() - 1) && i == arr.get(arr.size() - 1)) {
                continue;
            }
            arr.add(i);
            dfs(depth + 1);
            arr.remove(arr.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        k = Integer.parseInt(stk.nextToken());
        n = Integer.parseInt(stk.nextToken());

        dfs(0);

        bw.write(sb.toString());
        bw.flush();
    }
}
