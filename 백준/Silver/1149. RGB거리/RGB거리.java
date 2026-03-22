import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    public static int n;
    public static int[][] rgb;
    public static int[][] dp;
    public static final int NUMBER_OF_RGB = 3;
    public static int[][] directions = new int[][]{new int[]{1, 2}, new int[]{0, 2}, new int[]{0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        rgb = new int[n][NUMBER_OF_RGB];
        dp = new int[n][NUMBER_OF_RGB];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < NUMBER_OF_RGB; j++) {
                rgb[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.arraycopy(rgb[0], 0, dp[0], 0, 3);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < NUMBER_OF_RGB; j++) {
                dp[i][j] = rgb[i][j] + compareColor(i, directions[j]);
            }
        }

        int answer = Arrays.stream(dp[n - 1])
                .min()
                .getAsInt();
        System.out.println(answer);
    }
    
    public static int compareColor(int x, int[] direction) {
        return Math.min(dp[x - 1][direction[0]], dp[x - 1][direction[1]]);
    }

}
