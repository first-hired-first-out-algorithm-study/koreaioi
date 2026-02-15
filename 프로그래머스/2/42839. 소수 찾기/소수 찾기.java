import java.util.*;
import java.io.*;

class Solution {
    
    public static char[] charArray;
    public static boolean[] visited;
    public static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) throws IOException{
        charArray = numbers.toCharArray();
        visited = new boolean[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            visited[i] = true;
            dfs(0, toInt(charArray[i]));
            visited[i] = false;
        }

        return set.size();
    }
    
    public static void dfs(int level, int number) {
        if (isPrime(number)) {
            set.add(number);
        }

        if (level == charArray.length) {
            return;
        }

        for (int i = 0; i < charArray.length; i++) {
            if (!visited[i]) {
                int suffix = toInt(charArray[i]);
                visited[i] = true;
                dfs(level + 1, addSuffixNumber(number, suffix));
                visited[i] = false;
            }
        }
    }
    
    public static int toInt(char num) {
        return num - '0';
    }

    public static int addSuffixNumber(int number, int suffix) {
        String stringNumber = String.valueOf(number) + String.valueOf(suffix);
        return Integer.parseInt(stringNumber);
    }

    /** 소수 판별 */
    public static boolean isPrime(String stringNumber) {
        return isPrime(Integer.parseInt(stringNumber));
    }

    public static boolean isPrime(int number){
        if (number == 1 || number == 0) {
            return false;
        }

        for (int quotient  = 2; quotient <= Math.sqrt(number); quotient++) {
            if (isDivided(number, quotient)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isDivided(int number, int quotient) {
        return number % quotient == 0;
    }
    
}