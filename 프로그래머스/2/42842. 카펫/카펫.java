class Solution {
    
    public static int sum, width, length ;
    
    public int[] solution(int brown, int yellow) {
        sum = brown + yellow;
        for (int i = 3; i <= 5000; i++) {
            if (sum % i == 0) {
                int a = i;
                int b = sum / i;
                int perimeter = calculatePerimeter(a, b);
                if (brown == perimeter) {
                    width = Math.max(a, b);
                    length = Math.min(a, b);
                    break;
                }
            }
        }
        return new int[]{width, length};
    }
    
    public static int calculatePerimeter(int a, int b) {
        return 2 * a + 2 * b - 4;
    }
}