import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[10001];
        int[] dp = new int[10001];



        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }


        dp[1] = arr[1];
        dp[2] = dp[1]+arr[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i-1], (Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i]));
        }

        System.out.println(dp[n]);



    }
}