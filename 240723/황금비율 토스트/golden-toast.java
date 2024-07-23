import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sArr = bf.readLine().split(" ");
        
        int n1 = Integer.parseInt(sArr[0]);
        int n2 = Integer.parseInt(sArr[1]);

        char[] cArr = bf.readLine().toCharArray();
        LinkedList<Character> li = new LinkedList<>();

        for(char c : cArr) {
            li.add(c);
        }

        ListIterator<Character> it = li.listIterator(li.size());

        for(int i = 0; i < n2; i++) {
            String s = bf.readLine();
            char c = s.charAt(0);
            
            if(c == 'P') {
                char pc = s.charAt(2);
                it.add(pc);
                
            }
            else if(c == 'L') {
                if(!it.hasPrevious()) continue;
                it.previous();
            }
            else if(c == 'R') {
                if(!it.hasNext()) continue;
                it.next();
            }
            else if(c == 'D') {
                if(it.hasNext()) {
                    it.next();
                    it.remove();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char c : li) {
            sb.append(c);
        }

        System.out.println(sb.toString());

    }
}