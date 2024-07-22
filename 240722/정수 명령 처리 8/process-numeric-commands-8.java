import java.util.LinkedList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> list = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            String[] sp = br.readLine().split(" ");

            switch(sp[0]) {

                case "push_back":
                    list.addLast(Integer.parseInt(sp[1]));
                    break;

                case "push_front":
                    list.addFirst(Integer.parseInt(sp[1]));
                    break;

                case "pop_front":
                    int info1 = list.pollFirst();
                    System.out.println(info1);
                    break;

                case "front":
                    int info2 = list.peekFirst();
                    System.out.println(info2);
                    break;

                case "pop_back":
                    int info3 = list.pollLast();
                    System.out.println(info3);
                    break;

                case "back":
                    int info4 = list.peekLast();
                    System.out.println(info4);
                    break;

                case "size":
                    System.out.println(list.size());
                    break;

                case "empty":
                    if(list.isEmpty()) {
                        System.out.println(1);
                        break;
                    }
                    else {
                        System.out.println(0);
                        break;
                    }
                    
            }
        }
 
        
    }
}