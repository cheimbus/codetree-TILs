import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    public static int k, n;
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();

    public static void print() {
        for(int i = 0; i < arr.size(); i ++) {
            sb.append(arr.get(i)).append(" ");
        }
        sb.append("\n");
    }

    public static void recursion(int currNum) {
        if(currNum == n + 1) {
            print();
            return;
        }

        for(int i = 1; i <= k; i ++) {
            arr.add(i);
            recursion(currNum + 1);
            arr.remove(arr.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        k = Integer.parseInt(stk.nextToken());
        n = Integer.parseInt(stk.nextToken());

        recursion(1);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}