import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.StringJoiner;
import java.util.ArrayList;
public class Main {
    public static int n,k;
    public static ArrayList<Integer> li = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();

    public static void print() {
        StringJoiner sj = new StringJoiner(" ");
        for(int i = 0; i < li.size(); i++) {
            sj.add(String.valueOf(li.get(i)));
        }
        sb.append(sj);
        sb.append("\n");
    }

    public static void permutation(int num) {
        if(num == n) {
            print();
            return;
        }
        for(int i = 1; i <= k; i++) {
            li.add(i);
            permutation(num + 1);
            li.remove(li.size() -1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        permutation(0);

        System.out.print(sb);
    }
}