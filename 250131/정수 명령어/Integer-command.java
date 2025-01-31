import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        TreeSet<Integer> ts = new TreeSet<>();
        StringBuilder sb = new StringBuilder();

        while(n -- > 0) {
            int a = Integer.parseInt(br.readLine());
            while(a -- > 0) {
                String[] sArr = br.readLine().split(" ");
                if(sArr[0].equals("I")) {
                    ts.add(Integer.parseInt(sArr[1]));
                }
                else if(sArr[0].equals("D") && sArr[1].equals("1")) {
                    if(ts.isEmpty()) {
                        continue;
                    }
                    else ts.remove(ts.last());
                }
                else if(sArr[0].equals("D") && sArr[1].equals("-1")) {
                    if(ts.isEmpty()) {
                        continue;
                    }
                    else ts.remove(ts.first());
                }
            }
            if(ts.isEmpty()) sb.append("EMPTY").append("\n");
            else sb.append(ts.last() + " ").append(ts.first()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}