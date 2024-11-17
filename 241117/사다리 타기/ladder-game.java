import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

class Pair implements Comparable<Pair> {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Pair b) {
        if(x != b.x ) return x - b.x;
        return y - b.y;
    }
}

public class Main {
    public static final int MIN_VAL = Integer.MAX_VALUE;
    public static final int MAX_N = 11;
    public static int n, k, cnt = MIN_VAL;
    public static ArrayList<Pair> line = new ArrayList<>();
    public static ArrayList<Pair> selectedLine = new ArrayList<>();
    public static int[] lineArr = new int[MAX_N];

    public static boolean possible() {
        int[] arr = new int[MAX_N];

        for(int i = 0; i < n; i ++) {
            arr[i] = i;
        }

        for(int i = 0; i < selectedLine.size(); i ++) {
            int idx = selectedLine.get(i).y;
            int val = arr[idx];
            arr[idx] = arr[idx + 1];
            arr[idx + 1] = val;
        }

        boolean isPossible = true;
        for(int i = 0; i < arr.length; i ++) {
            if(lineArr[i] != arr[i]) {
                isPossible = false;
                break;
            }
        }
        return isPossible;
    }

    public static void recursion(int currNum) {
        if(currNum == line.size()) {
            if(possible()) {
                cnt = Math.min(cnt, selectedLine.size());
            }
            return;
        }

        selectedLine.add(line.get(currNum));
        recursion(currNum + 1);
        selectedLine.remove(selectedLine.size() - 1);
        recursion(currNum + 1);
    }

    public static void findLineArr() {

        for(int i = 0; i < n; i ++) {
            lineArr[i] = i;
        }

        for(int i = 0; i < line.size(); i ++) {
            int idx = line.get(i).y;
            int val = lineArr[idx];
            lineArr[idx] = lineArr[idx + 1];
            lineArr[idx + 1] = val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        while(k -- > 0) {
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());

            line.add(new Pair(y, x - 1));
        }

        Collections.sort(line);

        findLineArr();

        recursion(0);

        bw.write(cnt + "");
        bw.flush();
        bw.close();
        br.close();
    }
}