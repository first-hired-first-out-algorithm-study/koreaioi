import java.util.*;
import java.lang.Math.*;

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0 ; i < speeds.length ; i++){
            q.offer((int)Math.ceil((double)(100 - progresses[i]) / speeds[i]));
        }
        
        int count = 1;
        Integer num = q.poll();
        ArrayList al = new ArrayList();
        
        while(!q.isEmpty()){
            if(num >= q.peek()){
                count++;
                q.poll();
                continue;
            }else{
                al.add(count);
                count = 1;
                num = q.poll();
            }    
        }
        
        al.add(count);
        return al;
    }
}