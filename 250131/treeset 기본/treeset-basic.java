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
            String[] sArr = br.readLine().split(" ");
            if(sArr[0].equals("add")) {
                ts.add(Integer.parseInt(sArr[1]));
            }
            else if(sArr[0].equals("largest")) {
                if(ts.size() == 0) {
                    sb.append("None").append("\n");
                }
                else sb.append(ts.last()).append("\n");
            }
            else if(sArr[0].equals("smallest")) {
                if(ts.size() == 0) {
                    sb.append("None").append("\n");
                }
                else sb.append(ts.first()).append("\n");
            }
            else if(sArr[0].equals("find")) {
                if(ts.contains(Integer.parseInt(sArr[1]))) {
                    sb.append("true").append("\n");
                }
                else sb.append("false").append("\n");
            }
            else if(sArr[0].equals("lower_bound")) {
                if(ts.ceiling(Integer.parseInt(sArr[1])) == null) {
                    sb.append("None").append("\n");
                }
                else sb.append(ts.ceiling(Integer.parseInt(sArr[1]))).append("\n");
            }
            else if(sArr[0].equals("upper_bound")) {
                if(ts.higher(Integer.parseInt(sArr[1])) == null) {
                    sb.append("None").append("\n");
                }
                else sb.append(ts.higher(Integer.parseInt(sArr[1]))).append("\n");
            }
            else if(sArr[0].equals("remove")) {
                ts.remove(Integer.parseInt(sArr[1]));
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}