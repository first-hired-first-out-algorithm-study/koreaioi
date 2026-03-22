
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final int MINIMUM_BOARD_SIZE = 1;
    public static int n, r, c, count;
    public static int[] dx = {0, 0, 1, 1};
    public static int[] dy = {0, 1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = (int) (Math.pow(2, Integer.parseInt(st.nextToken())));
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        recursion(n, 0, 0);
        System.out.println(count);
    }

    private static void recursion(int boardSize, int x, int y) {
        if (isMinimumSize(boardSize) && isTargetPosition(x, y)) {
            return;
        }

        int half = boardSize / 2;
        for (int i = 0; i < 4; i++) {
            int nx = x + (dx[i] * half);
            int ny = y + (dy[i] * half);
            if (containTarget(half, nx, ny)) {
                count += (int) (Math.pow(half, 2)) * i;
                recursion(half, nx, ny);
                return;
            }
        }
    }

    private static boolean isMinimumSize(int boardSize) {
        return boardSize == MINIMUM_BOARD_SIZE;
    }

    public static boolean isTargetPosition(int x, int y) {
        return x == r && y == c;
    }

    private static boolean containTarget(int boardSize, int x, int y) {
        return (x <= r && r < x + boardSize) && (y <= c && c < y + boardSize);
    }

}
