class Solution {
public:
    NestedInteger deserialize(string s) {
        
        vector<NestedInteger*> stack;

        int len = s.length();
        int sum = 0, negativeFlag = false, numberFlag = false;
        
        for(int i = 0; i < len; ++i) {
            
            if (s[i] == '[') {
                stack.push_back(new NestedInteger());
                continue;
            }
            
            if (s[i] == '-') {
                negativeFlag = true;
                continue;
            } else if (s[i] >= 48 && s[i] <= 57) {
                numberFlag = true;
                sum *= 10;
                sum += (s[i] - 48);
                continue;
            } else if (numberFlag) {
                if (negativeFlag) {
                    sum *= -1;
                    negativeFlag = false;
                }
                NestedInteger ns(sum);
                stack.back()->add(ns);
                sum = 0;
                numberFlag = false;
            }
            
            if (s[i] == ']') {
                NestedInteger *ptr = stack.back();
                stack.pop_back();
                if (stack.size() == 0) {
                    return *ptr;
                } else {
                    stack.back()->add(*ptr);
                }
            }
        }
        
        if (numberFlag) {
            if (negativeFlag) {
                sum *= -1;
            }
            NestedInteger ns(sum);
            if (stack.size() == 0) {
                return ns;
            } else {
                stack.back()->add(ns);    
            }
        }
        
        return *(stack.back());
    }
};
