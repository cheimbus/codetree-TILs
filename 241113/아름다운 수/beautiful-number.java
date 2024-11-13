import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
public class Main {
    public static int n, cnt;
    public static ArrayList<Integer> arr = new ArrayList<>();

    public static boolean isBeautiful() {
        for(int i = 0; i < n; i += arr.get(i)) {
            if(i + arr.get(i) > n) return false;

            for(int j = i; j < i + arr.get(i); j ++) {
                if(arr.get(i) != arr.get(j)) return false;
            }
        }
        return true;
    }

    public static void findBeautifulNum(int num) {
        if(num == n) {
            if(isBeautiful()) {
                cnt ++;
            }
            return;
        }

        for(int k = 1; k <= 4; k ++) {
            arr.add(k);
            findBeautifulNum(num + 1);
            arr.remove(arr.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        findBeautifulNum(0);

        bw.write(cnt + "");
        bw.flush();
        bw.close();
    }
}