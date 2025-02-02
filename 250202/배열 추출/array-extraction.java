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
            if(a == 0 && pq.isEmpty()) {
                sb.append(0 + "\n");
            }
            else if(a == 0) {
                int b = -pq.poll();
                sb.append(b + "\n");
            }
            else {
                pq.add(-a);
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
