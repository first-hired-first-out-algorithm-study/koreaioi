
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int n, target, count;
    public static int lt, rt;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        lt = 0;
        rt = n - 1;

        st = new StringTokenizer(br.readLine());
        target = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        while (lt < rt) {
            int value = arr[lt] + arr[rt];
            if (value < target) {
                lt++;
                continue;
            }

            if (value > target) {
                rt--;
                continue;
            }

            count++;
            lt++;
            rt--;
        }
        System.out.println(count);
    }

}
