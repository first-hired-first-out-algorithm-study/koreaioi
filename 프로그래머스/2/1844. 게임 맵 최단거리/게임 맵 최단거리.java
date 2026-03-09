import java.util.*;

class Solution {
    
    public static boolean[][] visited;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {1, -1, 0, 0};
    public static int n;
    public static int m;
    
    public int solution(int[][] maps) {
        n = maps[0].length;
        m = maps.length;
        
        visited = new boolean[m][n];
        return dfs(new Point(0,0), maps);
    }
    
    public static int dfs(Point point, int[][] maps){
        
        Queue<Point> q = new LinkedList<>();
        q.add(point);
        visited[point.x][point.y] = true;
        
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                Point p = q.poll();
                if(p.x == m - 1 && p.y == n - 1){  // 도착 했는 지 검증
                    return ++level;
                }
                
                for(int j = 0 ; j < 4; j++){
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];
                    if(nx >= 0 && nx < m && ny >= 0 && ny < n 
                       && maps[nx][ny] == 1 && !visited[nx][ny]){
                        q.add(new Point(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
        
            }
            level++;
        }
        return -1;
    }
    
    public static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
}