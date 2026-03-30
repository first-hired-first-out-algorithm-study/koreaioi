
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        dp = new int[n + 1];
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            if (i % 2 == 0) {
                min = Math.min(min, dp[i / 2]);
            }

            if (i % 3 == 0) {
                min = Math.min(min, dp[i / 3]);
            }

            min = Math.min(min, dp[i - 1]);
            dp[i] = min + 1;
        }


//        for (int i = 1; i <= n; i++) {
//            System.out.println(i + " : " + dp[i]);
//        }

        StringBuilder sb = new StringBuilder().append(dp[n]).append("\n");
        int currentIndex = n;
        while (currentIndex > 0) {
            sb.append(currentIndex).append(" ");
            if (currentIndex == 1) {
                break;
            }
            
            if (currentIndex % 3 == 0 && dp[currentIndex] - 1 == dp[currentIndex / 3]) {
                currentIndex /= 3;
                continue;
            }

            if (currentIndex % 2 == 0 && dp[currentIndex] - 1 == dp[currentIndex / 2]) {
                currentIndex /= 2;
                continue;
            }

            currentIndex -= 1;
        }

        System.out.println(sb);

    }

}
