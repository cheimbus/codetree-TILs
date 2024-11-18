import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    public static String str;
    public static int ans = Integer.MIN_VALUE;
    public static int[] arr = new int[6];
    public static int len;

    public static int getNum(int n) {
        return arr[str.charAt(n) - 'a'];
    }

    public static int calc() {
        int val = getNum(0);

        for(int i = 2; i < len; i += 2) {
            if(str.charAt(i - 1) == '+') {
                val += getNum(i);
            }
            else if(str.charAt(i - 1) == '-') {
                val -= getNum(i);
            }
            else {
                val *= getNum(i);
            }
        }
        return val;
    }

    public static void recursion(int currNum) {
        if(currNum == 6) {
            ans = Math.max(ans, calc());
            return;
        }

        for(int i = 1; i <= 4; i ++) {
            arr[currNum] = i;
            recursion(currNum + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        str = br.readLine();
        len = str.length();

        recursion(0);

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}