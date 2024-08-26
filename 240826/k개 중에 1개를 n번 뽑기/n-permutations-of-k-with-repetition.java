import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int k,n;
    public static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        choice(0);
    }

    private static void choice(int i) {
        if(i==n){
            print();
            return;
        }
        for(int j=1;j<=k;j++){
            list.add(j);
            choice(i+1);
            list.remove(list.size()-1);
        }
    }
    private static void print() {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(list.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}