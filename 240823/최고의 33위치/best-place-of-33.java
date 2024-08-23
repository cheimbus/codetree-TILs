import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        List<String[]> list = new ArrayList<>();

        for(int i = 0; i < num; i++) {
            String[] inputList = br.readLine().split(" ");
            list.add(inputList);
        }

        List<Integer> resultList = new ArrayList<>();

         for (int i = 0; i <= num - 3; i++) {
            for (int j = 0; j <= num - 3; j++) {
                int cnt = 0;
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (list.get(k)[l].equals("1")) {
                            cnt++;
                        }
                    }
                }
                resultList.add(cnt);
            }
        }

        int result = Collections.max(resultList);

        System.out.println(result);
    }
}