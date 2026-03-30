
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int[] cardPack;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        cardPack = new int[n + 1];
        dp = new int[n + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            cardPack[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i]를 i장 구매할 때, 최대 비용으로 생각.
        dp[1] = cardPack[1];
        
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 0; j <= i; j++) {
                max = Math.max(max, dp[i - j] + cardPack[j]);
            }
            dp[i] = max;
        }

        System.out.println(dp[n]);
    }

}
