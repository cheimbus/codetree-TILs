import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> tm = new TreeMap<>();

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i ++) {
            int a = Integer.parseInt(stk.nextToken());
            if(!tm.containsKey(a)) {
                tm.put(a, i);
            }
        }

        StringBuilder sb = new StringBuilder();
        Iterator<Entry<Integer, Integer>> im = tm.entrySet().iterator();
        while(im.hasNext()) {
            Entry<Integer, Integer> e = im.next();
            int key = e.getKey();
            int val = e.getValue();
            sb.append(key + " ").append(val).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}