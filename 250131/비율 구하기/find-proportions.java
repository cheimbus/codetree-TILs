import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        double a = n;
        TreeMap<String, Integer> tm = new TreeMap<>();

        while(n -- > 0) {
            String s = br.readLine();
            tm.put(s, tm.getOrDefault(s, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        Iterator<Entry<String, Integer>> it = tm.entrySet().iterator();
        while(it.hasNext()) {
            Entry<String, Integer> e = it.next();
            String s = e.getKey();
            int v = e.getValue();
            double d = v / a * 100;
            String format = String.format("%.4f", d);
            sb.append(s + " ").append(format).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}