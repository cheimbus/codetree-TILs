import java.util.*;
import java.util.Map.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[] arr = new int[n];

        for(int i = 0; i < n; i ++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int val = 0;
        for(int i = n - 1; i >= 0; i --) {
            val += m / arr[i];
            m %= arr[i];
        }

        bw.write(val + "");
        bw.flush();
        br.close();
    }
}
