import java.io.IOException;
import java.util.*;

public class Main {

    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int[] TOOLS = new int[]{ONE, TWO, THREE};
    
    public static int bound; // bound == target인데 의미가 달라서 분리해봄
    public static int target;
    public static int count;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // 테스트 케이스
        for (int i = 0; i < t; i++) {
            target = scanner.nextInt();
            bound = target;
            count = 0;
            dfs(0);
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int sum) {
        if (sum > bound) {
            return;
        }

        if (sum == bound) {
            count++;
            return;
        }

        for (int value : TOOLS) {
            dfs(sum + value);
        }
    }

}
