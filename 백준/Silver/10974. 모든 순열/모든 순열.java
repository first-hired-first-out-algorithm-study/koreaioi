import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static boolean[] visited;
    public static int[] answer;
    public static StringBuilder sb;
    public static int n;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        sb = new StringBuilder();

        visited = new boolean[n + 1];
        answer = new int[n + 1];
        dfs(1);

    }

    public static void dfs(int level) {
        if (level == n + 1) {
            printAnswer();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                answer[level] = i;
                visited[i] = true;
                dfs(level + 1);
                visited[i] = false;
            }
        }
    }

    public static void printAnswer() {
        for (int i = 1; i <= n; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
        sb = new StringBuilder();
    }

}
