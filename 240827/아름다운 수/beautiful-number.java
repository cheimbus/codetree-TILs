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
            int cnt = selectedNum.get(i);
            for(int j = i; j < n; j++) {
                if(selectedNum.get(i) == selectedNum.get(j)) {
                    cnt --;
                    if(cnt == 0) {
                        break;
                    }
                }else {
                    return false;
                }
            }
            if(cnt != 0) {
                return false;
            }
        }
        return true;
    }

    public static void permutations(int num) {
        if(num == n) {
            if(beatifulNum()) {
                answer++;
            }
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