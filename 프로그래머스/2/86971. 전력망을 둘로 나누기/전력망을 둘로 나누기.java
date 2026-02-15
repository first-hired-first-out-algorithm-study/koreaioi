import java.util.*;
import java.io.*;

class Solution {
    
    public static boolean[][] connections;
    public static boolean[] visited;
    public static int count;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        // init
        connections = new boolean[n+1][n+1];
        for(int[] wire : wires){
            int v1 = wire[0];
            int v2 = wire[1];
            connections[v1][v2] = true;
            connections[v2][v1] = true;
        }
        
        int startV1 = wires[0][0];
        for(int[] wire : wires){
            int v1 = wire[0];
            int v2 = wire[1];
            // dfs 시작 (visited && count 갱신)
            visited = new boolean[n+1];
            count = 1;
            connections[v1][v2] = false;
            connections[v2][v1] = false;
            dfs(startV1);
            int difference = calculatePowerTowerDifference(n, count);
            answer = Math.min(answer, difference);
            connections[v1][v2] = true;
            connections[v2][v1] = true;
        }
        
        return answer;
    }
    
    public static void dfs(int current){
        visited[current] = true;
        for(int next = 1 ; next < connections.length ;next++){
            if(connections[current][next] &&  !visited[next]){
                visited[next] = true;
                count++;
                dfs(next);
            }
        }
    }
    
    // 한 구역의 송전탑 개수 -> 송전탑 개수 차이를 구하는 메서드
    public static int calculatePowerTowerDifference(int n, int powerTowerCount){
        // 1. another = n - powerTowerCount
        // 2. another와 powerTowerCount의 절댓값 차이 return
        int another = n - powerTowerCount;
        return Math.abs(another - powerTowerCount);
    }
    
}