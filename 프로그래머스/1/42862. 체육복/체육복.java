import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // init
        int answer = n - lost.length;
        
        // Hint
        Arrays.sort(lost);
        Arrays.sort(reserve);
            
        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length;j++) {
                if(canBorrow(lost[i], reserve[j])) {
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        return answer;
    }
    
    public static boolean canBorrow(int lostNumber, int reserveNumber){
        return (lostNumber - 1 == reserveNumber) || (lostNumber + 1 == reserveNumber);
    }
    
}