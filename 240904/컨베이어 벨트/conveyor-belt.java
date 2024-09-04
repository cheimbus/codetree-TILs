import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
import java.util.StringJoiner;
public class Main {

    public static int n, t;
    public static StringBuffer sb = new StringBuffer();
    public static Deque<Integer> dq1 = new ArrayDeque<>();
    public static Deque<Integer> dq2 = new ArrayDeque<>();

    public static void appendStringBuffer(Deque<Integer> dq) {
        StringJoiner sj = new StringJoiner(" ");
        for(Integer num : dq) {
            sj.add(num.toString());
        }
        sb.append(sj.toString());
    }

    public static void conveyorBelt(int cnt) {
        for(int i = 0; i < cnt; i++) {
            int tmp1 = dq1.pollLast();
            int tmp2 = dq2.pollLast();
            dq2.addFirst(tmp1);
            dq1.addFirst(tmp2);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        t = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(stk.nextToken());
            dq1.addLast(num);
        }

        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(stk.nextToken());
            dq2.addLast(num);
        }

        conveyorBelt(t);

        appendStringBuffer(dq1);
        sb.append("\n");
        appendStringBuffer(dq2);

        System.out.print(sb);
    }
}