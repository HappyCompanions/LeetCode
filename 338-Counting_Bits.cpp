class Solution {
public:
    vector<int> countBits(int num) {
        vector<int> res{0};
        for (int i = 1; i<=num; i++) {
          if (1 == i%2) {
              res.push_back(res[i/2]+1);
          } else {
              res.push_back(res[i/2]);
          }
        }
        return res;
    }
};
