import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
import java.util.StringJoiner;
public class Main {
    public static int n, t;
    public static Deque<Integer>[] dq = new ArrayDeque[3];
    public static StringBuffer sb = new StringBuffer();

    public static void conveyorBelt(int num) {
        for(int i = 0; i < num; i++) {
            for(int j = 0; j < dq.length; j++) {
                if(j != dq.length -1) {
                    int tmp = dq[j].pollLast();
                    dq[j+1].addFirst(tmp);
                }
                else {
                    int tmp = dq[j].pollLast();
                    dq[0].addFirst(tmp);
                }
            }
        }
    }

    public static void appendString(Deque<Integer>[] deque) {
        StringJoiner sj;
        for(Deque<Integer> d : deque) {
            sj = new StringJoiner(" ");
            for(Integer num : d) {
                sj.add(num.toString());
            }
            sb.append(sj);
            sb.append("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        t = Integer.parseInt(stk.nextToken());

        for(int i = 0; i < 3; i++) {
            dq[i] = (new ArrayDeque<>());
        }

        for(Deque<Integer> deque : dq) {
            stk = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                int num = Integer.parseInt(stk.nextToken());
                deque.addLast(num);
            }
        }

        conveyorBelt(t);
        appendString(dq);

        System.out.print(sb);
    }
}