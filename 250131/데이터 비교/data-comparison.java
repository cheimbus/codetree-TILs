import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] nArr = new int[n];
        HashSet<Integer> hs1 = new HashSet<>();
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i ++) {
            int a = Integer.parseInt(stk.nextToken());
            hs1.add(a);
            nArr[i] = a;
        }

        int m = Integer.parseInt(br.readLine());
        int[] mArr = new int[m];
        HashSet<Integer> hs2 = new HashSet<>();
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i ++) {
            int a = Integer.parseInt(stk.nextToken());
            hs2.add(a);
            mArr[i] = a;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i ++) {
            if(hs1.contains(mArr[i])) {
                sb.append(1 + " ");
            }
            else sb.append(0 + " ");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}