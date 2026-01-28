import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        ArrayList<Wallet> al = new ArrayList<>();
        
        for(int[] arr : sizes){
            Wallet wallet = new Wallet(arr[0], arr[1]);
            wallet.swap(); // 가로 세로 중 큰 값을 가로로 몰아넣기.
            al.add(wallet);
        }
        
        al.stream()
            .forEach(w -> System.out.println(w));
                
        int maxWidth = al.stream()
            .mapToInt(Wallet::getWidth)
            .max()
            .orElse(0);
        
        int maxLength = al.stream()
            .mapToInt(Wallet::getLength)
            .max()
            .orElse(0);
        
        return maxWidth * maxLength;
    }
    
    public static class Wallet{
        int width;
        int length;
        
        Wallet(int width, int length){
            this.width = width;
            this.length = length;
        }
        
        @Override
        public String toString(){
            return "width: " + width + ", length: " + length;
        }
        
        public void swap(){
            if(width < length){
                int tmp = this.width;
                this.width = this.length;
                this.length = tmp;
            }
        }
        
        public int getWidth(){
            return this.width;
        }
        
        public int getLength(){
            return this.length;
        }
        
    }
}