import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        int val = 0;
        while(n -- > 0) {
            String s = br.readLine();
            map.put(s, map.getOrDefault(s, 0) + 1);
            val = Math.max(val, map.get(s));
        }
        
        bw.write(val + "");
        bw.flush();
    }
}