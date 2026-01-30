import java.util.*;
import java.util.stream.*;

class Solution {
    
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int length = board.length;
        String myColor = board[h][w];
        
        for (int i = 0; i < 4; i++) {
            int nh = h + dx[i];
            int nw = w + dy[i];

            if (nh >= 0 && nh < length && nw >= 0 && nw < length) {
                answer += myColor.equals(board[nh][nw]) ? 1 : 0;
            }
        }
        
        return answer;
    }
}