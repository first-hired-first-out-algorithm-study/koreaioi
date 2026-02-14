import java.util.*;
import java.io.*;

class Solution {
    
    public static final int CONDITION_TIREDNESS_INDEX = 0;
    public static final int CONSUME_TIREDNESS_INDEX = 1;
    public static int myTiredness;
    public static boolean[] visited;
    public static int maxCount = 0;
    
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        myTiredness = k;
        visited = new boolean[dungeons.length];
        
        dfs(0, 0, dungeons);
        
        return maxCount;
    }
    
    public static void dfs(int level, int count, int[][] dungeons){
        if(level == dungeons.length){
            maxCount = Math.max(maxCount, count);
            return;
        }
        
        for(int i = 0 ; i < dungeons.length ; i++){
            if(visited[i]){
                continue;
            }
            int[] dungeon = dungeons[i];
            if(canExploreDungeon(dungeon[CONDITION_TIREDNESS_INDEX])){
                consumeMyTiredness(dungeon[CONSUME_TIREDNESS_INDEX]);
                visited[i] = true;
                dfs(level + 1, count + 1, dungeons);
                visited[i] = false;
                recoverMyTiredness(dungeon[CONSUME_TIREDNESS_INDEX]);
                continue;
            }
            
            dfs(level + 1, count, dungeons);
        }
    }
    
    public static boolean canExploreDungeon(int minimumRequiredTiredness){
        if(myTiredness < minimumRequiredTiredness){
            return false;
        }
        
        return true;
    }
    
    public static void consumeMyTiredness(int dungeonTiredness){
        myTiredness -= dungeonTiredness;
    }
    
    public static void recoverMyTiredness(int dungeonTiredness){
        myTiredness += dungeonTiredness;
    }
    
}