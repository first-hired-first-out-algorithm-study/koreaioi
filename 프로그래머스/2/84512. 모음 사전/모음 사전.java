import java.util.*;
import java.io.*;

class Solution {
    
    public static char[] alphabets = new char[]{'A', 'E','I', 'O', 'U'};
    public static String target;
    public static int order = 0;
    public static int answer = 0;
    
    public int solution(String word) {
        dfs(0, "", word);
        return answer - 1;
    }
    
    public static void dfs(int level, String str, String target){
        // System.out.println(str);
        order++;
        if(str.equals(target)){
            answer = order;
            return;
        }
        
        if(level == alphabets.length){
            return;
        }
        
        for(int i = 0 ; i < alphabets.length ; i++){
            dfs(level + 1, str + alphabets[i], target);
        }
        
    }
    
    
}