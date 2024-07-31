import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            String[] tmp = bf.readLine().split(" ");

            String q = tmp[0];
            int num = 0;
            if(tmp.length > 1) {
                num = Integer.parseInt(tmp[1]);
            }

            switch(q) {
                case "push":
                    queue.add(num);
                    break;
                case "front":
                    System.out.println(queue.peek());
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "pop":
                    if(!queue.isEmpty()) {
                        System.out.println(queue.poll());
                    }
                    break;
                case "empty":
                    if(queue.isEmpty()) {
                        System.out.println(1);
                    } else System.out.println(0);
            }
        }
    }
}