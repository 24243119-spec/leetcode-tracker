// Last updated: 7/9/2026, 10:07:32 AM
class Solution {
    public boolean checkGoodInteger(int n) {
        int digitSum = 0;
        int sSum = 0;

        while (n>0){
            int digit = n %10;
            digitSum += digit;
            sSum += digit*digit;
            n/=10;
            
        }
        return(sSum - digitSum) >= 50;
        
    }
}