import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) throws IOException  {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        List<Integer> arr = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String[] read = br.readLine().split(" ");

            switch(read[0]) {
                case "push_back":
                    int num = Integer.parseInt(read[1]);
                    arr.add(num);
                    break;
                
                case "pop_back":
                    arr.remove(arr.size() -1);
                    break;
                
                case "get":
                    System.out.println(arr.get(Integer.parseInt(read[1]) -1));
                    break;

                case "size":
                    System.out.println(arr.size());
                    break;
            }
        }        
    }
}