import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        LinkedList<Integer> li = new LinkedList<>();

        String[] cArr = br.readLine().split(" ");
        for(String c : cArr) {
            int in = Integer.parseInt(c);
            li.add(in);
        }

        for(int i = 0; i < n -1; i++) {
            for(int j = 0; j < n -1 -i; j++) {
                if(li.get(j) > li.get(j+1)) {
                    int temp = li.get(j);
                    li.set(j, li.get(j+1));
                    li.set(j+1, temp);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int a : li) {
            sb.append(a).append(" ");
        }
        sb.setLength(sb.length()-1);

        System.out.println(sb);

    }
}