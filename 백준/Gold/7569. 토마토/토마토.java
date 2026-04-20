
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int[][][] farm;
    public static boolean[][][] visited;
    public static int m, n, h;

    public static int[] dx = {1, -1, 0, 0, 0, 0};
    public static int[] dy = {0, 0, 1, -1, 0, 0};
    public static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Tomato> q = new LinkedList<>();

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        farm = new int[h][n][m];
        visited = new boolean[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    int value = Integer.parseInt(st.nextToken());
                    farm[i][j][k] = value;
                    if (value == 1) {
                        q.add(new Tomato(i, j, k));
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            Tomato tomato = q.poll();

            for (int i = 0; i < dx.length; i++) {
                int nz = tomato.z + dz[i];
                int ny = tomato.y + dy[i];
                int nx = tomato.x + dx[i];
                if (nz >= 0 && nz < h && ny >= 0 && ny < n && nx >= 0 && nx < m
                        && !visited[nz][ny][nx] && farm[nz][ny][nx] == 0) {
                    visited[nz][ny][nx] = true;
                    farm[nz][ny][nx] = farm[tomato.z][tomato.y][tomato.x] + 1;
                    q.add(new Tomato(nz, ny, nx));
                }
            }
        }

//        for (int i = 0; i < h; i++) {
//            for (int j = 0; j < n; j++) {
//                for (int k = 0; k < m; k++) {
//                    System.out.print(farm[i][j][k]);
//                }
//                System.out.println();
//            }
//        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (farm[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(max, farm[i][j][k]);
                }
            }
        }

        System.out.println(max - 1);
    }

    static class Tomato {
        int z;
        int y;
        int x;

        public Tomato(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }

}
