import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> hs = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        while(n -- > 0) {
            String[] sArr = br.readLine().split(" ");
            if(sArr[0].equals("find")) {
                if(hs.contains(Integer.parseInt(sArr[1]))) {
                    sb.append("true").append("\n");
                }
                else sb.append("false").append("\n");
            }
            else if(sArr[0].equals("add")) {
                hs.add(Integer.parseInt(sArr[1]));
            }
            else if(sArr[0].equals("remove")) {
                hs.remove(Integer.parseInt(sArr[1]));
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}