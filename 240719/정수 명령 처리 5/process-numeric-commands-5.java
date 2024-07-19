import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        List<Integer> li = new ArrayList<>();

        for(int i = 0; i < num; i++) {
            String[] sArr = br.readLine().split(" ");

            switch(sArr[0]) {
                case "push_back":
                    li.add(Integer.parseInt(sArr[1]));
                    break;
                case "size":
                    System.out.println(li.size());
                    break;
                case "pop_back":
                    li.remove(li.size() -1);
                    break;
                case "get":
                    System.out.println(li.get(Integer.parseInt(sArr[1]) -1));
                    break;
            }
        }
    }
}