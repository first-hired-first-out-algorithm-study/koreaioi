import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for(String str : participant){
            hm.put(str, hm.getOrDefault(str, 0) + 1);
        }
        
        for(String str : completion){
            hm.put(str, hm.get(str) - 1);
        }
        
        for(String str : hm.keySet()){
            if(hm.get(str) > 0){
                return str;
            }
        }
        
        return answer;
    }
}