import java.util.*;

class Solution {
    public int[] solution(int[] answers) {        
        Person p1 = new Person(1, new int[]{1,2,3,4,5});
        Person p2 = new Person(2, new int[]{2,1,2,3,2,4,2,5});
        Person p3 = new Person(3, new int[]{3,3,1,1,2,2,4,4,5,5});
        ArrayList<Person> al = new ArrayList<Person>(List.of(p1, p2, p3));
        
        // 각자 채점
        al.stream().forEach(p -> p.gradeAnswerCount(answers));
        
        // 가장 많이 맞춘 개수
        int max = al.stream()
            .mapToInt(p -> p.answerCount)
            .max()
            .orElse(0);
        
        // 많이 맞춘 사람들 필터링 후 배열로 반환
        return al.stream()
            .filter(p -> p.answerCount == max)
            .mapToInt(p -> p.number)
            .toArray();
    }
    
    public static class Person{
        
        int number;
        int[] submittion;
        int answerCount;
        
        Person(int number, int[] submittion){ // 10,000 문제 -> int OK
            this.number = number;
            this.submittion = submittion;
        }
        
        public void gradeAnswerCount(int[] answers){
            int size = submittion.length;
            int count = 0;
            
            for(int i = 0 ; i < answers.length ; i++){
                if(answers[i] == submittion[i % size]){
                    count++;
                }
            }
            
            this.answerCount = count;
        }
    
    }
    
}