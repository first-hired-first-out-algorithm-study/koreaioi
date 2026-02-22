import java.util.*;

class Solution {
    
    public static int networkCount = 0;
    
    public int solution(int n, int[][] computers) {
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(computers[i][j] == 1){
                    findNetwork(i, j, computers);
                }
            }
        }
                
        return networkCount;
    }
    
    public static void findNetwork(int u, int v, int[][] computers){
        
        Queue<Edge> q = new LinkedList<>();
        q.add(new Edge(u, v));
        computers[u][v] = 0;
        computers[v][u] = 0;
        
        while(!q.isEmpty()){
            Edge e = q.poll();
            int next = e.v;   
            for(int i = 0 ; i < computers[next].length ; i++){
                if(computers[next][i] == 1){
                    q.add(new Edge(next, i));
                    computers[next][i] = 0;
                    computers[i][next] = 0;
                }
            }
            
        }
        networkCount++;
    }
    
    public static class Edge {
        int u;
        int v;
        Edge(int u, int v){
            this.u = u;
            this.v = v;
        }
    }
    
}