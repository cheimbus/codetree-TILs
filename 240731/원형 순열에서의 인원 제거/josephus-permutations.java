import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            q.add(i);
        }

        Queue<Integer> resultQ = new LinkedList<>();
        while(q.size() != 0) {
            for(int i = 1; i < k; i++) {
                q.add(q.poll());
            }
            int pollNum = q.poll();

            resultQ.add(pollNum);
        }
        while(!resultQ.isEmpty()) {
            System.out.print(resultQ.poll() + " ");
        }
    }
}