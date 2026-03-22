import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int[] stair;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        stair = new int[n];
        dp = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            stair[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = stair[0];
        if (n > 1) dp[1] = dp[0] + stair[1];
        if (n > 2) dp[2] = stair[2] + Math.max(stair[1], dp[0]);

        for (int i = 3; i < n; i++) {
            dp[i] = stair[i] + Math.max(dp[i-2], stair[i-1] + dp[i-3]);
        }

        System.out.println(dp[dp.length - 1]);
    }

}
