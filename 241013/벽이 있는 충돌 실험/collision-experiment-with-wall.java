import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Marble {
    int x; int y; int dir;
    public Marble(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
}

public class Main {
    public static final int LEN = 4;
    public static int t, n, m;
    public static ArrayList<Marble> marbleArr = new ArrayList<>();
    public static int[] dx = new int[]{-1, 0, 0, 1};
    public static int[] dy = new int[]{0, 1, -1, 0};
    public static int[] ASCII_CODE = new int[128];
    public static StringBuilder sb = new StringBuilder();

    public static boolean inRange(int x, int y) {
        return 1 <= x && 1 <= y && x <= n && y <= n;
    }

    public static Marble move(Marble marble) {
        int x = marble.x; int y = marble.y; int dir = marble.dir;
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if(inRange(nx, ny)) {
            return new Marble(nx, ny, dir);
        }
        else return new Marble(x, y, 3 - dir);
    }

    public static void moveAll() {
        for(int i = 0; i < marbleArr.size(); i ++) {
            Marble getMarble = marbleArr.get(i);
            Marble newMarble = move(getMarble);
            marbleArr.set(i, newMarble);
        }
    }

    public static boolean duplicateMarbleEx(int idx) {
        int targetX = marbleArr.get(idx).x;
        int targetY = marbleArr.get(idx).y;
        for(int i = 0; i < marbleArr.size(); i ++) {
            if(idx == i) continue;
            int nx = marbleArr.get(i).x;
            int ny = marbleArr.get(i).y;
            if(targetX == nx && targetY == ny) return true;
        }
        return false;
    }

    public static void deleteSamePosition() {
        ArrayList<Marble> newMarbleArr = new ArrayList<>();

        for(int i = 0; i < marbleArr.size(); i ++) {
            if(!duplicateMarbleEx(i)) {
                newMarbleArr.add(marbleArr.get(i));
            }
        }

        marbleArr = newMarbleArr;
    }

    public static void simulation() {
        moveAll();
        deleteSamePosition();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        t = Integer.parseInt(br.readLine());

        ASCII_CODE['U'] = 0;
        ASCII_CODE['R'] = 1;
        ASCII_CODE['D'] = 3;
        ASCII_CODE['L'] = 2;

        while(t -- > 0) {
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