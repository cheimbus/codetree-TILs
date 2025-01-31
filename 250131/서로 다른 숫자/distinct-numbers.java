import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> hs = new HashSet<>();

        StringTokenizer stk = new StringTokenizer(br.readLine());
        while(n -- > 0) {
            hs.add(Integer.parseInt(stk.nextToken()));
        }

        bw.write(hs.size() + "");
        bw.flush();
    }
}