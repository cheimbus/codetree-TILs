import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.LinkedList;
public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] sArr = br.readLine().split(" ");

        LinkedList<Integer> li = new LinkedList<>();

        for(String s : sArr) {
            int stringToInt = Integer.parseInt(s);
            li.add(stringToInt);
        }

        for(int i = 1; i < n; i++) {
            int j = i -1;
            int key = li.get(i);
            
            while(j >= 0 && li.get(j) > key) {
                li.set(j+1, li.get(j));
                j--;
            }
            li.set(j+1, key);
        }

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < n; i++) {
            sb.append(li.get(i)).append(" ");
        }

        sb.setLength(sb.length()-1);

        System.out.println(sb);
    }
}