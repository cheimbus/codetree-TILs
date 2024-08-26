import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
public class Main {

    public static int n, k;
    public static List<Integer> answer = new ArrayList<>();
    
    public static void print() {
        for(int i : answer) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void findPermutations(int curNum) {
        if(curNum == n) {
            print();
            return;
        }

        for(int i = 1; i <= k; i++) {
            answer.add(i);
            findPermutations(curNum +1);
            answer.remove(answer.size() -1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        k = Integer.parseInt(stk.nextToken());
        n = Integer.parseInt(stk.nextToken());

        findPermutations(0);
    }
}