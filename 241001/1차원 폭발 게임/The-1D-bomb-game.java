import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static final int MAX_N = 100;
    public static int N,M;
    public static int cnt;
    public static int[] arr = new int[MAX_N];

    public static void setArr() {
        int[] tmpArr = new int[MAX_N];

        int tmpCnt = 0;
        for(int i = 0; i < N; i ++) {
            if(arr[i] != 0) {
                tmpArr[tmpCnt ++] = arr[i];
            }
        }

        for(int i = 0; i < N; i ++) {
             arr[i] = tmpArr[i];
        }

        cnt = tmpCnt;
    }

    public static void toZero(int x, int y) {
        for(int i = x; i < y; i ++) {
            arr[i] = 0;
        }
    }

    public static void continuedBomb() {
        for(int i = 0; i < N - 1; i ++) {
            if(arr[i] == 0) continue;
            int pos = i;
            int sameNum = 0;
            for(int j = i; j < N; j ++) {
                if(arr[i] == arr[j]) {
                    sameNum ++;
                    pos ++;
                }
                else break;
            }
            if(sameNum >= M) toZero(i, pos);
        }
    }

    public static void bomb() {
        for(int i = 0; i < N; i ++) {
            continuedBomb();
            setArr();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        for(int i = 0; i < N; i ++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
        }

        cnt = N;

        bomb();

        StringBuilder sb = new StringBuilder();

        sb.append(cnt).append("\n");
        for(int i = 0; i < N; i ++) {
            if(arr[i] != 0) sb.append(arr[i]).append("\n");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}