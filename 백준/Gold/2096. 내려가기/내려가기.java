
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 메모리 초과 발생
 * 100,000 * 100,000....
 * */
public class Main {

    public static final int COUNT_OF_NUMBER = 3;
    public static final int[] FIRST_DIRECTIONS = new int[]{0, 1};
    public static final int[] SECOND_DIRECTIONS = new int[]{-1, 0, 1};
    public static final int[] THIRD_DIRECTIONS = new int[]{-1, 0};
    public static final int[][] DIRECTIONS = new int[][]{
            FIRST_DIRECTIONS,
            SECOND_DIRECTIONS,
            THIRD_DIRECTIONS
    };

    public static int n;
    public static int[][] board;
    public static int[][] minimumDP;
    public static int[][] maximumDP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        board = new int[n][COUNT_OF_NUMBER];
        minimumDP = new int[n][COUNT_OF_NUMBER];
        maximumDP = new int[n][COUNT_OF_NUMBER];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < COUNT_OF_NUMBER; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int[] minimum : minimumDP) {
            Arrays.fill(minimum, Integer.MAX_VALUE);
        }

        for (int i = 0; i < COUNT_OF_NUMBER; i++) {
            maximumDP[0][i] = board[0][i];
            minimumDP[0][i] = board[0][i];
        }

        for (int i = 0; i < n - 1; i++) {
            for (int index = 0; index < COUNT_OF_NUMBER; index++) {
                doMaximumDynamicProgramming(i, index, maximumDP[i][index]);
                doMinimumDynamicProgramming(i, index, minimumDP[i][index]);
            }
        }

        int max = Arrays.stream(maximumDP[n - 1]).max().getAsInt();
        int min = Arrays.stream(minimumDP[n - 1]).min().getAsInt();
        System.out.println(max);
        System.out.println(min);
    }

    public static void doMaximumDynamicProgramming(int x, int index, int beforeDpValue) {
        int nx = x + 1;
        int[] directions = DIRECTIONS[index];
        for (int i = 0; i < directions.length; i++) {
            int ny = index + directions[i];
            maximumDP[nx][ny] = Math.max(maximumDP[nx][ny], maximumDP[x][index] + board[nx][ny]);
        }
    }

    public static void doMinimumDynamicProgramming(int x, int index, int beforeDpValue) {
        int nx = x + 1;
        int[] directions = DIRECTIONS[index];
        for (int i = 0; i < directions.length; i++) {
            int ny = index + directions[i];
            minimumDP[nx][ny] = Math.min(minimumDP[nx][ny], minimumDP[x][index] + board[nx][ny]);
        }
    }

}
