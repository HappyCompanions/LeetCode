class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& A) {
        int totalCount = 0;
        int maxIndex = 0;

        for (int i = 2; i < A.size(); ++i) {
            if ((A[i] - A[i-1]) == (A[i-1] - A[i-2])) {
                A[maxIndex++] = i;
                totalCount++;
            }
        }

        while(maxIndex != 0) {
            int index = 0;
            for (int i = 0; i < (maxIndex-1); ++i) {
                if (A[i] == (A[i+1] - 1)) {
                    A[index++] = A[i+1];
                    totalCount++;
                }
            }
            maxIndex = index;
        }

        return totalCount;
    }
};
