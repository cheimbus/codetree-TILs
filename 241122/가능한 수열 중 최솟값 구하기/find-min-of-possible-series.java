import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
    public static int n;
    public static StringBuilder sb = new StringBuilder();
    public static ArrayList<Integer> arr = new ArrayList<>();

    public static boolean sameSequence(int x1, int y1, int x2, int y2) {
        for(int i = 0; i <= y1 - x1; i ++) {
            if(arr.get(x1 + i) != arr.get(x2 + i)) return false;
        }
        return true;
    }

    public static boolean possible() {
        for(int idx = 0; idx < arr.size(); idx ++) {
            int len = 1;
            while(true) {
                int str1 = idx, end1 = str1 + len - 1;
                int str2 = end1 + 1, end2 = str2 + len - 1;

                if(end2 >= n) break;

                if(sameSequence(str1, end1, str2, end2)) {
                    return true;
                }
                len ++;
            }
        }
        return false;
    }

    public static void recursion(int currNum) {
        if(currNum == n) {
            if(!possible()) {
                for(int i = 0; i < arr.size(); i ++) {
                    sb.append(arr.get(i));
                }
                System.out.print(sb.toString());
                System.exit(0);
            }
            return;
        }

        for(int i = 4; i <= 6; i ++) {
            arr.add(i);
            recursion(currNum + 1);
            arr.remove(arr.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        recursion(0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}