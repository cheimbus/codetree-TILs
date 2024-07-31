import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.ArrayDeque;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        
        Deque dq = new ArrayDeque<>();

        for(int i = 1; i <= n; i++) {
            dq.addLast(i);
        }

        while(dq.size() != 1) {
            dq.pollFirst();
            dq.addLast(dq.pollFirst());
        }
        System.out.println(dq.peekFirst());
    }
}