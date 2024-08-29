import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {

    public static int K,N;
    public static ArrayList<Integer> selectedNum = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();

    public static void print() {
        for(int i: selectedNum) {
            sb.append(i).append(" ");
        }
        sb.append("\n");
    }

    public static void permutation(int num) {
        if(num == N) {
            print();
            return;
        }

        for(int i = 1; i <= K; i++) {
            selectedNum.add(i);
            permutation(num + 1);
            selectedNum.remove(selectedNum.size() -1);
        }
    }
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        K = Integer.parseInt(stk.nextToken());
        N = Integer.parseInt(stk.nextToken());

        permutation(0);

        System.out.print(sb);
    }
}