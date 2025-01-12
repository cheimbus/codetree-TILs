import java.io.*;
import java.util.*;
public class Main {
    public static int n, m;
    public static StringBuilder sb = new StringBuilder();
    public static ArrayList<Integer> arr = new ArrayList<>();

    public static void dfs(int depth) {
        if(depth == m) {
            for(int i = 0; i < arr.size(); i ++) {
                sb.append(arr.get(i) + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= n; i ++) {
            if(arr.size() >= 2 && arr.get(arr.size() - 2) == i && arr.get(arr.size() - 1) == i) {
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
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());    

        dfs(0);
    
        bw.write(sb.toString());
        bw.flush();
    }
}