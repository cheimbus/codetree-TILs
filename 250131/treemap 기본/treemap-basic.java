import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> tm = new TreeMap<>();

        StringBuilder sb = new StringBuilder();
        while(n -- > 0) {
            String[] sArr = br.readLine().split(" ");
            String s = sArr[0];
            if(s.equals("add")) {
                int a = Integer.parseInt(sArr[1]);
                int b = Integer.parseInt(sArr[2]);
                tm.put(a, b);
            }
            else if(s.equals("find")) {
                int a = Integer.parseInt(sArr[1]);
                if(tm.containsKey(a)) {
                    sb.append(tm.get(a)).append("\n");
                }
                else sb.append("None").append("\n");
            }
            else if(s.equals("remove")) {
                int a = Integer.parseInt(sArr[1]);
                tm.remove(a);
            }
            else if(s.equals("print_list")) {
                Iterator<Entry<Integer, Integer>> im = tm.entrySet().iterator();
                while(im.hasNext()) {
                    Entry<Integer, Integer> e = im.next();
                    int val = e.getValue();
                    sb.append(val + " ");
                }
                sb.append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}