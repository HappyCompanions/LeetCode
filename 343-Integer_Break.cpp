#include <algorithm>

class Solution {
public:
    int integerBreak(int n) {

        if (2 == n) {
            return 1;
        } else if (3 == n) {
            return 2;
        } else if (4 == n) {
            return 4;
        } else {
            int div = n/3, remain = n%3;
            if (1 == remain) {
                return pow(3, div-1) * 4;
            } else if (2 == remain) {
                return pow(3, div) * 2;
            } else {
                return pow(3, div);
            }
        }
    }
};