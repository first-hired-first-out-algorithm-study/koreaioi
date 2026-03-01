import java.util.*;

class Solution {
    
    public static boolean[] visited;
    public static int answer;
    public static Queue<Word> q = new LinkedList<>();
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        q.add(new Word(begin, 0));
        
        return bfs(target, words);
    }
    
    public static int bfs(String target, String[] words){
        while(!q.isEmpty()){
            Word word = q.poll();    
            
            for(int i = 0 ; i < words.length; i++){
                if(!visited[i] && canChange(word.content, words[i])){
                    // System.out.println(words[i] + word.level);
                    if(words[i].equals(target)){
                        return ++word.level;
                    }
                    visited[i] = true;
                    q.add(new Word(words[i], word.level + 1));
                }
            }
        }
        return 0;
    }
    
    public static boolean canChange(String a, String b){
        char[] aCharArray = a.toCharArray();
        char[] bCharArray = b.toCharArray();
        
        int count = 0;
        for(int i = 0 ; i < aCharArray.length; i++){
            if(aCharArray[i] != bCharArray[i]){
                count++;
            }
        }
        
        return count == 1;
    }
    
    public static class Word{
        
        public String content;
        public int level;
        
        public Word(String content, int level){
            this.content = content;
            this.level = level;
        }
        
    }
}