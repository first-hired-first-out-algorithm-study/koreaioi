
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

//    public static int[][] board;
    public static boolean[][] visited;
    public static Queue<Point> q;
    public static int[] dx = {-2, -1, -2, -1, 1, 2, 1, 2,};
    public static int[] dy = {1, 2, -1, -2, 2, 1, -2, -1};
    public static int t;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            visited = new boolean[n][n];
            q = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),0);

            st = new StringTokenizer(br.readLine());
            Point end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

            Point answer = bfs(start, end);
            sb.append(answer.level).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static Point bfs(Point start, Point end) {
        q.add(start);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Point point = q.poll();
                if (point.equals(end)) {
                    return point;
                }

                for (int j = 0; j < dx.length; j++) {
                    int ny = point.y + dx[j];
                    int nx = point.x + dy[j];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[ny][nx]) {
                        Point next = new Point(ny, nx, point.level + 1);
                        visited[ny][nx] = true;
                        q.add(next);
                    }
                }
            }
        }
        return null;
    }

    public static class Point {

        public int y;
        public int x;
        public int level;

        public Point(int y, int x, int level) {
            this.y = y;
            this.x = x;
            this.level = level;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}
