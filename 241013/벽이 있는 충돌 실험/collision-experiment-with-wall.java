import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Marble {
    int x;
    int y;
    int dir;
    public Marble(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
}

public class Main {
    public static final int MAX_N = 50;
    public static int t, n, m;
    public static int[] ASCII_CODE = new int[128];
    public static ArrayList<Marble> marbleArr;
    public static StringBuilder sb = new StringBuilder();
    public static int[] dx = new int[]{-1, 0, 0, 1};
    public static int[] dy = new int[]{0, 1, -1, 0};
    public static int[][] cntGrid = new int[MAX_N + 1][MAX_N + 1];

    public static boolean inRange(int x, int y) {
        return 1 <= x && 1 <= y && x <= n && y <= n;
    }

    public static Marble move(Marble currMarble) {
        int nx = currMarble.x + dx[currMarble.dir];
        int ny = currMarble.y + dy[currMarble.dir];
        if(inRange(nx, ny)) {
            return new Marble(nx, ny, currMarble.dir);
        }
        else return new Marble(currMarble.x, currMarble.y, 3 - currMarble.dir);
    }

    public static void moveAll() {
        for(int i = 0; i < marbleArr.size(); i ++) {
            marbleArr.set(i, move(marbleArr.get(i)));
        }
    }

    public static boolean isDuplicateMarble(int x, int y) {
        if(cntGrid[x][y] >= 2) return true;
        else return false;
    }

    public static void removeDuplicateMarble() {
        ArrayList<Marble> nextMarbleArr = new ArrayList<>();

        for(int i = 0; i < marbleArr.size(); i ++) {
            int x = marbleArr.get(i).x;
            int y = marbleArr.get(i).y;
            cntGrid[x][y] ++;
        }

        for(int i = 0; i < marbleArr.size(); i ++) {
            int x = marbleArr.get(i).x;
            int y = marbleArr.get(i).y;
            int dir = marbleArr.get(i).dir;
            if(!isDuplicateMarble(x, y)) {
                nextMarbleArr.add(new Marble(x, y, dir));
            }
        }

        for(int i = 0; i < marbleArr.size(); i ++) {
            int x = marbleArr.get(i).x;
            int y = marbleArr.get(i).y;
            cntGrid[x][y] --;
        }

        marbleArr = nextMarbleArr;
    }

    public static void simulation() {
        moveAll();
        removeDuplicateMarble();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        t = Integer.parseInt(br.readLine());

        ASCII_CODE['U'] = 0;
        ASCII_CODE['D'] = 3;
        ASCII_CODE['R'] = 1;
        ASCII_CODE['L'] = 2;

        while(t -- > 0) {
            marbleArr = new ArrayList<>();
            StringTokenizer stk = new StringTokenizer(br.readLine());
            n = Integer.parseInt(stk.nextToken());
            m = Integer.parseInt(stk.nextToken());

            while(m -- > 0) {
                stk = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(stk.nextToken());
                int y = Integer.parseInt(stk.nextToken());
                int dir = ASCII_CODE[stk.nextToken().charAt(0)];
                marbleArr.add(new Marble(x, y, dir));
            }
            for(int i = 0; i < n * 2; i ++) {
                simulation();
            }
            sb.append(marbleArr.size()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}