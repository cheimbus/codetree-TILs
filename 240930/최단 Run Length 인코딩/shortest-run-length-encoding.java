import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    public static final int MAX_VAL = 20;
    public static int min = MAX_VAL;

    public static String encoding(String n) {

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        char a = n.charAt(0);

        for(int i = 0; i < n.length(); i ++) {
            if(a == n.charAt(i)) cnt ++;
            else {
                sb.append(a).append(cnt);
                cnt = 0;
                a = n.charAt(i);
                cnt ++;
            }
        }
        sb.append(a).append(cnt);

        return sb.toString();
    }

    public static int getLength(String n) {

        n = encoding(n);
        return n.length();
    }

    public static String shift(String n) {
        StringBuilder sb = new StringBuilder();

        char[] alphaArr = n.toCharArray();
        char tmp = alphaArr[alphaArr.length - 1];

        for(int i = n.length() - 1; i >= 1; i --) {
            alphaArr[i] = alphaArr[i - 1];
        }
        alphaArr[0] = tmp;

        for(char c : alphaArr) {
            sb.append(c);
        }

        return sb.toString();
    }

    public static void simulation(String n) {

        min = Math.min(min, getLength(n));
        n = shift(n);

        for(int i = 0; i < n.length() - 1; i ++) {
            min = Math.min(min, getLength(n));
            n = shift(n);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String n = br.readLine();

        simulation(n);

        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }
}