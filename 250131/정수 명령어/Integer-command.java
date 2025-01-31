import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());  // 테스트 케이스 개수
        StringBuilder sb = new StringBuilder();

        while (n-- > 0) {
            int a = Integer.parseInt(br.readLine());  // 연산 개수
            TreeSet<Integer> ts = new TreeSet<>();  // 매 테스트 케이스마다 초기화

            while (a-- > 0) {
                String[] sArr = br.readLine().split(" ");
                String command = sArr[0];

                if (command.equals("I")) {  // 삽입
                    ts.add(Integer.parseInt(sArr[1]));
                } else if (!ts.isEmpty()) {  // 삭제 연산은 비어있을 때 실행 안 함
                    if (command.equals("D")) {
                        if (sArr[1].equals("1")) ts.pollLast();   // 최댓값 삭제
                        else if (sArr[1].equals("-1")) ts.pollFirst();  // 최솟값 삭제
                    }
                }
            }

            if (ts.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(ts.last()).append(" ").append(ts.first()).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
