
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int stickCount = 0;
        int answer = 0;

        String stick = st.nextToken();
        char[] stickArray = stick.toCharArray();

        for (int i = 0; i < stickArray.length; i++) {
            char c = stickArray[i];
            if (c == '(') {
                stickCount++;
                continue;
            }

            if (c == ')') {
                char before = stickArray[i - 1];
                if (before == ')') {
                    stickCount--;
                    answer++;
                    continue;
                }

                if (before == '(') {
                    stickCount--;
                    answer += stickCount;
                    continue;
                }
            }
        }

        System.out.println(answer);
    }

}
