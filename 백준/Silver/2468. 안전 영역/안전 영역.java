import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int n, limit, min, max, count, answer;
    public static int[][] area;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static boolean[][] visited;
    public static Queue<Point> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        area = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int height = Integer.parseInt(st.nextToken());
                area[i][j] = height;
                min = Math.min(height, min);
                max = Math.max(height, max);
            }
        }

        for (limit = min; limit <= max; limit++) {
            // bfs 실행
            visited = new boolean[n][n];
            count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 아직 미방문 && 잠기지 않은 구역
                    if(!visited[i][j] &&  !isSink(area[i][j])){
                        visited[i][j] = true;
                        bfs(i, j); // 해당 안전 영역 방문표시
                        count++;
                    }
                }
            }
            answer = Math.max(count, answer);
        }

        System.out.println(answer);
    }

    public static void bfs(int x, int y) {
        int height = area[x][y];
        q.add(new Point(x, y, height));

        while (!q.isEmpty()) {
            Point point = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (checkBound(nx, ny) && !visited[nx][ny] && !isSink(area[nx][ny])) {
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny, area[nx][ny]));
                }
            }
        }
    }

    public static boolean isSink(int areaHeight) {
        return areaHeight <= limit;
    }

    public static boolean checkBound(int nx, int ny) {
        return nx >= 0 && nx < n && ny >= 0 && ny < n;
    }

    public static class Point{
        int x;
        int y;
        int height;

        Point(int x, int y, int height){
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }

}
