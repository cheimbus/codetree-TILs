import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n, m;
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        HashMap<String, String> map1 = new HashMap<>();
        HashMap<String, String> map2 = new HashMap<>();

        for(int i = 1; i <= n; i ++) {
            String s = br.readLine();
            map1.put(s, i + "");
            map2.put(i + "", s);
        }

        StringBuilder sb = new StringBuilder();
        while(m -- > 0) {
            String s = br.readLine();
            if(map1.containsKey(s)) {
                sb.append(map1.get(s)).append("\n");
            }
            else if(map2.containsKey(s)) {
                sb.append(map2.get(s)).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}