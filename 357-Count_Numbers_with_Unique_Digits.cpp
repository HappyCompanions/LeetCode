class Solution {
public:
    int countNumbersWithUniqueDigits(int n) {
        
        if (n > 9) {
            return countNumbersWithUniqueDigits(9);
        }
        
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 10;
        }
        
        int startWithZero = countNumbersWithUniqueDigits(n-1);
        int startWithNonZero = 9, r = 9;
        
        for(int i = 0; i < (n-1); i++) {
            startWithNonZero *= r--;
        }
        
        return startWithZero + startWithNonZero;
    }
};
