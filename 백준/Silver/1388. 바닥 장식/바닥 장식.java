
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int[] dx = {1, -1};
    public static int[] dy = {1, -1};
    public static int n, m, count; // 세로, 가로
    public static char[][] board;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // initialize
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && (board[i][j] == '-' || board[i][j] == '|')) {
                    bfs(i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] point = q.poll();
            char c = board[point[0]][point[1]];
            if (c == '-') {
                for (int i = 0; i < 2; i++) {
                    int nx = point[0];
                    int ny = point[1] + dy[i];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && board[nx][ny] == '-') {
//                        System.out.println(nx + " " + ny);
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }else{ // c == '|'
                for (int i = 0; i < 2; i++) {
                    int nx = point[0] + dx[i];
                    int ny = point[1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && board[nx][ny] == '|') {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }

}
