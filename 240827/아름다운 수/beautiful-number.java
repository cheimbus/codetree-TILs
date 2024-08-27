import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class Main {
    public static int n;
    public static ArrayList<Integer> selectedNum = new ArrayList<>();
    public static int answer;
    public static boolean beatifulNum() {
        for(int i = 0; i < n; i += selectedNum.get(i)) {
            for(int j = i; j < i + selectedNum.get(i); j++) {
                System.out.println(selectedNum.get(j));
            }
        }
        return true;
    }

    public static void permutations(int num) {
        if(num == n) {
            beatifulNum();
            return;
        }
        for(int i = 1; i <= 4; i++) {
            selectedNum.add(i);
            permutations(num +1);
            selectedNum.remove(selectedNum.size() -1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        permutations(0);
        
        System.out.println(answer);
    }
}