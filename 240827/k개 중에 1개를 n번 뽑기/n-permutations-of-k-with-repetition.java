import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
public class Main {

    public static int k, n;
    public static ArrayList<Integer> selectedNum = new ArrayList<>();

    public static void permutation() {
        for(int i : selectedNum) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void findPermutations(int cnt) {
        if(cnt == n) {
            permutation();
            return;
        }

        for(int i = 1; i <= k; i ++) {
            selectedNum.add(i);
            findPermutations(cnt +1);
            selectedNum.remove(selectedNum.size() -1);
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