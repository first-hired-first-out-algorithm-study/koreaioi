import java.util.*;

class Solution {
    
    class Truck {
        int weight;
        int move;
        
        Truck(int weight){
            this.weight = weight;
            this.move = 1;
        }
        
        public void moving(){
            this.move++;
        }
        
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int curWeight = 0;
        Queue<Truck> waitQ = new LinkedList<Truck>();
        Queue<Truck> moveQ = new LinkedList<Truck>();
        
        for(int x : truck_weights){
            waitQ.add(new Truck(x));
        }
        
        while(!waitQ.isEmpty() || !moveQ.isEmpty()){
            time++;
            
            for(Truck t : moveQ){
                t.moving();
            }
            
            // 건넌 트럭 빼기
            if(!moveQ.isEmpty() && moveQ.peek().move > bridge_length){
                curWeight -= moveQ.poll().weight;
            }
            
            // 다리 무게가 널널하면 추가
            if(!waitQ.isEmpty() && waitQ.peek().weight + curWeight <= weight){
                Truck next = waitQ.poll();
                curWeight += next.weight;
                moveQ.add(next);
            }
            
        }
        
        
        return time;
    }
}