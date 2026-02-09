import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static boolean[] visited;
    public static int[] tools;
    public static int n, target, count;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        tools = new int[n + 1];

        // initialize
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            tools[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, 0);
        if (target == 0) {
            System.out.println(count - 1);
            return;
        }

        System.out.println(count);
    }

    public static void dfs(int level, int sum) {
        if (level == n + 1) {
            if (sum == target) {
//                printArray(tools);
                count++;
            }
            return;
        }

        dfs(level + 1, sum + tools[level]);
        dfs(level + 1, sum);
    }

    public static void printArray(int[] arr) {
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                System.out.print("0 ");
            }else{
                System.out.print(tools[i] + " ");
            }
        }
        System.out.println();
    }

}
