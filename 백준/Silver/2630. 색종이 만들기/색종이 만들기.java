import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int[][] board;
    public static int[] colorCounts = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursion(n, 0, 0);
        System.out.println(colorCounts[0]);
        System.out.println(colorCounts[1]);
    }

    public static void recursion(int size, int x, int y) {
        if (isSameColorZone(size, x, y)) {
            int zoneColor = getZoneColor(x, y);
            colorCounts[zoneColor] += 1;
            return;
        }

        int half = size / 2;
        recursion(half, x, y);
        recursion(half, x + half, y);
        recursion(half, x, y + half);
        recursion(half, x + half, y + half);
    }

    public static boolean isSameColorZone(int size, int x, int y) {
        int value = board[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (value != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int getZoneColor(int x, int y) {
        return board[x][y];
    }

}
