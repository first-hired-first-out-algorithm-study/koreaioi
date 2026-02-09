import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> st = new Stack<Character>();

        for(char c : s.toCharArray()){
            if(c == ')'){
                if(st.isEmpty()){
                    return false;
                }else{
                    st.pop();
                }
            }else{
                st.push(c);
            }
        }

        return st.isEmpty() ? true : false;
    }
}