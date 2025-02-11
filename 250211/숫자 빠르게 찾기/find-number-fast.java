import java.io.*;
import java.util.*;
public class Main {
    public static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        arr = new int[n + 1];
        stk = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i ++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        while(m -- > 0) {
            int a = Integer.parseInt(br.readLine());
            
            int lt = 1;
            int rt = n;
            int ans = -1;
            while(lt <= rt) {
                int mid = (lt + rt) / 2;
                
                if(arr[mid] == a) {
                    ans = mid;
                    break;
                }
                else if(arr[mid] < a) lt = mid + 1;
                else rt = mid - 1;
                
            }
            sb.append(ans + "\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}