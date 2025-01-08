import java.io.*;
import java.util.*;

public class Main {
    public static int n, cnt;
    public static ArrayList<Integer> arr = new ArrayList<>();

    public static boolean find() {
        for(int i = 0; i < arr.size(); i += arr.get(i)) {
            if(i + arr.get(i) - 1 >= n) return false;
            for(int j = i; j < i + arr.get(i); j ++) {
                if(arr.get(i) != arr.get(j)) return false;
            }
        }
        return true;
    }

    public static void dfs(int depth) {
        if(depth == n) {
            if(find()) {
                cnt ++;
            }
            return;
        }

        for(int i = 1; i <= 4; i ++) {
            arr.add(i);
            dfs(depth + 1);
            arr.remove(arr.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        dfs(0);

        bw.write(cnt + "");
        bw.flush();
    }
}