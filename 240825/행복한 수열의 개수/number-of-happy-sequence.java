import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputValue = br.readLine().split(" ");
        
        int n = Integer.parseInt(inputValue[0]);
        int checkN = Integer.parseInt(inputValue[1]);

        List<List<Integer>> list = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            String[] inputArray = br.readLine().split(" ");
            List<Integer> li = new ArrayList<>();
            for(String s : inputArray) {
                li.add(Integer.parseInt(s));
            }
            list.add(li);
        }

        int result = 0;

        // 가로
        for(int i = 0; i < n; i++) {
                int cnt = 0;
                int check = list.get(i).get(0);
            for(int j = 0; j < n; j++) {
                if(cnt == checkN) {
                    break;
                }
                if(check == list.get(i).get(j)) {
                    cnt ++;
                }
                if(check != list.get(i).get(j)) {
                    cnt = 1;
                    check = list.get(i).get(j);
                }
            }
            
            if(cnt == checkN) result++;
        }

        //세로
        for(int i = 0; i < n; i++) {
            int cnt = 0;
            int check = list.get(0).get(i);
            for(int j = 0; j < n; j++) {
                if(cnt == checkN) {
                    break;
                }
                if(check == list.get(j).get(i)) {
                    cnt++;
                }
                if(check != list.get(j).get(i)) {
                    cnt = 1;
                    check = list.get(j).get(i);
                }
            }
            if(cnt == checkN) result ++;
        }

    System.out.println(result);

    }
}