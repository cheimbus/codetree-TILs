import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.ArrayDeque;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            String inputString = input[0];
            int num = 0;
            if(input.length > 1) {
                num = Integer.parseInt(input[1]);
            }

            switch(inputString) {
                case "push_back":
                    dq.addLast(num);
                    break;
                case "push_front":
                    dq.addFirst(num);
                    break;
                case "pop_front":
                    if(!dq.isEmpty()) {
                        System.out.println(dq.pollFirst());
                    }
                    break;
                case "pop_back":
                    if(!dq.isEmpty()) {
                        System.out.println(dq.pollLast());
                    }
                    break;
                case "front":
                    System.out.println(dq.peekFirst());
                    break;
                case "back":
                    System.out.println(dq.peekLast());
                    break;
                case "size":
                    System.out.println(dq.size());
                    break;
                case "empty":
                    if(dq.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
            }
        }
    }
}