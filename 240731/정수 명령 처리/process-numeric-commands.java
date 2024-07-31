import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            String stack = temp[0];
            int num = 0;
            if(temp.length > 1) {
                num = Integer.parseInt(temp[1]);
            }
            switch(stack) {
                case "push":
                    st.push(num);
                    break;
                case "size":
                    System.out.println(st.size());
                    break;
                case "empty":
                    if(st.isEmpty()) {
                        System.out.println(1);
                    } else{
                        System.out.println(0);
                    }
                    break;
                case "pop":
                    if(!st.isEmpty()) {
                        System.out.println(st.pop());
                    }
                    break;
                case "top":
                    if(!st.isEmpty()) {
                        System.out.println(st.peek());
                    }
                    break;
            }
        }
    }
}