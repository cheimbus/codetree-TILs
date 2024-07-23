import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] s = br.readLine().split(" ");

        LinkedList<Integer> li = new LinkedList<>();
        for(String st : s) {
            int toInt = Integer.parseInt(st);
            li.add(toInt);
        }       

        for(int i = 0; i < li.size() -1; i++) {
            int min = i;
            for(int j = i+1; j < li.size(); j++) {
                if(li.get(j) < li.get(min)) {
                    min = j;
                }
            }
            int tmp = li.get(i);
            li.set(i, li.get(min));
            li.set(min, tmp);
        }

        StringBuffer sb = new StringBuffer();
        for(int i : li) {
            sb.append(i).append(" ");
        }

        sb.setLength(sb.length()-1);

        System.out.println(sb);
    }
}