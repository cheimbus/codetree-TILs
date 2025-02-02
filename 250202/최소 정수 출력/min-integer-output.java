import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        while(n -- > 0) {
            int a = Integer.parseInt(br.readLine());
            if(a == 0) {
                if(pq.isEmpty()) sb.append(0 + "\n");
                else sb.append(pq.poll() + "\n");
            }
            else {
                pq.add(a);
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}