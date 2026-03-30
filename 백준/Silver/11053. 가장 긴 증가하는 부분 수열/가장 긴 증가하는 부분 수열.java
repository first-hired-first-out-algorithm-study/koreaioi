import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n + 1];
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            int max = 0; // arr과 비교
            for (int j = i; j > 0; j--) {
                if(arr[i] > arr[j]){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);

    }
}