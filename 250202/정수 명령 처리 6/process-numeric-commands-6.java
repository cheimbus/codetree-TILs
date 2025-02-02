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
            String[] sArr = br.readLine().split(" ");
            if(sArr[0].equals("push")) {
                pq.add(-Integer.parseInt(sArr[1]));
            }
            else if(sArr[0].equals("size")) {
                sb.append(pq.size() + "\n");
            }
            else if(sArr[0].equals("empty")) {
                if(pq.isEmpty()) sb.append(1 + "\n");
                else sb.append(0 + "\n");
            }
            else if(sArr[0].equals("pop")) {
                sb.append(-pq.poll() + "\n");
            }
            else if(sArr[0].equals("top")) {
                sb.append(-pq.peek() + "\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}