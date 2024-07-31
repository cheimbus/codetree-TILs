import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<String> stack = new Stack<>();

        String[] sArr = br.readLine().split("");

        for(String s : sArr) {
            if(stack.isEmpty() && s.equals(")")) {
                System.out.println("No");
            }
            if(s.equals("(")) stack.push(s);
            if(!stack.isEmpty() && s.equals(")")) stack.pop(); 
        }
        if(!stack.isEmpty()) System.out.println("No");
        else System.out.println("Yes");
    }
}