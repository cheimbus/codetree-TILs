import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        
        String input;
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            String[] parts = input.split(" ");
            String command = parts[0];

            switch (command) {
                case "push_back":
                    int value = Integer.parseInt(parts[1]);
                    list.add(value);
                    break;

                case "pop_back":
                    if (!list.isEmpty()) {
                        list.remove(list.size() - 1);
                    }
                    break;

                case "get":
                    int index = Integer.parseInt(parts[1]);
                    if (index - 1 >= 0 && index - 1 < list.size()) {
                        System.out.println(list.get(index - 1));
                    } else {
                        System.out.println("Index out of bounds");
                    }
                    break;

                case "size":
                    System.out.println(list.size());
                    break;
            }
        }
    }
}