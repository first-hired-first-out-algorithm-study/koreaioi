import java.util.*;

class Solution {
    
    public static ArrayList<Integer> al;
    
    public int solution(int[] citations) {
        al = new ArrayList<Integer>();
        for(int x : citations){
            al.add(x);
        }
        
        int answer = 0;
        int n = citations.length;
        Collections.sort(al);
        Arrays.sort(citations);
        
        // 0 1 3 5 6
        for(int i = 0 ; i < n ; i++){
            int h = n - i; // H-index 후보
            
            if(citations[i] >= h){
                return h;
            }
        }
        
        return 0;
    }
    
}