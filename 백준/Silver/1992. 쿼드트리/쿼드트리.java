
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static StringBuilder sb;
    public static int N;
    public static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        // 배열 채우기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        dfs(0, 0, N);

        System.out.println(sb.toString());


    }


    public static void dfs(int x, int y, int gap){

        int check = checkQuad(x, y, gap);
        if (check == 1) {
            sb.append(1);
        } else if (check == 0) {
            sb.append(0);
        } else{
            // 분할
            int div = gap/2;
            sb.append("(");
            dfs(x, y, div);
            dfs(x, y+div, div);
            dfs(x + div, y, div);
            dfs(x+div, y+div, div);
            sb.append(")");
        }

    }

    // 압축 가능한 지 or 분할 해야 하는 지 check
    public static int checkQuad(int x, int y, int gap){
        int firstNum = arr[x][y];

        for (int i = x; i < x + gap; i++) {
            for(int j = y; j < y + gap; j++){
                if(firstNum != arr[i][j]){
                    return -1;
                }
            }
        }
        return firstNum;
    }
}
